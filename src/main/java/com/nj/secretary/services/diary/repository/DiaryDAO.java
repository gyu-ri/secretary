package com.nj.secretary.services.diary.repository;

import com.nj.secretary.services.diary.domain.Diary;

import java.util.List;

public interface DiaryDAO {

    public void addDiary(Diary diary);

    public List<Diary> getDiaryList(String userId) ;


    public  List<Diary> getTagDiaryList(String userId);

    public List<Diary> getOthersDiaryList();

    public  List<Diary> moveToBin(int diaryId);

    public Diary getDiary(int DiaryNumber);

    public void updateDiary(Diary diary);

    public void addFiles(String file);
}
