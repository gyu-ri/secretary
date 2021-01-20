package com.nj.secretary.services.diary.service;

import com.nj.secretary.services.diary.domain.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DiaryService {

    public void addDiary(Diary diary);

    public List<Diary> getDiaryList(String userId);

    public List<Diary> getOthersDiaryList();

    public Diary getDiary(int diaryNumber);

    public void updateDiary(Diary diary);

    public void addFiles(String file);

    public List<Diary> getTagDiaryList(String userId);

    public void moveToBin(int diaryId);

    public List<Diary> getReportedDiaryList();

}
