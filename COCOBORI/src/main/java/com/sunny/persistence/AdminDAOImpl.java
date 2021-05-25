package com.sunny.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.sunny.mappers.adminMapper";
	
	//ī�װ�
	@Override
	public List<CategoryVO> category() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: category");
		
		return sql.selectList(namespace + ".category");
	}
	
	//��ǰ ���
	@Override
	public void register(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: register");
		
		sql.insert(namespace + ".register", vo);
	}
	
	//��ǰ ���
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodslist");
		
		return sql.selectList(namespace + ".goodslist");
	}
	
	//��ǰ ��ȸ(ī�װ�����)
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodsView");
		
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	
	//��ǰ ����
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodsModify");
		
		sql.update(namespace + ".goodsModify", vo);
	}
	
	//��ǰ ����
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodsDelete");
		
		sql.delete(namespace + ".goodsDelete", gdsNum);
	}
	
	//�ֹ� ���
	@Override
	public List<OrderVO> orderList() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: orderList");
		
		return sql.selectList(namespace + ".orderList");
	}
	
	//Ư�� �ֹ� ���
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: orderView");
		
		return sql.selectList(namespace + ".orderView", order);
	}
	
	//��� ����
	@Override
	public void delivery(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: delivery");
		
		sql.update(namespace + ".delivery", order);
	}

}
