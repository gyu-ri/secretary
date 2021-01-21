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
    public List<Diary> getDiaryList(String userId) {
        System.out.println("getDiaryList in DiaryServiceImpl start");
        List<Diary> list = diaryDAO.getDiaryList(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        System.out.println("getDiaryList in DiaryServiceImpl finish");
        return list;
    }



    @Override
    public List<Diary> getTagDiaryList(String userId) {

        List<Diary> list = diaryDAO.getTagDiaryList(userId);


        return null;
    }


    @Override
    public List<Diary> getOthersDiaryList() {

        List<Diary> list = diaryDAO.getOthersDiaryList();
        return list;
    }


    @Override
    public void moveToBin(int diaryId) {

        diaryDAO.moveToBin(diaryId);

    }

    @Override
    public Diary getDiary(int diaryNumber) {

        return diaryDAO.getDiary(diaryNumber);
    }

    @Override
    public void updateDiary(Diary diary) {

        diaryDAO.updateDiary(diary);
    }

    @Override
    public void addFiles(String file) {

        diaryDAO.addFiles(file);
    }

    @Override
    public List<Diary> getReportedDiaryList() {

        List<Diary> list =  diaryDAO.getReportedDiaryList();
        return list;
    }

    @Override
    public int setBlindDiary(int num) {
        diaryDAO.setBlindDiary(num);
        return 1;
    }
}
