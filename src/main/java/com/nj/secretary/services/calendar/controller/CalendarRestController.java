package com.nj.secretary.services.calendar.controller;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.service.CalendarService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restCalendar/*")
public class CalendarRestController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("getCalendarList")
    public List<Calendar> getCalendarList(@RequestParam("startDate") String start,
                                      @RequestParam("endDate") String end){
        System.out.println("getCalendarList Rest Start");
        Calendar calendar = new Calendar();
        calendar.setStartDate(start);
        calendar.setEndDate(end);
        calendar.setUserId("윤도영");
        List<Calendar> list = calendarService.getCalendarList(calendar);

        for(Calendar test:list){
            System.out.println(test);
        }
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray);
        return list;
    }

    @PostMapping("addCalendar")
    public String addCalendar(@RequestBody Calendar calendar){

        System.out.println("REST까지 왔다.");
        calendarService.addCalendar(calendar);
        return "obj";

    }

}
