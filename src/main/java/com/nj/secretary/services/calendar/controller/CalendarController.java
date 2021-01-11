package com.nj.secretary.services.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {

    @GetMapping("mainCalendar")
    public String mainCalendarView(){
        return "calendar/mainCalendar";
    }

}
