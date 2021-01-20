package com.nj.secretary.services.monologue.repository;

import java.util.List;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;

public interface MonologueDAO {
	
	
	//Question
	
	public void addQuestionText(String questionText) throws Exception;
	
	public String getQuestionText(String questionText) throws Exception;

	public void deleteQuestionId(int questionId) throws Exception;

	public int getQeustionId(int questionId) throws Exception;
	
	public List<Question> getQuestionList() throws Exception;
	
	
	
	//monologue
	
	public void addMonologueText(Monologue monologue) throws Exception;
	
	public void updateMonologueText(String monologueText) throws Exception;
	
	public void deleteMonologueId(int monologueId) throws Exception;
	
	public Monologue getMonologueText(int questionId) throws Exception;
	
	
	
	
	
	
	
	
	
	
		
}
