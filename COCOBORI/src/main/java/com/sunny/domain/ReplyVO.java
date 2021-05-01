package com.sunny.domain;

import java.util.Date;

public class ReplyVO {
	/* gdsNum		int				not null(PK, FK),			
	 * userID		varchar(50)		not null(FK),
	 * repNum		int				not null(PK),
	 * repCon		varchar(2000)	not null,
	 * repDate		datetime		dafault current_timestamp
	 */
	
	private int gdsNum;
	private String userID;
	private int repNum;
	private String repCon;
	private Date repDate;
	
	
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	
}