package com.nj.secretary.services.diary.service;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.domain.IsDiary;
import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.domain.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DiaryService {

    public void addDiary(Diary diary);

    public List<Diary> getDiaryList(String userId);

    public List<Diary> getOthersDiaryList(String userId);

    public Diary getDiary(int diaryNumber);

    public void updateDiary(Diary diary);

    public void addTag(String tag);

    public List<Diary> getTagDiaryList(String userId);

    public void moveToBin(int diaryId);

    public List<Diary> getReportedDiaryList();

    public int setBlindDiary(int num);

    public List<Diary> getBinList(String userId);

    public List<IsDiary> getDiaryEmotion(Calendar calendar);


    public List<Diary> getDiaryReportReason(int diaryId);

    public String getCount(Object message);

    public void addImage(String imageName);
















    public int deleteDiary(int diaryId);

    public int recoverDiary(int diaryId);

    public int reportDiary(int diaryId);

    public int addReport(Report report);

    public int checkReporter(Report report);



}
