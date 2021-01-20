package com.nj.secretary.services.diary.domain;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
public class Diary {
    private int diaryId;
    private String userId;
    private  int emotionNo;
    private String emotionName;
    private String emotionImg;
    private int locationX;
    private int locationY;
    private String location;
    private String weather;
    private int fileId;
    private String fileName;
    private String fileStatus;
    private char blindStatus;
    private char deleteStatus;
    private String diaryTitle;
    private String diaryText;
    private int likeCount;
    private Date deleteDate;
    private String shareStatus;
    private String diaryDate;
    private int reportCount;
    private String sortCondition;


    public Diary() { }



}
