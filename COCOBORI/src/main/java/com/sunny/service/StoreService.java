package com.sunny.service;

import java.util.List;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;

public interface StoreService {
	
	//��ü ��ǰ ���
	public List<GoodsViewVO> allList() throws Exception;
	
	//ī�װ��� ��ǰ ���
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//�ı� �ۼ�
	public void registReply(ReplyVO reply) throws Exception;
	
	//��ǰ �ı� ���
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;

	//��ǰ �ı� ����
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//��ǰ �ı� userID üũ
	public String idCheck(int repNum) throws Exception;
	
	//��ǰ �ı� ����
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//��ٱ��� ���
	public void addCart(CartVO cart) throws Exception;
	
	//��ٱ��� ���
	public List<CartListVO> cartList(String userID) throws Exception;
	
	//��ٱ��� ����
	public void deleteCart(CartVO cart) throws Exception;
	
	//�ֹ� ����
	public void orderInfo(OrderVO order) throws Exception;
	
	//�ֹ� �� ����
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
	
	//���� �� ��ٱ��� ����
	public void cartAllDelete(String userID) throws Exception;
	
	//�ֹ� ���
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	//Ư�� �ֹ� ���
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
