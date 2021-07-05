package com.sunny.persistence;

import java.util.List;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;

public interface AdminDAO {
	
	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	//상품 등록
	public void register(GoodsVO vo) throws Exception;
	
	//상품 목록
	public List<GoodsViewVO> goodslist() throws Exception;
	
	//상품 조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//상품 삭제
	public void goodsDelete(int gdsNum) throws Exception;
	
	//주문 목록
	public List<OrderVO> orderList() throws Exception;
	
	//주문 정보 조회
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	
	//배송 상태 변경
	public void delivery(OrderVO order) throws Exception;
	
	//물품 수량 변경
	public  void changeStock(GoodsVO goods) throws Exception;
	
	//상품 후기 목록
	public List<ReplyListVO> allReply() throws Exception;
	
	//상품 후기 삭제
	public void deleteReply(int repNum) throws Exception;

}
