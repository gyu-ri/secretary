package com.nj.secretary.services.calendar.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Calendar {

    private int calendarId;
    private String userId;
    private String calendarTitle;
    private String calendarDetail;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String backgroundColor;
    private String type;
    private String allDay;

    //basic
    public Calendar(){}

    //addCalendar
    public Calendar(String userId,String calendarTitle,String calendarDetail,String startDate,String endDate,String backgoundColor,String type,String allDay) {

        this.userId = userId;
        this.calendarTitle = calendarTitle;
        this.calendarDetail = calendarDetail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.backgroundColor = backgoundColor;
        this.type = type;
        this.allDay = allDay;

    }

    public Calendar(String userId, String startDate, String endDate) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
