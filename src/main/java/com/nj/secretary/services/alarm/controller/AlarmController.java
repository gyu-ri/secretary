package com.nj.secretary.services.alarm.controller;


import com.nj.secretary.services.diary.service.DiaryService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/count")
public class AlarmController extends TextWebSocketHandler{

    @Autowired
    DiaryService diaryService;

    private final Logger logger = LogManager.getLogger(getClass());

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        Object obj = "user02";
        this.logger.info(message.getPayload());
        session.sendMessage(new TextMessage(diaryService.getCount(obj)));
    }



}
