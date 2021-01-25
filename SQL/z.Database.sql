DROP TABLE ALARM;
DROP TABLE USERS;
DROP TABLE DIARY;
DROP TABLE CALENDAR;
DROP TABLE MONOLOGUE;
DROP TABLE QUESTIONS;
DROP TABLE TODOLIST;
DROP TABLE WITHDRAWALREASONS;
DROP TABLE GOALS;
DROP TABLE EMOTIONS;
DROP TABLE REPORT;
DROP TABLE ATTACHFILE;
DROP TABLE WEATHER;


DROP sequence ALARM_SEQ;
DROP sequence DIARY_SEQ;
DROP sequence CALENDAR_SEQ;
DROP sequence MONOLOGUE_SEQ;
DROP sequence QUESTIONS_SEQ;
DROP sequence TODOLIST_SEQ;
DROP sequence WITHDRAWALREASONS_SEQ;
DROP sequence GOALS_SEQ;
DROP sequence EMOTIONS_SEQ;
DROP sequence REPORT_SEQ;
DROP sequence attachfile_seq;
DROP sequence WEATHER_SEQ;


CREATE SEQUENCE diary_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE monologue_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE calendar_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE goal_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE alarm_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE questions_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE todolist_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE withdrawalreasons_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE emotion_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE report_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE attachfile_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE weather_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE ALARM
(
    ALARM_ID     NUMBER(8) NOT NULL PRIMARY KEY,
    DIARY_ID     NUMBER(8),
    USER_ID      VARCHAR2(30) NOT NULL,
    MONOLOGUE    NUMBER(8),
    ALARY_TYPE   NUMBER(3) NOT NULL,
    BLIND_STATUS CHAR(1) DEFAULT 0
);


CREATE TABLE USERS2
(
    USER_ID              VARCHAR2(30) NOT NULL PRIMARY KEY,
    PASSWORD             VARCHAR2(30) NOT NULL,
    USER_NAME            VARCHAR2(30) NOT NULL,
    ROLE                 VARCHAR2(20) DEFAULT 'USER',
    NICKNAME             VARCHAR2(30),
    EMAIL                VARCHAR2(100) NOT NULL,
    WITHDRAWAL_REASON_ID NUMBER(8),
    MOTTO                VARCHAR2(100),
    IS_ALARM_DIARY       CHAR(1) DEFAULT 1,
    IS_ALARM_MONOLOGUE   CHAR(1) DEFAULT 1,
    BLIND_COUNT          NUMBER(2),
    WITHDRAWAL_DATE      DATE,
    WITHDRAWAL_STATUS    CHAR(1) DEFAULT 0,
    LIMIT_START_DATE     DATE    DEFAULT NULL,
    LIMIT_END_DATE       DATE    DEFAULT NULL,
    IS_DISPLAY_TIME      CHAR(1) DEFAULT 1,
    IS_DISPLAY_WEATHER   CHAR(1) DEFAULT 1,
    IS_DISPLAY_LOCATION  CHAR(1) DEFAULT 1
);

CREATE TABLE DIARY
(
    DIARY_ID       NUMBER(8) NOT NULL PRIMARY KEY,
    EMOTION_ID     NUMBER(8) NOT NULL,
    USER_ID        VARCHAR2(30) NOT NULL,
    BLIND_STATUS   CHAR(1) DEFAULT 0,
    DELETE_STATUS  CHAR(1) DEFAULT 0,
    DIARY_TITLE    VARCHAR2(30) NOT NULL,
    DIARY_TEXT     CLOB NOT NULL,
    LOCATION       VARCHAR2(200) NOT NULL,
    WEATHER        VARCHAR2(200) NOT NULL,
    LIKE_COUNT     NUMBER(5) DEFAULT 0,
    DELETE_DATE    DATE,
    SHARE_STATUS   CHAR(1) DEFAULT 0,
    REPORT_COUNT   NUMBER(5),
    DIARY_DATE     DATE NOT NULL,
    SORT_CONDITION NUMBER(3)
);


create table CALENDAR
(
    CALENDAR_ID      NUMBER(8) not null
        constraint CALENDAR_PK
        primary key,
    USER_ID          VARCHAR2(30) not null,
    CALENDAR_TITLE   VARCHAR2(50) not null,
    CALENDAR_DETAIL  VARCHAR2(200),
    START_DATE       VARCHAR2(20) not null,
    END_DATE         VARCHAR2(20),
    START_TIME       VARCHAR2(10),
    END_TIME         VARCHAR2(10),
    BACKGROUND_COLOR VARCHAR2(10),
    ALL_DAY          CHAR default null,
    IMAGE_URL        VARCHAR2(50)
)


CREATE TABLE MONOLOGUE
(
    MONOLOGUE_ID   NUMBER(8),
    QUESTION_ID    NUMBER(8) NOT NULL,
    USER_ID        VARCHAR2(30) NOT NULL,
    SHARE_STATUS   CHAR(1) DEFAULT 0,
    BLIND_STATUS   CHAR(1) DEFAULT 0,
    MONOLOGUE_TEXT VARCHAR2(2000) NOT NULL,
    REPORT_COUNT   NUMBER(8) DEFAULT 0,
    MONOLOGUE_DATE DATE NOT NULL,
    CONSTRAINT MONOLOGUE_PK PRIMARY KEY (MONOLOGUE_ID)
);


