package com.nj.secretary.services.user.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String userName;//사용자 이름
    private String userId;//사용자 아이디 : 중복불가
    private String password;//사용자 비밀번호
    private String nickname;//사용자 닉네임 : 중복가능
    private String email;//이메일 : 본인인증을 위한 수단
    private String motto;//좌우명
    private int certificationNo;//인증번호
    private String role;//사용자권한부여
    private Date withdrawalDate;//탈퇴일
    private boolean withdrawalStatus;//탈퇴상태
    private int blindCount;//블라인드처리된 게시물 수
    private Date limitStartDate;//공유제한일
    private Date limitEndDate;//공유제한일
    private boolean isDisplayTime;//레이아웃 설정
    private boolean isDisplayWeather;//레이아웃 설정
    private boolean isDisplayLocation;//레이아웃 설정
    private int withdrawalReasonId;
    private String isAlarmDiary;
    private String isAlarmMonologue;


}