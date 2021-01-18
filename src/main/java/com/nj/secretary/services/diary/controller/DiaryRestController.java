package com.nj.secretary.services.diary.controller;


import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restDiary/*")
public class DiaryRestController {

    @Autowired
    DiaryService diaryService;

    @GetMapping("getDiaryTagList")
    public List<Diary> getDiaryTagList(String userId){
        System.out.println("getDiaryTagList start!!!");


        return list;
    }

    @GetMapping("getOthersDiaryList")
    public List<Diary> getOthersDiaryList(){

        return list;
    }

    @PostMapping("moveToBin")
    public List<Diary> moveToBin(){

        return list;
    }

}
