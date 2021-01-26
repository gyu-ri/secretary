package com.nj.secretary.services.diary.repository;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.domain.IsDiary;
import com.nj.secretary.services.diary.domain.Diary;

import java.util.List;

public interface DiaryDAO {

    public void addDiary(Diary diary);

    public List<Diary> getDiaryList(String userId) ;


    public  List<Diary> getTagDiaryList(String userId);

    public List<Diary> getOthersDiaryList();

    public void moveToBin(int diaryId);

    public List<Diary> getBinList(String userId);

    public Diary getDiary(int DiaryNumber);

    public void updateDiary(Diary diary);

    public void addFiles(String file);


    public List<Diary> getReportedDiaryList();

    public int setBlindDiary(int num);

    public List<IsDiary> getDiaryEmotion(Calendar calendar);

    public List<Diary> getDiaryReportReason(int diaryId);

    public String getCount(Object message);












    public int deleteDiary(String diaryId);

    public int recoverDiary(String diaryId);

}
