package com.sunny.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;

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
	public List<GoodsVO> goodslist() throws Exception {
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

}
