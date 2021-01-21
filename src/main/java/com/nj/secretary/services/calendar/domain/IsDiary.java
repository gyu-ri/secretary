package com.nj.secretary.services.calendar.domain;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class IsDiary {

    private int id;
    private String username;
    private String start;
    private String backgroundColor;
    private String imageUrl;
    private String allDay;
    private String display = "background";

}


