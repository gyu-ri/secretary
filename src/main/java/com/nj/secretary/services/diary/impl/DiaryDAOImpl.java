package com.nj.secretary.services.diary.impl;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.domain.IsDiary;
import com.nj.secretary.services.diary.domain.Diary;
import com.nj.secretary.services.diary.domain.Report;
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
    public List<Diary> getTagDiaryList(String userId) {

        List<Diary> list = sqlSession.selectList("DiaryMapper.getTagDiaryList", userId);

        return list;
    }

    @Override
    public List<Diary> getOthersDiaryList() {

        List<Diary> list = sqlSession.selectList("DiaryMapper.getOthersDiaryList");

        return list;
    }

    @Override
    public void moveToBin(int diaryId) {
        sqlSession.update("DiaryMapper.moveToBin",diaryId);
    }

    @Override
    public List<Diary> getBinList(String userId) {

        return sqlSession.selectList("DiaryMapper.getBinList",userId);
    }

    @Override
    public Diary getDiary(int diaryNumber) {
        return sqlSession.selectOne("DiaryMapper.getDiary",diaryNumber);
    }

    @Override
    public void updateDiary(Diary diary) {
        sqlSession.update("DiaryMapper.updateDiary",diary);
    }

    @Override
    public void addFiles(String file) {
        sqlSession.insert("DiaryMapper.addFiles", file);
    }

    @Override

    public List<Diary> getReportedDiaryList() {
        List<Diary> list = sqlSession.selectList("DiaryMapper.getReportedDiaryList");

        return list;
    }

    @Override
    public int setBlindDiary(int num) {
        sqlSession.update("DiaryMapper.setBlindDiary", num);
        return 1;
    }

    @Override
    public List<IsDiary> getDiaryEmotion(Calendar calendar) {
        return sqlSession.selectList("DiaryMapper.getDiaryEmotion",calendar);

    }

    @Override
    public int deleteDiary(int diaryId) {
        return sqlSession.delete("DiaryMapper.deleteDiary",diaryId);
    }

    @Override
    public int recoverDiary(int diaryId) {
        return sqlSession.update("DiaryMapper.recoverDiary",diaryId);
    }

    @Override
    public int reportDiary(int diaryId) {
        return sqlSession.update("DiaryMapper.reportDiary",diaryId);
    }

    @Override
    public int addReport(Report report) {
        return sqlSession.insert("DiaryMapper.addReport",report);
    }

    @Override
    public int checkReporter(Report report) {
        return sqlSession.selectOne("DiaryMapper.checkReporter",report);
    }
}
