package com.nj.secretary.services.diary.repository;

import com.nj.secretary.services.diary.domain.Diary;

import java.util.List;

public interface DiaryDAO {

    public void addDiary(Diary diary);

    public List<Diary> getDiaryList(String userId) ;
}
