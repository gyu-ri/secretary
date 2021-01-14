package com.nj.secretary.services.calendar.impl;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.repository.CalendarDAO;
import com.nj.secretary.services.user.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("calendarDAOImpl")
public class CalendarDAOImpl implements CalendarDAO {

    @Autowired
    SqlSession sqlSession;

    @Override
    public void addCalendar(Calendar calendar) {
        System.out.println("addCalendar DAO Impl Start");
        sqlSession.insert("CalendarMapper.addCalendar",calendar);
    }

    @Override
    public Calendar getCalendar(int calendarId) {
        return null;
    }

    @Override
    public List<Calendar> getCalendarList(Calendar calendar) {

        return sqlSession.selectList("CalendarMapper.getCalendarList",calendar);
    }

    @Override
    public Calendar updateCalendar(int calendaerId) {
        return null;
    }

    @Override
    public void deleteCalendar(int calendarId) {

    }
}
