package com.nj.secretary.services.diary.impl;

import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.repository.DiaryDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("diaryDAOImpl")
public class DiaryDAOImpl implements DiaryDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addDiary(Diary diary){

        System.out.println("addDiary in DiaryDAOImpl start");
        sqlSession.insert("DiaryMapper.addDiary", diary);
    }

}
