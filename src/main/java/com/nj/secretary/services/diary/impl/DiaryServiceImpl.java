package com.nj.secretary.services.diary.impl;

import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.repository.DiaryDAO;
import com.nj.secretary.services.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    @Qualifier("diaryDAOImpl")
    DiaryDAO diaryDAO;

    @Override
    public void addDiary(Diary diary){

        diaryDAO.addDiary(diary);
    }

    @Override
    public Map<String, Object> getDiaryList(String userId) {
        System.out.println("getDiaryList in DiaryServiceImpl start");
        List<Diary> list = diaryDAO.getDiaryList(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        System.out.println("getDiaryList in DiaryServiceImpl finish");
        return map;
    }
}
