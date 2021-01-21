package com.nj.secretary.services.monologue.domain;

import java.util.Date;

public class Monologue{
	
	//field
	private String userId;
//	private String questionText;
	private String monologueText;
//	private int questionId;
	private int monologueId;
	private int reportCount;
	private boolean shareStatus;
	private boolean blindStatus;
	private Date monologueDate;
	
	
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


	@Override
	public String toString() {
		return "Monologue [userId=" + userId + ", monologueText=" + monologueText + ", monologueId=" + monologueId
				+ ", reportCount=" + reportCount + ", shareStatus=" + shareStatus + ", blindStatus=" + blindStatus
				+ ", monologueDate=" + monologueDate + "]";
	}


	
	
	
	
	
}




