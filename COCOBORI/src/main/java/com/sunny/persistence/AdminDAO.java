package com.sunny.persistence;

import java.util.List;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;

public interface AdminDAO {
	
	//ī�װ�
	public List<CategoryVO> category() throws Exception;
	
	//��ǰ ���
	public void register(GoodsVO vo) throws Exception;
	
	//��ǰ ���
	public List<GoodsVO> goodslist() throws Exception;
	
	//��ǰ ��ȸ
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//��ǰ ����
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//��ǰ ����
	public void goodsDelete(int gdsNum) throws Exception;

}
