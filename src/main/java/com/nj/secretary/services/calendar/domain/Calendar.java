package com.nj.secretary.services.calendar.domain;

import java.sql.Date;

public class Calendar {

    private int calendarId;
    private String userId;
    private String calendarTitle;
    private String calendarDetail;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;
    private String backgroundColor;
    private String type;
    private Boolean allDay;

    //basic
    public Calendar(){}

    //addCalendar
    public Calendar(String userId,String calendarTitle,String calendarDetail,Date startDate,Date endDate,String backgoundColor,String type,Boolean allDay) {

        this.userId = userId;
        this.calendarTitle = calendarTitle;
        this.calendarDetail = calendarDetail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.backgroundColor = backgoundColor;
        this.type = type;
        this.allDay = allDay;

    }
}
