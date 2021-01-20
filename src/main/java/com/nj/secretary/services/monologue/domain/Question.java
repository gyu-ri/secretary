package com.nj.secretary.services.monologue.domain;

import java.util.Date;

public class Question{
	
	//field
	private String questionText;
	private int questionId;
	
	//constructor
	public Question() {
		
	}



	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}




	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}



	@Override
	public String toString() {
		return "Question [questionText=" + questionText + ", questionId=" + questionId + "]";
	}


	
	
}


