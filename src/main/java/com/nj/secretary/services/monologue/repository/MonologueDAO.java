package com.nj.secretary.services.monologue.repository;

import java.util.List;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;

public interface MonologueDAO {
	
	
	//Question
	
	public void addQuestion(String questionText) throws Exception;
	
	public String getQuestionText(String questionText) throws Exception;

	public void deleteQuestion(int questionId) throws Exception;

	public List<Question> getQuestionList() throws Exception;
	
	
	
	//monologue
	
	public void addMonologue(Monologue monologue) throws Exception;
	
	public void deleteMonologue(int monologueId) throws Exception;
	
	public List<Monologue> getMonologueList(String userId) throws Exception;
	
	public void updateMonologue(String monologueText) throws Exception;
	
	public List<Monologue> getReportedMonoList();

	public int setBlindMonologue(int num);

	public Monologue getMonologue(int monologueId) throws Exception;
	
	public List<Monologue> getMonologueReportReason(int monologueId);
	
	
	
	
	
	
	
	
		
}
