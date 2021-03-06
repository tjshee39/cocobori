package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: category");
		
		return dao.category();
	}
	
	//상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: register");
		
		dao.register(vo);
	}
	
	//상품 목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodslist");
		
		return dao.goodslist();
	}
	
	//상품 조회(카테고리까지)
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodsView");
		
		return dao.goodsView(gdsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodsModify");
		
		dao.goodsModify(vo);
	}
	
	//상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: goodsDelete");
		
		dao.goodsDelete(gdsNum);
	}
	
	//주문 목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: orderList");
		
		return dao.orderList();
	}
	
	//특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: orderView");
		
		return dao.orderView(order);
	}
	
	//배송 상태
	@Override
	public void delivery(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: delivery");
		
		dao.delivery(order);
	}
	
	//상품 수량 조절
	@Override
	public void changeStock(GoodsVO goods) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: changeStock");
		
		dao.changeStock(goods);
	}
	
	//모든 상품 후기 출력
	@Override
	public List<ReplyListVO> allReply() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: allReply");
		
		return dao.allReply();
	}
	
	//후기 삭제
	@Override
	public void deleteReply(int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminServiceImpl:: deleteReply");
		
		dao.deleteReply(repNum);
	}
}
