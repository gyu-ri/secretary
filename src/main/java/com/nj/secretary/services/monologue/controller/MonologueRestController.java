package com.nj.secretary.services.monologue.controller;

import com.nj.secretary.services.alarm.domain.Alarm;
import com.nj.secretary.services.alarm.service.AlarmService;
import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.service.MonologueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/restMonologue/*")
public class MonologueRestController {

    @Autowired
    MonologueService monologueService;
    @Autowired
    AlarmService alarmService;

    @GetMapping("getReportedMonologueList")
    public List<Monologue> adminPost(Model model){
        System.out.println("admin post in MonologueRestController start");
        List<Monologue> monologueList = monologueService.getReportedMonoList();

        model.addAttribute("monologueList", monologueList);

        return monologueList;
    }

    @PostMapping("setBlindMonologue")
    public int setBlindMonologue(@RequestBody String json){

        System.out.println("json check : " + json);
        String data[] = json.split("&");
        int monologueId = Integer.parseInt(data[0].split("=")[1]);
        String userId = data[1].split("=")[1];
        System.out.println("monologueId : " + monologueId);
        System.out.println("userId : " + userId);

        Alarm alarm = new Alarm();
        alarm.setUserId(userId);
        alarm.setMonologueId(monologueId);
        alarm.setAlarmType("2");
        alarm.setAlarmText("블라인드 처리된 1문1답이 있어요!");

       monologueService.setBlindMonologue(monologueId);
       alarmService.blindMonologueAlarm(alarm);
        System.out.println("setBlindMonologue from MonologueRestController finish");
        return 1;
    }

    @GetMapping("getMonologueReportReason")
    public List<Monologue> getMonologueReportReason(@RequestParam("monologueId") int monologueId){
        System.out.println("getMonologueReportReason in monologueRestController start");
        System.out.println("parameter check : " + monologueId);

        List<Monologue> list = monologueService.getMonologueReportReason(monologueId);
        System.out.println("getMonologueReportReason in monologueRestController Finish");

        return list;
    }
    

	@GetMapping("getMonologueList")
	public List<Monologue> getMonologueList(Model model, HttpSession session, String questionText) throws Exception{
		System.out.println("getMonologueList 시작해유");
		
		session.setAttribute("userId", "gyuri");
		
		String userId=(String)session.getAttribute("userId");
		
		System.out.println("getMonologueList에서 userId 확인이니이이이잉 :::"+userId);
		
		List<Monologue> monologueList=monologueService.getMonologueList((session.getAttribute("userId")).toString());
				
		model.addAttribute("monologueList", monologueList);
		
		System.out.println("monologueController getMonologueList  ::  " + monologueList);
	
		return monologueList;
		
	}
    
}
