package com.nj.secretary.services.monologue.domain;

import java.util.Date;

public class Monologue{
	
	//field
	private String userId;           //????? ?????:???X
//	private String questionText;     //1??????
	private String monologueText;    //1????
//	private int questionId;          //1?????????
	private int monologueId;         //1????????
	private int reportCount;         //????
	private boolean shareStatus;     //???????? 0:default:false
	private boolean blindStatus;     //????ех???? 0:default:false
	private Date monologueDate;      //1???????
	
	
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
//	private String userId;           //????? ?????:???X
//	private String questionText;     //1??????
//	private String monologueText;    //1????
//	private int questionId;          //1?????????
//	private int monologueId;         //1????????
//	private int reportCount;         //????
//	private boolean shareStatus;     //???????? 0:default:false
//	private boolean blindStatus;     //????ех???? 0:default:false
//	private Date monologueDate;      //1???????
//	
//	
//	
//	
//	
//	
//}
