package com.nj.secretary.services.main;

import com.nj.secretary.services.alarm.service.AlarmService;
import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;
import com.nj.secretary.services.monologue.service.MonologueService;
import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AlarmService alarmService;
    @Autowired
    private MonologueService monologueService;

    @RequestMapping(value = "/")
    public String index(HttpSession session, Model model) throws Exception{
        if(session.getAttribute("user") != null) {
            User login = (User)session.getAttribute("user");
            Monologue monologue = new Monologue();
            monologue.setUserId(login.getUserId());
            if(login.getRoles().trim().equals("ADMIN")){
                // 알람 시작
                int alarmCount = alarmService.alarmCount(login.getUserId());
                model.addAttribute("count", alarmCount);
                System.out.println("count check : " + alarmCount);
                // 알람 끝
                model.addAttribute("user", login);
                return "user/adminAfterLogin";
            }else {
                if (monologueService.checkMonologue(login.getUserId()) > 0) {
                    // 알람 시작
                    int alarmCount = alarmService.alarmCount(login.getUserId());
                    model.addAttribute("count", alarmCount);
                    System.out.println("count check : " + alarmCount);
                    // 알람 끝
                    System.out.println("Already wrote Monologue");
                    Question question = new Question();
                    model.addAttribute("user", login);
                    model.addAttribute("question", question);
                    return "user/afterLogin";
                } else {
                    Random random = new Random();
                    System.out.println("didn't write Monologue");
                    while (true) {
                        int ran = random.nextInt(100) + 1;
                        monologue.setQuestionId(ran);
                        if (monologueService.randomCheck(monologue) == 0) {
                            // 알람 시작
                            int alarmCount = alarmService.alarmCount(login.getUserId());
                            model.addAttribute("count", alarmCount);
                            System.out.println("count check : " + alarmCount);
                            // 알람 끝
                            model.addAttribute("question", monologueService.getQuestionText(ran));
                            model.addAttribute("user", login);
                            return "user/afterLogin";
                        }
                        if (monologueService.randomCheck(monologue) == 100) {
                            // 알람 시작
                            int alarmCount = alarmService.alarmCount(login.getUserId());
                            model.addAttribute("count", alarmCount);
                            System.out.println("count check : " + alarmCount);
                            // 알람 끝
                            Question question = new Question();
                            model.addAttribute("user", login);
                            model.addAttribute("question", question);
                            model.addAttribute("user", login);
                            return "user/afterLogin";
                        }
                    }
                }
            }
        }else{
            return "index";
        }

    }

}
