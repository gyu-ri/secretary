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
        calendar.setStart(start);
        calendar.setEnd(end);
        calendar.setUsername("윤도영");
        List<Calendar> list = calendarService.getCalendarList(calendar);

        for(Calendar test:list){
            JSONObject jsonObject = new JSONObject(test);
            System.out.println(jsonObject);
        }

        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray);
        return list;
    }

    @PostMapping("addCalendar")
    public String addCalendar(@RequestBody Calendar calendar){
        System.out.println(calendar);
        System.out.println("REST까지 왔다.");
        calendar.setStart(calendar.getStart().replace(" ","T"));
        calendar.setEnd(calendar.getEnd().replace(" ","T"));
        System.out.println(calendar);
        calendarService.addCalendar(calendar);
        return "obj";

    }

}
