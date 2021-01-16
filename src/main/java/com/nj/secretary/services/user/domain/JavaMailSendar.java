package com.nj.secretary.services.user.domain;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class JavaMailSendar {

    public JavaMailSender mailSender;
    public MimeMessage mimeMessage;
    public MimeMessageHelper mimeMessageHelper;
    
    public JavaMailSendar(JavaMailSender mailSender) throws MessagingException{
        this.mailSender = mailSender;
        mimeMessage = mailSender.createMimeMessage();
        mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
    }

    public void setFrom(String fromEmail) throws MessagingException{
        mimeMessageHelper.setFrom(fromEmail);//발송자
    }

    public void setTo(String email) throws MessagingException{
        mimeMessageHelper.setTo(email);//수신자
    }

    public void setText(String text, boolean useHtml) throws MessagingException{
        mimeMessageHelper.setText(text,useHtml);//메일 내용
    }

    public void setSubject(String subject) throws MessagingException{
        mimeMessageHelper.setSubject(subject);
    }

    public void send(){
        try{
            mailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
