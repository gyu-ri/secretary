package com.nj.secretary.services.calendar.repository;

import com.nj.secretary.services.calendar.domain.Calendar;
import com.nj.secretary.services.user.domain.User;

import java.util.List;

public interface CalendarDAO {

    public void addCalendar(Calendar calendar);

    public Calendar getCalendar(int calendarId);

    public List<Calendar> getCalendarList(User userId);

    public Calendar updateCalendar(int calendaerId);

    public void deleteCalendar(int calendarId);
}
