package com.nj.secretary.services.diary.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AttachFile {
    private int fileId;
    private int diaryId;
    private String fileName;
    private String fileStatus;
}
