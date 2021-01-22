package com.nj.secretary.services.monologue.service;

import java.util.List;

import com.nj.secretary.services.monologue.domain.Monologue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;

@Mapper
public interface MonologueService {
	
	
	//Question
	
	public void addQuestion(String questionText) throws Exception;
	
	public String getQuestionText(String questionText) throws Exception;
	
	public void deleteQuestion(int monologueId) throws Exception;
	
	public List<Question> getQuestionList() throws Exception;
	
	
	//Monologue
	public void addMonologue(Monologue monologue) throws Exception;
	
	public void updateMonologu(String monologueText) throws Exception;

	public void deleteMonologue(int questionId) throws Exception;
	
	public List<Monologue> getMonologueList(String userId) throws Exception;

	public List<Monologue> getReportedMonoList();

	public int setBlindMonologue(int num);
	
	public Monologue getMonologue(int monologueId) throws Exception;
	
	public List<Monologue> getMonologueReportReason(int monologueId);
}
