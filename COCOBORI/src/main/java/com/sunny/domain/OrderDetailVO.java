package com.sunny.domain;

import java.util.Date;

public class OrderDetailVO {
/*
 *  orderDetailsNum		int				not null(PK),
 *  orderID				varchar(50)		not null(FK),
 * 	gdsNum				int				not null,
 * 	cartStock			int				not null
 */

	private int orderDetailsNum;
	private String orderID;
	private int gdsNum;
	private int cartStock;
	
	
	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	
	
	
}