package com.nj.secretary.services.user.controller;

import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signUp")
    public String signUp() throws Exception{

        return "user/addUser";
    }

    @PostMapping("/signUp")
    public String signUp01(User user) throws Exception{
        System.out.println(user);
        userService.addUser(user);
        return "user/addUser";
    }

    @ResponseBody//서버로 보낸 json데이터를 자바 객체로 매핑
    @PostMapping
    public int IdCheck(@RequestBody String userId) throws Exception{
        int count = 0;
        if(userId != null) count = userService.idCheck(userId);
        return count;
    }

    @GetMapping("/login")
    public String login() throws Exception{
        return "user/login";
    }

    @PostMapping("/login")
    public String login01(User user, HttpSession session) throws Exception{
        User dbUser = userService.getUser(user.getUserId());
        if(user.getPassword().equals(dbUser.getPassword())){
            session.setAttribute("user",dbUser);
        }
        return "user/afterLogin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        session.invalidate();
        return "home";
    }

//    @GetMapping("/findId")
//    public String findId(User user) throws Exception{
//
//    }
}
