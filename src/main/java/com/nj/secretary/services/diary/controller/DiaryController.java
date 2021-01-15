package com.nj.secretary.services.diary.controller;


import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/diary/*")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @GetMapping("addDiary")
    public String addDiary(){
        return "diary/emotion";
    }

    @PostMapping("addDiarys")
    public String addDiary(@ModelAttribute("diary") Diary diary, Model model){
        System.out.println("diary : " + diary);
        diaryService.addDiary(diary);
        System.out.println("다이어리 추가 완료");

        return "redirect:/diary/addDiaryView";
    }

    @GetMapping("write")
    public String writeDiary(Diary diary){
        System.out.println("들어왔다 가야지");
        return "diary/boardWrite";
    }


}