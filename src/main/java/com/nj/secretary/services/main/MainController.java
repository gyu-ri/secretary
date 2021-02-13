package com.nj.secretary.services.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index(HttpSession session){
        if(session.getAttribute("user") != null) {
            return "user/afterLogin";
        }else{
            return "index";
        }

    }

}
