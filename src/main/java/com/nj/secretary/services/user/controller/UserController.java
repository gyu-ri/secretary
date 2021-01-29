package com.nj.secretary.services.user.controller;

import com.nj.secretary.services.alarm.service.AlarmService;
import com.nj.secretary.services.monologue.domain.Monologue;
import org.json.JSONObject;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AlarmService alarmService;

    @GetMapping("/signUp")
    public String signUp() throws Exception {

        return "user/addUser";
    }

    @PostMapping("signUp")
    public String signUp01(@Valid User user, Errors errors, Model model) throws Exception {
       /* if (errors.hasErrors()){
            //회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("user",user);

            //유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }
        }*/
        System.out.println(user);
        userService.addUser(user);
        return "user/login";
    }

    @GetMapping("/login")
    public String login() throws Exception {
        return "user/login";
    }

    @PostMapping("/login")
    public String login01(User user, HttpSession session,Model model) throws Exception {
        User dbUser = userService.getUser(user.getUserId());
        if (user.getPassword().equals(dbUser.getPassword())) {
            session.setAttribute("user", dbUser);
        }
        // 수정한 부분 시작
        int alarmCount = alarmService.alarmCount("user02");
        model.addAttribute("count", alarmCount);
        System.out.println("count check : " + alarmCount);
        // 수정한 부분 끝
        return "user/afterLogin";
        //return "index";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "index";
    }

    @GetMapping("/findId")
    public String findId() throws Exception {
        return "user/findId";
    }

    @PostMapping("findId")
    public String findIdMailSend(@RequestParam Map<String, Object> paramMap)
            throws Exception {

        String userName = (String) paramMap.get("userName");
        String email = (String) paramMap.get("email");
        System.out.println(userName);
        User dbUser = userService.findUserId(userName);
        System.out.println(dbUser);
        if (email.equals(dbUser.getEmail())) {
            String userId = dbUser.getUserId();
            System.out.println(userId);
            try {
                MimeMessage msg = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");

                messageHelper.setSubject(userName + "님 아이디찾기 메일입니다.");//메일 제목
                messageHelper.setText("아이디는" + userId + "입니다.");//메일 내용
                messageHelper.setTo(email);
                msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
                mailSender.send(msg);
            } catch (MessagingException e) {
                System.out.println("MessagingException");
                e.printStackTrace();
            }
        } else {
            System.out.println("일치하는 정보 없음");
        }
        return "user/emailSuccess";
    }

    @GetMapping("/findPwd")
    public String findPwd() throws Exception {
        return "user/findPwd";
    }

    @PostMapping("/findPwd")
    public String findPwd01(String userName) throws Exception {
        userService.findUserPwd(userName);
        return "user/changePwd";
    }


    @GetMapping("/kakaologin")
    public String kakaoGetToken(@RequestParam("code") String code, Model model) throws IOException {
        //String access_Token = "";
        //String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        System.out.println("code" + code);

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=aceb8c76e94a93fae1034661828f1e34");
            sb.append("&redirect_uri=http://localhost:9090/user/kakaologin");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            //    결과 코드가 401일시 에러 :
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성

            JSONObject jsonObject = new JSONObject(result);

            System.out.println(jsonObject);
            System.out.println(jsonObject.get("access_token"));
            System.out.println(jsonObject.get("refresh_token"));
            model.addAttribute("accessToken", jsonObject.get("access_token"));

            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("변환에 실패");
            e.printStackTrace();
        }

        return "user/login";
    }

    @GetMapping("/getUser")
    public String getUser(String userId, Model model, HttpSession session) throws Exception {
        System.out.println("getUser 내정보보기 Controller 시작");
        session.setAttribute("userId", "gyuri");
        User user = userService.getUser((session.getAttribute("userId")).toString());
        model.addAttribute("user", user);
        System.out.println("userId 받아오나요" + userId);
        System.out.println("user" + user);
        return "user/getUser";
    }

    @GetMapping("/adminUser")
    public String adminUser(Model model) throws Exception {
        System.out.println("admin User start in controller");
        List<User> blindedUserList = userService.getBlindedUserList();
        System.out.println("blindedUserList : " + blindedUserList);

        model.addAttribute("blindedUserList", blindedUserList);

        return "user/adminUser";
    }
    
    @GetMapping("updateUser")
    public String updateUser(@RequestParam("userId") String userId, Model model) throws Exception{
    	System.out.println("updateUser controller 시작 합니다");
    	
    	User user=userService.getUser(userId);
    	
    	model.addAttribute("user",user);
    	
    	System.out.println("updateUser에서 userId 확인"+userId);
    	
    	System.out.println("updateUser  확인"+user);
    	
    	return "user/updateUser";
    }
    
    @PostMapping("updateUser")
    public String updateuser(User user, Model model) throws Exception{
    	userService.updateUser(user);
    	System.out.println("updateUser 확인::"+user);
    	
    	return "user/getUser";
    	
    	
    }

    @GetMapping("getWithdrawalReasonList")
    public String getWithdrawalReasonList(Model model){
        System.out.println("getWithdrawalReasonList in userController start");
        List<User> list = userService.getWithdrawalReasonList();
        System.out.println("getWithdrawalReasonList : " + list);
        model.addAttribute("list", list);

        return "user/getWithdrawalReasonList";

    }
}
