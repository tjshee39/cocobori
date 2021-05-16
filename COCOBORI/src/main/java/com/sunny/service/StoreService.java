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
	
	//전체 상품 목록
	public List<GoodsViewVO> allList() throws Exception;
	
	//카테고리별 상품 목록
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	//상품 조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//후기 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	//상품 후기 목록
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;

	//상품 후기 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//상품 후기 userID 체크
	public String idCheck(int repNum) throws Exception;
	
	//상품 후기 수정
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//장바구니 담기
	public void addCart(CartVO cart) throws Exception;
	
	//장바구니 목록
	public List<CartListVO> cartList(String userID) throws Exception;
	
	//장바구니 삭제
	public void deleteCart(CartVO cart) throws Exception;
	
	//주문 정보
	public void orderInfo(OrderVO order) throws Exception;
	
	//주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
	
	//구매 후 장바구니 비우기
	public void cartAllDelete(String userID) throws Exception;
	
	//주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	//특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
