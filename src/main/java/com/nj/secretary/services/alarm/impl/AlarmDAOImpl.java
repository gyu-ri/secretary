package com.nj.secretary.services.alarm.impl;

import com.nj.secretary.services.alarm.domain.Alarm;
import com.nj.secretary.services.alarm.repository.AlarmDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("alarmDAOImpl")
public class AlarmDAOImpl implements AlarmDAO {

    @Autowired
    private SqlSession sqlSession;


    @Override
    public void likeDiaryAlarm(Alarm alarm) {
        sqlSession.insert("AlarmMapper.likeDiaryAlarm", alarm);
    }

    @Override
    public void likeMonologueAlarm(Alarm alarm) {
        sqlSession.insert("AlarmMapper.likeMonologueAlarm", alarm);
    }

    @Override
    public void blindDiaryAlarm(Alarm alarm) {
        sqlSession.insert("AlarmMapper.blindDiaryAlarm", alarm);
    }

    @Override
    public void blindMonologueAlarm(Alarm alarm) {
        sqlSession.insert("AlarmMapper.blindMonologueAlarm", alarm);
    }

    @Override
    public void shareLimitAlarm(Alarm alarm) {
        sqlSession.insert("AlarmMapper.shareLimitAlarm", alarm);
    }

    @Override
    public int alarmCount(String userId) {
        return sqlSession.selectOne("AlarmMapper.alarmCount", userId);
    }

    @Override
    public List<Alarm> getAlarmList(String userId) {
        return sqlSession.selectList("AlarmMapper.getAlarmList", userId);
    }

    @Override
    public void deleteAlarmList(String userId) {
        sqlSession.delete("AlarmMapper.deleteAlarmList", userId);
    }

    @Override
    public void seenDiaryAlarm(int diaryId) {
        sqlSession.update("AlarmMapper.seenDiaryAlarm", diaryId);
    }

    @Override
    public void seenMonologueAlarm(int monologueId) {
        sqlSession.update("AlarmMapper.seenMonologueAlarm", monologueId);
    }

    @Override
    public List<Alarm> getLimitReasonsOfDiary(String userId) {
        return sqlSession.selectList("AlarmMapper.getLimitReasonsOfDiary", userId);
    }

    @Override
    public List<Alarm> getLimitReasonsOfMonologue(String userId) {
        return sqlSession.selectList("AlarmMapper.getLimitReasonsOfMonologue", userId);
    }

    @Override
    public void seenLimitReasons(String id) {
        sqlSession.update("AlarmMapper.seenLimitReasons", id);
    }
}
