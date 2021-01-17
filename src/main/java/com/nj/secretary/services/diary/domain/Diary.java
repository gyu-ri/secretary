package com.nj.secretary.services.diary.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Diary {
    private int diaryId;
    private String userId;
    private  int emotionNo;
    private int locationX;
    private int locationY;
    private String location;
    private String weather;
    private char blindStatus;
    private char deleteStatus;
    private String diaryTitle;
    private String diaryText;
    private int likeCount;
    private Date deleteDate;
    private String shareStatus;
    private Date diaryDate;
    private int reportCount;
    private String sortCondition;

    public Diary() { }

    public Diary(int diaryId, String userId, int emotionNo, int locationX, int locationY, String location, String weather, char blindStatus, char deleteStatus, String diaryTitle, String diaryText, int likeCount, Date deleteDate, String shareStatus, Date diaryDate, int reportCount, String sortCondition) {
        this.diaryId = diaryId;
        this.userId = userId;
        this.emotionNo = emotionNo;
        this.locationX = locationX;
        this.locationY = locationY;
        this.location = location;
        this.weather = weather;
        this.blindStatus = blindStatus;
        this.deleteStatus = deleteStatus;
        this.diaryTitle = diaryTitle;
        this.diaryText = diaryText;
        this.likeCount = likeCount;
        this.deleteDate = deleteDate;
        this.shareStatus = shareStatus;
        this.diaryDate = diaryDate;
        this.reportCount = reportCount;
        this.sortCondition = sortCondition;
    }


}
