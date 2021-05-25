package com.sunny.domain;

import java.util.Date;

public class OrderVO {
/*
 *  orderID			varchar(50)		not null(PK),
 *  userID			varchar(50)		not null(FK),
 * 	orderRec		varchar(50)		not null(수신자),
 * 	userAddr		varchar(100)	not null,
 * 	userAddrDetail	varchar(100)	not null,
 *	userAddrZip		varchar(100)	not null,
 *	orderPhon		varchar(30)		not null,
 *	amount			int				not null,
 *	orderDate		datetime		dafault CURRENT_TIMESTAMP,
 *	delivery		varchar(20)		default 배송준비
 */

	
	private String orderID;
	private String userID;
	private String orderRec;
	private String userAddr;
	private String userAddrDetail;
	private String userAddrZip;
	private String orderPhon;
	private int amount;
	private Date orderDate;
	private String delivery;
	
	
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOrderRec() {
		return orderRec;
	}
	public void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
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
	public String getUserAddrZip() {
		return userAddrZip;
	}
	public void setUserAddrZip(String userAddrZip) {
		this.userAddrZip = userAddrZip;
	}
	public String getOrderPhon() {
		return orderPhon;
	}
	public void setOrderPhon(String orderPhon) {
		this.orderPhon = orderPhon;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}