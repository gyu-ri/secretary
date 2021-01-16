package com.nj.secretary.services.calendar.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Calendar {

    private int id;
    private String username;
    private String title;
    private String description;
    private String start;
    private String end;
    private String backgroundColor;
    private String imageUrl;
    private String allDay;

    //basic
    public Calendar(){}

    //addCalendar
    public Calendar(String userId,String title,String description,String start,String end,String backgoundColor,String allDay) {

        this.username = userId;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.backgroundColor = backgoundColor;

        this.allDay = allDay;

    }

    public Calendar(String userId, String start, String end) {
        this.username = userId;
        this.start = start;
        this.end = end;
    }
}
