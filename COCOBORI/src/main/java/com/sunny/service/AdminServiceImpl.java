package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;
	
	//ī�װ�
	@Override
	public List<CategoryVO> category() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: category");
		
		return dao.category();
	}
	
	//��ǰ ���
	@Override
	public void register(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: register");
		
		dao.register(vo);
	}
	
	//��ǰ ���
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodslist");
		
		return dao.goodslist();
	}
	
	//��ǰ ��ȸ(ī�װ�����)
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodsView");
		
		return dao.goodsView(gdsNum);
	}
	
	//��ǰ ����
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodsModify");
		
		dao.goodsModify(vo);
	}
	
	//��ǰ ����
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodsDelete");
		
		dao.goodsDelete(gdsNum);
	}

}
