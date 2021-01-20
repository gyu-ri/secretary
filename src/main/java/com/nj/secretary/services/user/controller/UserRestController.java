package com.nj.secretary.services.user.controller;

import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController//반환 값이 단순 문자열과 Json이다.
@RequestMapping("/restUser/*")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;

    @ResponseBody//서버로 보낸 json데이터를 자바 객체로 매핑
    @GetMapping("/idCheck")
    public int idCheck(@RequestParam("userId") String userId) throws Exception{
        System.out.println(userId);
        int count = userService.idCheck(userId);
        System.out.println(userId);
        //if(userId != null) count = ;
        System.out.println(count);
        return userService.idCheck(userId);
    }

//    @PostMapping("/signUp")
//    @ResponseBody
//    public void SendMail(String mail) throws Exception{
//        Random random = new Random();//난수 생성을 위한 랜덤 클래스
//        String key=""; //인증번호
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(mail);//스크립트에서 보낸 메일을 받을 사용
//
//        for (int i=0; i<3; i++){
//            int index = random.nextInt(25)+65;
//            key+=(char)index;
//        }
//        int numIndex= random.nextInt(9999)+1000;//4자리 랜덤 정수를 생성
//        key+=numIndex;
//        message.setSubject("인증번호입니다.");
//        message.setText("인증번호 : "+key);
//        mailSender.send(message);
//    }

}
