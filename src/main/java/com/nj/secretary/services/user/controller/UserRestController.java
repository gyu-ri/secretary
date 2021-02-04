package com.nj.secretary.services.user.controller;

import com.nj.secretary.services.alarm.domain.Alarm;
import com.nj.secretary.services.alarm.service.AlarmService;
import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import javax.servlet.http.HttpSession;

@RestController//반환 값이 단순 문자열과 Json이다.
@RequestMapping("/restUser/*")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AlarmService alarmService;

    @ResponseBody//서버로 보낸 json데이터를 자바 객체로 매핑
    @GetMapping("/idCheck")
    public int idCheck(@RequestParam("userId") String userId) throws Exception{
        int count = userService.idCheck(userId);
        return userService.idCheck(userId);
    }

    @PostMapping("/CheckMail")
    @ResponseBody //ajax이후 다시 응답을 보내는게 아니기 때문에 적어줘야함.
    public String SendMail(String mail) throws Exception{

        Random random = new Random();//난수 생성을 위한 랜덤 클래스
        String key=""; //인증번호

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);//스크립트에서 보낸 메일을 받을 사용자 이메일 주소

        for (int i=0; i<3; i++){
            int index = random.nextInt(25)+65;//A~Z까지 랜덤 알파벳 생성
            key+=(char)index;
        }
        int numIndex= random.nextInt(9999)+1000;//4자리 랜덤 정수를 생성
        key+=numIndex;
        message.setSubject("Secretary 회원가입용 인증번호입니다.");
        message.setText("인증번호 : "+key);
        mailSender.send(message);
        return key;
    }

    @PostMapping("/CheckCertification")
    @ResponseBody //ajax이후 다시 응답을 보내는게 아니기 때문에 적어줘야함.
    public String SendMail01(String mail) throws Exception{

        Random random = new Random();//난수 생성을 위한 랜덤 클래스
        String key=""; //인증번호

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);//스크립트에서 보낸 메일을 받을 사용자 이메일 주소

        for (int i=0; i<3; i++){
            int index = random.nextInt(25)+65;//A~Z까지 랜덤 알파벳 생성
            key+=(char)index;
        }
        int numIndex= random.nextInt(9999)+1000;//4자리 랜덤 정수를 생성
        key+=numIndex;
        message.setSubject("Secretary 비밀번호찾기 인증번호입니다.");
        message.setText("인증번호 : "+key);
        mailSender.send(message);
        return key;
    }

    @GetMapping("limitUser")
    public List<User> limitUser(Model model){
        System.out.println("admin User start in Restcontroller");
        List<User> blindedUserList = userService.getBlindedUserList();
        System.out.println("blindedUserList : " + blindedUserList);

        model.addAttribute("blindedUserList", blindedUserList);

        return blindedUserList;
    }

    @GetMapping("getLimitedUser")
    public List<User> getLimitedUser(Model model){
        System.out.println("getLimitedUser start in Restcontroller");
        List<User> getLimitedUserList = userService.getLimitedUserList();
        System.out.println("getLimitedUserList : " + getLimitedUserList);

        model.addAttribute("getLimitedUserList", getLimitedUserList);

        return getLimitedUserList;
    }

    @GetMapping("getLimitDateOverUser")
    public List<User> getLimitDateOverUser(Model model){
        System.out.println("getLimitDateOverUser start in Restcontroller");
        List<User> getLimitDateOverUser = userService.getLimitDateOverUser();
        System.out.println("getLimitDateOverUser : " + getLimitDateOverUser);

        model.addAttribute("getLimitDateOverUser", getLimitDateOverUser);

        return getLimitDateOverUser;
    }

    @PostMapping("setShareLimit")
    public int setShareLimit(@RequestBody String id){
        System.out.println("user limit set check : " + id);
        String[] text = id.split("&");
        String userId = text[0].split("=")[1];
        int blindStatus = Integer.parseInt(text[1].split("=")[1]);

        System.out.println("userId : " + userId + "blindStatus : " + blindStatus);

        Map map = new HashMap();
        Alarm alarm = new Alarm();
        if(blindStatus == 2){
             map.put("userId", userId);
             map.put("period", 7);
            alarm.setAlarmText("공유기능이 7일간 제한됬습니다.");
        }else if(blindStatus == 3){
            map.put("userId", userId);
            map.put("period", 30);
            alarm.setAlarmText("공유기능이 30일간 제한됬습니다.");
        }else if(blindStatus == 4){
            map.put("userId", userId);
            map.put("period", 365);
            alarm.setAlarmText("공유기능이 1년간 제한됬습니다.");
        }else if(blindStatus >= 5){
            map.put("userId", userId);
            map.put("period", 3650);
            alarm.setAlarmText("공유기능이 10년간 제한됬습니다.");
        }
        userService.setLimit(map);


        alarm.setUserId(userId);
        alarm.setAlarmType("3");

        alarmService.shareLimitAlarm(alarm);
       //int i = userService.setShareLimit(userId);
        System.out.println("setShareLimit from UserRestController finish");

        return 1;
    }

    @PostMapping("releaseShareLimit")
    public int releaseShareLimit(@RequestBody String id) {
        System.out.println("user limit release check : " + id);
        String userId = id.split("=")[1];
        System.out.println(userId);

        userService.releaseShareLimit(userId);
        System.out.println("releaseShareLimit from UserRestController finish");

        return 1;
    }
    
    @PostMapping("pwdCheck")
    public String pwdCheck(@RequestBody User user, HttpSession session) throws Exception{
    	System.out.println("UserRestController pwdCheck 시작"+user);
    	session.setAttribute("user", "gyuri");
    	user.setUserId((String)session.getAttribute("user"));
    	userService.pwdCheck(user);
    	
    	return "비밀번호 확인 되었습니다.";
    }

    @PostMapping("changePassword")
    public String changePassword(@RequestBody User user) throws Exception{
    	userService.changePassword(user);
    	System.out.println("changePassword 확인::"+user);
    	
    	return "변경이 완료 되었습니다.";
    }
    
    @PostMapping("withdrawalReason")
    public String withdrawalReason(@RequestBody User user) throws Exception {
    	//user.setWithdrawalReasonId(withdrawalReasonId);
    	userService.withdrawalReason(user);
    	    	
    	System.out.println("restController에서 탈퇴사유 확이이이인::::"+user);
    	return "탈퇴가 완료 되었습니다.";
    	
    }
}
