package com.nj.secretary.services.diary.service;

import com.nj.secretary.services.diary.domain.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryService {

    public void addDiary(Diary diary);


}
