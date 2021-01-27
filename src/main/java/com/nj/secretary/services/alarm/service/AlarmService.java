package com.nj.secretary.services.alarm.service;

import com.nj.secretary.services.alarm.domain.Alarm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmService {

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
