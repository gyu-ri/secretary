package com.nj.secretary.services.calendar.controller;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.domain.IsDiary;
import com.nj.secretary.services.calendar.service.CalendarService;
import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.service.DiaryService;
import com.nj.secretary.services.user.domain.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restCalendar/*")
public class CalendarRestController {

    @Autowired
    CalendarService calendarService;

    @Autowired
    DiaryService diaryService;
    @GetMapping("getCalendarList")
    public List getCalendarList(@RequestParam("startDate") String start,
                                @RequestParam("endDate") String end,
                                HttpSession session) {
        System.out.println("getCalendarList Rest Start");
        User user = (User)session.getAttribute("user");
        Calendar calendar = new Calendar();
        Map<String, List> map = new HashMap<String, List>();
        calendar.setStart(start);
        calendar.setEnd(end);
        calendar.setUsername(user.getUserId());
        System.out.println(calendar);
        List<Calendar> calendarList = calendarService.getCalendarList(calendar);
        List<IsDiary> diaryList = diaryService.getDiaryEmotion(calendar);
        System.out.println(diaryList);
        for(IsDiary test : diaryList){
            test.setDisplay("background");
        }
        map.put("calendar", calendarList);
        map.put("diary", diaryList);
        List allList = new ArrayList();
        allList.addAll(calendarList);
        allList.addAll(diaryList);
//        //JSONObject 만들기
//        for(Calendar test:list){
//            JSONObject jsonObject = new JSONObject(test);
//            System.out.println(jsonObject);
//        }
//
//        //JSONArray 만들기
//        JSONArray jsonArray = new JSONArray(list);
//        System.out.println(jsonArray);

        return allList;
    }
    @PostMapping("addCalendar")
    public void addCalendar(@RequestBody Calendar calendar){
        System.out.println(calendar);
        System.out.println("addCalendar Start.");
        calendar.setStart(calendar.getStart().replace(" ","T"));    //for FullCalendar format
        calendar.setEnd(calendar.getEnd().replace(" ","T"));    //for FullCalendar format
        System.out.println(calendar);
        calendarService.addCalendar(calendar);

    }

    @PostMapping("updateCalendar")
    public void updateCalendar(@RequestBody Calendar calendar){
        System.out.println(calendar);
        System.out.println("updateCalendar Start");
        calendar.setStart(calendar.getStart().replace(" ","T"));    //for FullCalendar format
        calendar.setEnd(calendar.getEnd().replace(" ","T"));    //for FullCalendar format
        System.out.println(calendar);
        calendarService.updateCalendar(calendar);
    }

    @PostMapping("moveCalendar")
    public void moveCalendar(@RequestBody Calendar calendar){   //Calendar move to other date
        System.out.println("TEST : "+calendar);
        calendarService.moveCalendar(calendar);
    }

    @PostMapping("deleteCalendar")
    public void deleteCalendar(@RequestBody Calendar calendar){
        System.out.println(calendar);
        calendarService.deleteCalendar(calendar.getId()); //Delete Calendar
    }

}
