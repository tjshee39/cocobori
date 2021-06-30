package com.sunny.domain;

import java.util.Date;

public class CommunityVO {
/*
 *  boardNum		int				not null(PK),
 *  userID			varchar(50)		not null(FK),
 * 	boardTitle		varchar(100)	not null,
 * 	boardContent	varchar(1000)	not null,
 * 	regDate			date			default current_timestamp,
 *	boardImg		varchar(200)
 */
	
	private int boardNum;
	private String userID;
	private String boardTitle;
	private String boardContent;
	private Date regDate;
	private String boardImg;
	
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getBoardImg() {
		return boardImg;
	}
	public void setBoardImg(String boardImg) {
		this.boardImg = boardImg;
	}
	
	
}
