package com.sunny.persistence;

import java.util.List;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;

public interface AdminDAO {
	
	//ī�װ�
	public List<CategoryVO> category() throws Exception;
	
	//��ǰ ���
	public void register(GoodsVO vo) throws Exception;
	
	//��ǰ ���
	public List<GoodsViewVO> goodslist() throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//��ǰ ����
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//��ǰ ����
	public void goodsDelete(int gdsNum) throws Exception;
	
	//�ֹ� ���
	public List<OrderVO> orderList() throws Exception;
	
	//Ư�� �ֹ� ���
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	
	//��� ����
	public void delivery(OrderVO order) throws Exception;

}
