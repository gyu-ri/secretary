package com.nj.secretary.services.diary.domain;

import lombok.Data;

@Data
public class Translate {
    private String text;
    private String source;
    private String target;
    private String question;
}
