package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;
import com.sunny.persistence.StoreDAO;

@Service
public class StoreServiceImpl implements StoreService {

	@Inject
	private StoreDAO dao;
	
	//전체 상품 목록
	@Override
	public List<GoodsViewVO> allList() throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: allList");
		
		return dao.allList();
	}

	//카테고리별 상품 목록
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: List");
		
		int cateCodeRef = 0;
		
		if(level == 1) {  //1차 분류
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		} else {  //2차분류
			return dao.list(cateCode);
		}
	}

	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: goodsView");
		
		return dao.goodsView(gdsNum);
	}

	//후기 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: registReply");
		
		dao.registReply(reply);
	}

	//상품 후기 목록
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: replyList");
		
		return dao.replyList(gdsNum);
	}

	//상품 후기 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: deleteReply");
		
		dao.deleteReply(reply);
	}

	
	//상품 후기 userID 확인
	@Override
	public String idCheck(int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: idCheck");
		
		return dao.idCheck(repNum);
	}

	//상품 후기 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: modifyReply");
		
		dao.modifyReply(reply);
	}
	
	//장바구니 담기
	@Override
	public void addCart(CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: addCart");
		
		dao.addCart(cart);
	}

	//장바구니 목록
	@Override
	public List<CartListVO> cartList(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: cartList");
		
		return dao.cartList(userID);
	}

}
