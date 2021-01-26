package com.nj.secretary.services.diary.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class Report {
    private int reportId;
    private int reportReasonId;
    private int diaryId;
    private int monologueId;
    private String reporterId;
    private Date reportDate;
    private String reportText;
}
