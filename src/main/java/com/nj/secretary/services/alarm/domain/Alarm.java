package com.nj.secretary.services.alarm.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Alarm {

    private String code;
    private String title;
    private String dept;
    private Integer quota;
    private Integer applicant;
    private Date createDate;

}
