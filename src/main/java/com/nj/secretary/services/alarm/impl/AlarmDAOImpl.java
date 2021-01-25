package com.nj.secretary.services.alarm.impl;

import com.nj.secretary.services.alarm.domain.Alarm;
import com.nj.secretary.services.alarm.repository.AlarmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AlarmDAOImpl implements AlarmDAO {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Alarm> getAllAlarm() {
        return null;
    }

    @Override
    public Alarm getAlarmByCode(String AlarmCode) {
        return null;
    }

    @Override
    public void plusAlarmApplicant(String AlarmCode) {

    }
}
