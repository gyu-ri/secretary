package com.nj.secretary.services.monologue.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nj.secretary.services.monologue.domain.Monologue;
import com.nj.secretary.services.monologue.domain.Question;
import com.nj.secretary.services.monologue.repository.MonologueDAO;

@Repository("monologueDAOImpl")
public class MonologueDAOImpl implements MonologueDAO{
	
	@Autowired
	SqlSession sqlsession;
	
	
	
	
	
	public MonologueDAOImpl() {
              System.out.println("default constructor �θ���~~~"+getClass());
 	}
	
	//=============================Question============================
	
	
	@Override
	public void addQuestionText(String questionText) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("monologueDAOImpi  addQuestionText~~");
		sqlsession.insert("MonologueMapper.addQuestionText", questionText);
	}
	
	
	@Override
	public List<Question> getQuestionList() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlsession.selectList("MonologueMapper.getQuestoinList");
	}
	
	
	@Override
	public int getQeustionId(int questionId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("monologueDAOImpi  getQuestionId~~");
		return sqlsession.selectOne("MonologueMapper.getQuestionId", questionId);
		
	}
	
	
	@Override
	public String getQuestionText(String questionText) throws Exception {
		
		return sqlsession.selectOne("MonologueMapper.getQuestionText", questionText);
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void deleteQuestionId(int questionId) throws Exception {
		
		sqlsession.delete("MonologueMapper.deleteQuestion", questionId); 
		
	}
	
	
	
	
	//==============================Monologue===============================
	
	@Override
	public void addMonologueText(Monologue monologue) throws Exception {
		System.out.println("monologueDAOImpl  addMonologueText~~~");
		sqlsession.insert("MonologueMapper.addMonologueText", monologue);
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateMonologueText(String monologueText) throws Exception {
		
		sqlsession.update("MonologueMapper.updateMonologueText", monologueText);
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteMonologueId(int monologueId) throws Exception {
		
		sqlsession.delete("Monologue.deleteMonologue", monologueId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Monologue getMonologueText(int questionId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("Monologue.getMonologueText", questionId);
	}


		
	
	
	
}
