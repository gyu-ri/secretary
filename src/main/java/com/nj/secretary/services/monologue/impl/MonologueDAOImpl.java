package com.nj.secretary.services.monologue.impl;

import java.util.List;

import com.nj.secretary.services.monologue.domain.Monologue;
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
	public void addQuestion(String questionText) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("monologueDAOImpi  addQuestionText~~");
		sqlsession.insert("MonologueMapper.addQuestion", questionText);
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
	public void deleteQuestion(int questionId) throws Exception {
		
		sqlsession.delete("MonologueMapper.deleteQuestion", questionId); 
		
	}
	
	
	
	
	//==============================Monologue===============================
	
	@Override
	public void addMonologue(Monologue monologue) throws Exception {
		System.out.println("monologueDAOImpl  addMonologueText~~~");
		sqlsession.insert("MonologueMapper.addMonologue", monologue);
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateMonologueText(String monologueText) throws Exception {
		
		sqlsession.update("MonologueMapper.updateMonologueText", monologueText);
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteMonologue(int questionId) throws Exception {
		

		sqlsession.delete("MonologueMapper.deleteMonologue", questionId);

		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Monologue> getReportedMonoList() {
  }
  
	@Override
	public Monologue getMonologueText(int questionId) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("MonologueMapper.getMonologueText", questionId);
	}


		List<Monologue> list = sqlsession.selectList("MonologueMapper.getReportedMonoList");

		return list;
	}

	@Override
	public int setBlindMonologue(int num) {

		sqlsession.update("MonologueMapper.setBlindMonologue", num);

		return 1;
	}
}
