package com.sunny.domain;

import java.util.Date;

public class MemberVO {
	
/*
 * 	userID			varchar(50)		not null(PK),
 *  userPW			varchar(100)	not null,
 *  userName		varchar(30)		not null,
 *  userPhone		varchar(20)		not null,
 *  userAddrZip		varchar(20)		not null(우편번호),
 *  userAddr		varchar(50)		not null(일반주소),
 *  userAddrDetail	varchar(50)		not null(상세주소),
 *  regDate			datetime		default current_timestamp,
 *  verify			int				default 0(인증여부);
 */
	
	private String userID;
	private String userPW;
	private String userName;
	private String userPhone;
	private String userAddrZip;
	private String userAddr;
	private String userAddrDetail;
	private String userClassification;
	private Date regDate;
	private int verify;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddrZip() {
		return userAddrZip;
	}
	public void setUserAddrZip(String userAddrZip) {
		this.userAddrZip = userAddrZip;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserAddrDetail() {
		return userAddrDetail;
	}
	public void setUserAddrDetail(String userAddrDetail) {
		this.userAddrDetail = userAddrDetail;
	}
	public String getUserClassification() {
		return userClassification;
	}
	public void setUserClassification(String userClassification) {
		this.userClassification = userClassification;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	
	
	

}
