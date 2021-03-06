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
import com.sunny.domain.ReplyListVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.sunny.mappers.adminMapper";
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: category");
		
		return sql.selectList(namespace + ".category");
	}
	
	//상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: register");
		
		sql.insert(namespace + ".register", vo);
	}
	
	//상품 목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodslist");
		
		return sql.selectList(namespace + ".goodslist");
	}
	
	//상품 조회(카테고리까지)
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodsView");
		
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodsModify");
		
		sql.update(namespace + ".goodsModify", vo);
	}
	
	//상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: goodsDelete");
		
		sql.delete(namespace + ".goodsDelete", gdsNum);
	}
	
	//주문 목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: orderList");
		
		return sql.selectList(namespace + ".orderList");
	}
	
	//특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: orderView");
		
		return sql.selectList(namespace + ".orderView", order);
	}
	
	//배송 상태
	@Override
	public void delivery(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: delivery");
		
		sql.update(namespace + ".delivery", order);
	}
	
	//상품 수량 조절
	@Override
	public void changeStock(GoodsVO goods) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: changeStock");
		
		sql.update(namespace + ".changeStock", goods);
	}
	
	//모든 상품 후기 출력
	@Override
	public List<ReplyListVO> allReply() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: allReply");
		
		return sql.selectList(namespace + ".allReply");
	}
	
	//후기 삭제
	@Override
	public void deleteReply(int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminDAOImpl:: deleteReply");
		
		sql.delete(namespace + ".deleteReply", repNum);
	}

}
