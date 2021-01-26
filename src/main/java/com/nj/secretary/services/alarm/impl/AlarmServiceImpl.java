package com.nj.secretary.services.alarm.impl;

import com.nj.secretary.services.alarm.domain.Alarm;
import com.nj.secretary.services.alarm.repository.AlarmDAO;
import com.nj.secretary.services.alarm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    @Qualifier("alarmDAOImpl")
    AlarmDAO alarmDAO;

    @Override
    public void likeDiaryAlarm(Alarm alarm) {
        alarmDAO.likeDiaryAlarm(alarm);
    }

    @Override
    public void likeMonologueAlarm(Alarm alarm) {
        alarmDAO.likeMonologueAlarm(alarm);
    }

    @Override
    public void blindDiaryAlarm(Alarm alarm) {
        alarmDAO.blindDiaryAlarm(alarm);
    }

    @Override
    public void blindMonologueAlarm(Alarm alarm) {
        alarmDAO.blindMonologueAlarm(alarm);
    }

    @Override
    public void shareLimitAlarm(Alarm alarm) {
        alarmDAO.shareLimitAlarm(alarm);
    }

    @Override
    public int alarmCount(String userId) {
        return alarmDAO.alarmCount(userId);
    }

    @Override
    public List<Alarm> getAlarmList(String userId) {
        return alarmDAO.getAlarmList(userId);
    }

    @Override
    public void deleteAlarmList(String userId) {
        alarmDAO.deleteAlarmList(userId);
    }

    @Override
    public void seenDiaryAlarm(int diaryId) {
        alarmDAO.seenDiaryAlarm(diaryId);
    }

    @Override
    public void seenMonologueAlarm(int monologueId) {
        alarmDAO.seenMonologueAlarm(monologueId);
    }

    @Override
    public List<Alarm> getLimitReasonsOfDiary(String userId) {
        return alarmDAO.getLimitReasonsOfDiary(userId);
    }

    @Override
    public List<Alarm> getLimitReasonsOfMonologue(String userId) {
        return alarmDAO.getLimitReasonsOfMonologue(userId);
    }

    @Override
    public void seenLimitReasons(String id) {
        alarmDAO.seenLimitReasons(id);
    }
}
