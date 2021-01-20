package com.nj.secretary.services.monologue.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;

@Mapper
public interface MonologueService {
	
	
	//Question
	
	public void addQuestionText(String questionText) throws Exception;
	
	public int getQuestionId(int questionId) throws Exception;
	
	public String getQuestionText(String questionText) throws Exception;
	
	public void deleteQuestionId(int questionId) throws Exception;
	
	public List<Question> getQuestionList() throws Exception;
	
	
	//Monologue
	public void addMonologueText(Monologue monologue) throws Exception;
	
	public void updateMonologuText(String monologueText) throws Exception;
	
	public void deleteMonologueId(int monologueId) throws Exception;
	
	public List<Monologue> getMonologue() throws Exception;
	
	
}
