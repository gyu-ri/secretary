package com.nj.secretary.services.alarm.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Alarm {

    private int alarmId;
    private int diaryId;
    private int monologueId;
    private String userId;
    private String checkStatus;
    private String alarmType;
    private String alarmText;
    private String reportReasonId;
    private Date reportDate;
    private String reportText;


}
