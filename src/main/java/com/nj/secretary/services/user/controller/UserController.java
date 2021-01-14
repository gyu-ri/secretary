package com.nj.secretary.services.user.controller;

import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @GetMapping("/singUp")
    public String signUp() throws Exception{

        return "addUser";
    }

    @PostMapping("/singUp")
    public String signUp01(User user) throws Exception{
        System.out.println(user);
        userService.addUser(user);
        return "addUser";
    }
}
