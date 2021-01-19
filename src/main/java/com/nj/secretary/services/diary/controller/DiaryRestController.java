package com.nj.secretary.services.diary.controller;


import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.service.DiaryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/restDiary/*")
public class DiaryRestController {

    @Autowired
    DiaryService diaryService;

    @GetMapping("getDiaryTagList")
    public List<Diary> getDiaryTagList(String userId){
        System.out.println("getDiaryTagList start!!!");
        List<Diary> list = diaryService.getDiaryTagList(userId);

        return list;
    }

    @GetMapping("getOthersDiaryList")
    public String getOthersDiaryList(@RequestParam("shareStatus") String shareStatus, @RequestParam("userId") String userId, Model model){
        System.out.println("getOthersDiaryList start in controller");
        System.out.println("test : " + shareStatus + userId);
        List<Diary> list = diaryService.getOthersDiaryList();
        System.out.println("parse test : " + list);
        System.out.println("getOthersDiaryList finish in controller");
        model.addAttribute("list", list);
        return "diary/getDiaryList";
    }

    @PostMapping("moveToBin")
    public List<Diary> moveToBin(@RequestBody List<String> id, HttpSession session){
        session.setAttribute("userId", "user02");
        String userId = (String) session.getAttribute("userId");


        System.out.println("확인 : " + id);
//       for(String diary : id){
//
//           int diaryId = Integer.parseInt(diary);
//           diaryService.moveToBin(diaryId);
//       }
        System.out.println("삭제하기 위한 diary 객체 리스트 : " + id);

        List<Diary> list = diaryService.getDiaryList(userId);

        return list;
    }

}
