package com.nj.secretary.services.diary.impl;

import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.repository.DiaryDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("diaryDAOImpl")
public class DiaryDAOImpl implements DiaryDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addDiary(Diary diary){

        System.out.println("addDiary in DiaryDAOImpl start");
        sqlSession.insert("DiaryMapper.addDiary", diary);
    }

    @Override
    public List<Diary> getDiaryList(String userId) {

        System.out.println("getDiaryList in DiaryDAOImpl start");

        List<Diary> list = sqlSession.selectList("DiaryMapper.getDiaryList", userId);


        return list;
    }

    @Override
    public List<Diary> getDiaryTagList(String userId) {
        return null;
    }

    @Override
    public List<Diary> getOthersDiaryList() {
        return null;
    }

    @Override
    public List<Diary> moveToBin() {
        return null;
    }
}
