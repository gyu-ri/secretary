package com.nj.secretary.services.monologue.domain;

import java.util.Date;

public class Monologue{
	


	private String userId;           //����� ���̵�:�ߺ�X
	private String questionText;     //1������
	private String monologueText;    //1�䳻��
	private int questionId;          //1��������ȣ

	private int monologueId;         //1�������ȣ
	private int reportCount;         //�Ű��
	private boolean shareStatus;     //�������� 0:default:false
	private boolean blindStatus;     //����ε���� 0:default:false
	private Date monologueDate;      //1���ۼ���

	private String postGroup = "monologue";
	private String reportReasonId;
	private String reporterId;
	private Date reportDate;
	private String reportText;
	

	
	//constructor
	public Monologue() {
		
	}



	//Method
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getMonologueText() {
		return monologueText;
	}


	public void setMonologueText(String monologueText) {
		this.monologueText = monologueText;
	}




	public int getMonologueId() {
		return monologueId;
	}


	public void setMonologueId(int monologueId) {
		this.monologueId = monologueId;
	}


	public int getReportCount() {
		return reportCount;
	}


	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}


	public boolean isShareStatus() {
		return shareStatus;
	}


	public void setShareStatus(boolean shareStatus) {
		this.shareStatus = shareStatus;
	}


	public boolean isBlindStatus() {
		return blindStatus;
	}


	public void setBlindStatus(boolean blindStatus) {
		this.blindStatus = blindStatus;
	}


	public Date getMonologueDate() {
		return monologueDate;
	}


	public void setMonologueDate(Date monologueDate) {
		this.monologueDate = monologueDate;
	}

	public String getReportReasonId() {
		return reportReasonId;
	}

	public void setReportReasonId(String reportReasonId) {
		this.reportReasonId = reportReasonId;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportText() {
		return reportText;
	}

	public void setReportText(String reportText) {
		this.reportText = reportText;
	}

	

	public int getQuestionId() {
		return questionId;
	}





	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}





	@Override
	public String toString() {
		return "Monologue [userId=" + userId + ", monologueText=" + monologueText + ", questionId=" + questionId
				+ ", monologueId=" + monologueId + ", reportCount=" + reportCount + ", shareStatus=" + shareStatus
				+ ", blindStatus=" + blindStatus + ", monologueDate=" + monologueDate + "]";
	}





	
	
	
}




//
//
//import java.io.Serializable;
//import java.util.Date;
//
//import lombok.Data;
//
//@Data
//public class Monologue implements Serializable {
//	
//	private String userId;           //����� ���̵�:�ߺ�X
//	private String questionText;     //1������
//	private String monologueText;    //1�䳻��
//	private int questionId;          //1��������ȣ
//	private int monologueId;         //1�������ȣ
//	private int reportCount;         //�Ű��
//	private boolean shareStatus;     //�������� 0:default:false
//	private boolean blindStatus;     //����ε���� 0:default:false
//	private Date monologueDate;      //1���ۼ���
//	
//	
//	
//	
//	
//	
//}

