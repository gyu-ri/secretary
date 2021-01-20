package com.nj.secretary.services.monologue.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;
import com.nj.secretary.services.monologue.repository.MonologueDAO;
import com.nj.secretary.services.monologue.service.MonologueService;

@Service
public class MonologueServiceImpl implements MonologueService {
	
	@Autowired
	@Qualifier("monologueDAOImpl")
	MonologueDAO monologueDAO;

	
	
	
	//=============================Question============================
	@Override
	public void addQuestionText(String questionText) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("monologueServiceImpl   addQuestionText@@");
		monologueDAO.addQuestionText(questionText);
		
	}
	
	
	@Override
	public int getQuestionId(int questionId) throws Exception {
		System.out.println("monologueServiceImpl   getQuestionId@@");
		// TODO Auto-generated method stub
		return monologueDAO.getQeustionId(questionId);
	}
	

	@Override
	public String getQuestionText(String questionText) throws Exception {
		// TODO Auto-generated method stub
		return monologueDAO.getQuestionText(questionText);
	}
	
	
	@Override
	public void deleteQuestionId(int questionId) throws Exception {
		
    	monologueDAO.deleteQuestionId(questionId);
		
		
	}

	
	@Override
	public List<Question> getQuestionList() throws Exception {
		// TODO Auto-generated method stub
		return monologueDAO.getQuestionList();
	}
	
	
	
	
	
	//==============================Monologue===============================

	
	@Override
	public void addMonologueText(String monologueText) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("monologueServiceImpl   addMonologueText@@");
		monologueDAO.addMonologueText(monologueText);
		
	}
	
	
	@Override
	public void updateMonologuText(String monologueText) throws Exception {
		// TODO Auto-generated method stub
		
		monologueDAO.updateMonologueText(monologueText);
		
	}


	@Override
	public void deleteMonologueId(int monologueId) throws Exception {
		
		monologueDAO.deleteMonologueId(monologueId);
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Monologue> getMonologue() throws Exception {
		// TODOAuto-generated method stub
		return monologueDAO.getMonologue();
	}


	
	
	

}
