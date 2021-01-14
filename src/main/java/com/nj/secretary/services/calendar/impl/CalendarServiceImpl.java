package com.nj.secretary.services.calendar.impl;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.calendar.repository.CalendarDAO;
import com.nj.secretary.services.calendar.service.CalendarService;
import com.nj.secretary.services.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("calendarServiceImpl")
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    @Qualifier("calendarDAOImpl")
    CalendarDAO calendarDAO;

    @Override
    public void addCalendar(Calendar calendar) {
        calendarDAO.addCalendar(calendar);
    }

    @Override
    public Calendar getCalendar(int calendarId) {

        return calendarDAO.getCalendar(calendarId);
    }

    @Override
    public List<Calendar> getCalendarList(User userId) {

        return calendarDAO.getCalendarList(userId);
    }

    @Override
    public Calendar updateCalendar(int calendarId) {

        return calendarDAO.updateCalendar(calendarId);
    }

    @Override
    public void deleteCalendar(int calendarId) {

        calendarDAO.deleteCalendar(calendarId);
    }
}
