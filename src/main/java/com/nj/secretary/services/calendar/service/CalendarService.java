package com.nj.secretary.services.calendar.service;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarService {

    public void addCalendar(Calendar calendar);

    public Calendar getCalendar(int calendarId);

    public List<Calendar> getCalendarList(Calendar calendar);

    public void updateCalendar(Calendar calendar);

    public void deleteCalendar(int calendarId);
}
