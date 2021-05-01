package com.sunny.persistence;

import java.util.List;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;

public interface StoreDAO {
	
	//전체 상품 목록
	public List<GoodsViewVO> allList() throws Exception;
	
	//카테고리별 상품 목록: 1차분류
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;
	
	//카테고리별 상품 목록: 2차분류
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
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

}
