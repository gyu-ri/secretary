package com.nj.secretary.services.calendar.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restCalendar/*")
public class CalendarRestController {

    @GetMapping("getCalendarList")
    public JSONObject getCalendarList(){



        return null;
    }

    @PostMapping("addCalendar")
    public String addCalendar(@RequestBody String test){

        System.out.println("REST까지 왔다.");
        System.out.println(test);
        return "obj";

    }

}
