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

    public List<Diary> getDiaryTagList(String userId);

    public List<Diary> moveToBin(int diaryId);

}
