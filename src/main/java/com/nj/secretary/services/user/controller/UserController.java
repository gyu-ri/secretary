package com.nj.secretary.services.user.controller;

//import com.nj.secretary.services.user.domain.JavaMailSendar;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;

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
        return "index";
    }

    @GetMapping ("/email")
    public String emailPage() throws Exception{
        return "user/findId";
    }

    @PostMapping("/findId")
    public ModelAndView sendEmailAction(@RequestParam Map<String,Object> paramMap, ModelMap model, ModelAndView mv) throws Exception{

        String USERNAME = (String) paramMap.get("username");
        String EMAIL = (String) paramMap.get("email");
        String USERID = "1111";

        try{
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(msg,true,"UTF-8");

            messageHelper.setSubject(USERNAME+"님 아이디찾기 메일입니다.");
            messageHelper.setText("아이디는"+USERID+"입니다.");
            messageHelper.setTo(EMAIL);
            msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(EMAIL));
            mailSender.send(msg);
        }catch (MessagingException e){
            System.out.println("MessagingException");
            e.printStackTrace();
        }
        //mv.setViewName("redirect:/emailSuccess");
        mv.setViewName("emailSuccess");
        return mv;
    }

}
