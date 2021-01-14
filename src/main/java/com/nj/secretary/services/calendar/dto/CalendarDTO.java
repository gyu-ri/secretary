package com.nj.secretary.services.calendar.dto;

import com.nj.secretary.services.calendar.domain.Calendar;

import java.sql.Date;

public class CalendarDTO {

    public static class addCalendarDTO{
        private String userId;
        private String calendarTitle;
        private String calendarDetail;
        private String startDate;
        private String endDate;
        private String backgoundColor;
        private String type;
        private String allDay;

        public Calendar addConvert(){
            return new Calendar(
                    this.userId,
                    this.calendarTitle,
                    this.calendarDetail,
                    this.startDate,
                    this.endDate,
                    this.backgoundColor,
                    this.allDay
            );
        }
    }

    public static class getCalendarListDTO{
        private String userId;
        private String startDate;
        private String endDate;

        public Calendar getCalendarListDTO(){
            return new Calendar(this.userId,this.startDate,this.endDate);
        }
    }
}
