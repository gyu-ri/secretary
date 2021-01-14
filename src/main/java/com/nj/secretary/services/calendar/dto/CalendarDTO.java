package com.nj.secretary.services.calendar.dto;

import com.nj.secretary.services.calendar.domain.Calendar;

import java.sql.Date;

public class CalendarDTO {

    public static class addCalendarDTO{
        private String userId;
        private String calendarTitle;
        private String calendarDetail;
        private Date startDate;
        private Date endDate;
        private String backgoundColor;
        private String type;
        private Boolean allDay;

        public Calendar addConvert(){
            return new Calendar(
                    this.userId,
                    this.calendarTitle,
                    this.calendarDetail,
                    this.startDate,
                    this.endDate,
                    this.backgoundColor,
                    this.type,
                    this.allDay
            );
        }
    }
}
