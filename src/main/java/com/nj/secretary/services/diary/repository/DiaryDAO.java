package com.nj.secretary.services.diary.repository;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.domain.IsDiary;
import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.domain.Report;

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












    public int deleteDiary(int diaryId);

    public int recoverDiary(int diaryId);

    public int reportDiary(int diaryId);

    public int addReport(Report report);

    public int checkReporter(Report report);
}
