package com.sunny.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;

@Repository
public class StoreDAOImpl implements StoreDAO{
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.sunny.mappers.storeMapper";
	
	//전체 상품 목록
	@Override
	public List<GoodsViewVO> allList() throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: allList");
		
		return sql.selectList(namespace + ".allList");
	}

	//카테고리별 상품 목록: 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: List_1");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace + ".list_1", map);
	}

	//카테고리별 상품 목록: 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: List_2");
		
		return sql.selectList(namespace + ".list_2", cateCode);
	}

	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception { 
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: goodsView");
		
		return sql.selectOne("com.sunny.mappers.adminMapper" + ".goodsView", gdsNum);
	}

	//후기 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: registReply");
		
		sql.insert(namespace + ".registReply", reply);
	}

	//상품 후기 목록
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: replyList");
		
		return sql.selectList(namespace + ".replyList", gdsNum);
	}

	//상품 후기 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: deleteReply");
		
		sql.delete(namespace + ".deleteReply", reply);		
	}

	//상품 후기 userID 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: idCheck");
		
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	//상품 후기 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: modifyReply");
		
		sql.update(namespace + ".modifyReply", reply);
	}
	
	//장바구니 담기
	@Override
	public void addCart(CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: addCart");
		
		sql.insert(namespace + ".addCart", cart);
	}
	
	//장바구니 목록
	@Override
	public List<CartListVO> cartList(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: cartList");
		
		return sql.selectList(namespace + ".cartList", userID);	
	}
	

}
