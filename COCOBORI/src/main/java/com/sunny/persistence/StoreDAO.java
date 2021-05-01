package com.sunny.persistence;

import java.util.List;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;

public interface StoreDAO {
	
	//��ü ��ǰ ���
	public List<GoodsViewVO> allList() throws Exception;
	
	//ī�װ��� ��ǰ ���: 1���з�
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	//ī�װ��� ��ǰ ���: 2���з�
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
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

}
