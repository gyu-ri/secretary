package com.nj.secretary.services.alarm.controller;


import com.nj.secretary.services.alarm.domain.Alarm;
import com.nj.secretary.services.alarm.service.AlarmService;
import com.nj.secretary.services.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restAlarm/*")
public class AlarmRestController {

    @Autowired
    AlarmService alarmService;

    @GetMapping("getAlarmList")
    public List<Alarm> getAlarmList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        System.out.println("user : " + user);
        return alarmService.getAlarmList(user.getUserId());
    }

    @PostMapping("seenDiaryAlarm")
    public void seenDiaryAlarm(@RequestBody String json){
        System.out.println("Check parameter : " + json);
        int diaryId = Integer.parseInt(json.split("=")[1]);

        alarmService.seenDiaryAlarm(diaryId);
    }

    @PostMapping("seenMonologueAlarm")
    public void seenMonologueAlarm(@RequestBody String json){
        System.out.println("Check parameter : " + json);
        int monologueId = Integer.parseInt(json.split("=")[1]);

        alarmService.seenMonologueAlarm(monologueId);
    }

    @GetMapping("getLimitReasons")
    public List<Alarm> getLimitReasons(@RequestParam("userId") String id){

        System.out.println("parameter check : " + id);
        List<Alarm> diary = alarmService.getLimitReasonsOfDiary(id);
        List<Alarm> monologue = alarmService.getLimitReasonsOfMonologue(id);
        List<Alarm> limitReasonsList = new ArrayList<Alarm>();
        limitReasonsList.addAll(diary);
        limitReasonsList.addAll(monologue);
        alarmService.seenLimitReasons(id);

        return limitReasonsList;
    }

    @PostMapping("deleteAlarmList")
    public void deleteAlarmList(@RequestBody String id){
        System.out.println("parameter check from deleteAlarmList : " + id);
        String userId = id.split("=")[1];
        System.out.println("next check : " + userId);

        alarmService.deleteAlarmList(userId);
    }
}
