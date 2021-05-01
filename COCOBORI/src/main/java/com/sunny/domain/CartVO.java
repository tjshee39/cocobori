package com.sunny.domain;

import java.util.Date;

public class CartVO {
	
/*
 * 	cartNum			int				not null(PK),
 *  userID			varchar(50)		not null(PK, FK),
 *  gdsNum			int				not null(FK),
 *  cartStock		int				not null,
 *  addDate			datetime		default current_timestamp
 */
	
	private int cartNum;
	private String userID;
	private int gdsNum;
	private int cartStock;
	private Date addDate;
	
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}	

}
