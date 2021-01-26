package com.nj.secretary.services.alarm.repository;

import com.nj.secretary.services.alarm.domain.Alarm;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AlarmDAO {

    public void likeDiaryAlarm(Alarm alarm);

    public void likeMonologueAlarm(Alarm alarm);

    public void blindDiaryAlarm(Alarm alarm);

    public void blindMonologueAlarm(Alarm alarm);

    public void shareLimitAlarm(Alarm alarm);

    public int alarmCount(String userId);

    public List<Alarm> getAlarmList(String userId);

    public void deleteAlarmList(String userId);

    public void seenDiaryAlarm(int diaryId);

    public void seenMonologueAlarm(int monologueId);

    public List<Alarm> getLimitReasonsOfDiary(String userId);

    public List<Alarm> getLimitReasonsOfMonologue(String userId);

    public void seenLimitReasons(String id);
}