CREATE TABLE Questions
(
    question_id   NUMBER(8) PRIMARY KEY,
    question_text VARCHAR2(500) NOT NULL
);



CREATE TABLE TODOLIST
(
    TODOLIST_ID   NUMBER(8) PRIMARY KEY,
    USER_ID       VARCHAR2(30) NOT NULL,
    FINISH_STATUS CHAR(1) DEFAULT 0,
    TODOLIST_TEXT VARCHAR2(100) NOT NULL,
    TODOLIST_DATE DATE NOT NULL
);


CREATE TABLE WITHDRAWALREASONS
(
    WITHDRAWAL_REASON_ID   NUMBER(8) PRIMARY KEY,
    WITHDRAWAL_REASON_TYPE CHAR(1) NOT NULL,
    WITHDRAWAL_REASON_TEXT VARCHAR2(1000)
);


CREATE TABLE GOALS
(
    GOAL_ID   NUMBER(8) PRIMARY KEY,
    USER_ID   VARCHAR2(30) NOT NULL,
    GOAL_TEXT VARCHAR2(50),
    GOAL_DATE DATE
);


CREATE TABLE EMOTIONS
(
    EMOTION_ID   NUMBER(8) PRIMARY KEY,
    EMOTION_NAME VARCHAR2(20) NOT NULL,
    EMOTION_IMG  VARCHAR2(100) NOT NULL
);

INSERT INTO emotions
VALUES (1, '기쁨', '&#128512;');
INSERT INTO emotions
VALUES (2, '슬픔', '&#128549;');
INSERT INTO emotions
VALUES (3, '화남', '&#128545;');
INSERT INTO emotions
VALUES (4, '무표정', '&#128528;');
INSERT INTO emotions
VALUES (5, '심각', '&#128512;');
INSERT INTO emotions
VALUES (6, '힘듦', '&#128555;');
INSERT INTO emotions
VALUES (7, '짜증', '&#128548;');
INSERT INTO emotions
VALUES (8, '신나', '&#128537;');
INSERT INTO emotions
VALUES (9, '멘붕', '&#128552;');
INSERT INTO emotions
VALUES (10, '설렘', '&#128525;');
INSERT INTO emotions
VALUES (11, '좌절', '&#128557;');
INSERT INTO emotions
VALUES (12, '공포', '&#128561;');
INSERT INTO emotions
VALUES (13, '놀람', '&#128562;');
INSERT INTO emotions
VALUES (14, '당황', '&#128527;');
INSERT INTO emotions
VALUES (15, '민망', '&#128517;');
INSERT INTO emotions
VALUES (16, '아픔', '&#129298;');


CREATE TABLE REPORT
(
    report_id        NUMBER(8) PRIMARY KEY,
    report_reason_id CHAR(1) NOT NULL,
    diary_id         NUMBER(8),
    monologue_id     NUMBER(8),
    reporter_id      VARCHAR2(30) NOT NULL,
    report_date      DATE    NOT NULL,
    report_text      VARCHAR2(500)
);


CREATE TABLE AttachFile
(
    file_id     NUMBER(8) PRIMARY KEY,
    diary_id    NUMBER(8) NOT NULL,
    file_name   VARCHAR2(100),
    file_status char(1) NOT NULL
);


CREATE TABLE WEATHER
(
    WEATHER_ID   NUMBER(8) PRIMARY KEY,
    WEATHER_NAME VARCHAR2(20) NOT NULL,
    WEATHER_IMG  VARCHAR2(100) NOT NULL
);


회원관리

INSERT
INTO USERS (user_id, user_name, password, email, role, nickname, withdrawal_reason_id, motto, is_alarm_diary, is_alarm_monologue, blind_count, withdrawal_date, withdrawal_status, limit_start_date, limit_end_date, is_display_time, is_display_weather, is_display_location)
VALUES ('admin','admin','1234','admin@secretary.com', 'admin', '관리자', null, '웃으면 복이와요', 1, 1, null, null, null, null, null, 1, 1, 1);

INSERT
INTO USERS (user_id, user_name, password, email, role, nickname, withdrawal_reason_id, motto, is_alarm_diary,
            is_alarm_monologue, blind_count, withdrawal_date, withdrawal_status, limit_start_date, limit_end_date,
            is_display_time, is_display_weather, is_display_location)
VALUES ('manager', 'manager', '1234', 'manager@secretary.com', 'admin', '매니저', null, 'Napoleon Said....', 1, 1, null,
        null, null, null, null, 1, 1, 1);

INSERT
INTO USERS (user_id, user_name, password, email, role, nickname, withdrawal_reason_id, motto, is_alarm_diary,
            is_alarm_monologue, blind_count, withdrawal_date, withdrawal_status, limit_start_date, limit_end_date,
            is_display_time, is_display_weather, is_display_location)
VALUES ('user01', '김유저', '1111', 'user01@secretary.com', 'user', '나는유저다', null, '포기는 배추 셀 때나 쓰는 말', 1, 1, null, null,
        null, null, null, 1, 1, 1);

commit;