package com.sunny.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.CommunityVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;

@Repository
public class CommunityDAOImpl implements CommunityDAO{
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.sunny.mappers.comunityMapper";
	
	//커뮤니티 게시글 작성
	@Override
	public void register(CommunityVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("ComunityDAOImpl:: register");
		
		sql.insert(namespace + ".register", vo);
	}
	
	//커뮤니티 게시글 목록
	@Override
	public List<CommunityVO> allList() throws Exception {
		System.out.println("========================================");
		System.out.println("ComunityDAOImpl:: allList");
		
		return sql.selectList(namespace + ".allList");
	}

	//ī�װ��� ��ǰ ���: 2�� �з�
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: List_2");
		
		return sql.selectList(namespace + ".list_2", cateCode);
	}

	//��ǰ ��ȸ
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception { 
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: goodsView");
		
		return sql.selectOne("com.sunny.mappers.adminMapper" + ".goodsView", gdsNum);
	}

	//�ı� �ۼ�
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: registReply");
		
		sql.insert(namespace + ".registReply", reply);
	}

	//��ǰ �ı� ���
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: replyList");
		
		return sql.selectList(namespace + ".replyList", gdsNum);
	}

	//��ǰ �ı� ����
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: deleteReply");
		
		sql.delete(namespace + ".deleteReply", reply);		
	}

	//��ǰ �ı� userID üũ
	@Override
	public String idCheck(int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: idCheck");
		
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	//��ǰ �ı� ����
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: modifyReply");
		
		sql.update(namespace + ".modifyReply", reply);
	}
	
	//��ٱ��� ���
	@Override
	public void addCart(CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: addCart");
		
		sql.insert(namespace + ".addCart", cart);
	}
	
	//��ٱ��� ���
	@Override
	public List<CartListVO> cartList(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: cartList");
		
		return sql.selectList(namespace + ".cartList", userID);	
	}
	
	//��ٱ��� ����
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: deleteCart");
		
		sql.delete(namespace + ".deleteCart", cart);
	}
	
	//�ֹ� ����
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: orderInfo");
		
		sql.insert(namespace + ".orderInfo", order);
	}
	
	//�ֹ� �� ����
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: orderInfo_Details");
		
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
	}
	
	//���� �� ��ٱ��� ����
	@Override
	public void cartAllDelete(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: cartAllDelete");
		
		sql.delete(namespace + ".cartAllDelete", userID);
	}
	
	//�ֹ� ���
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: orderList");
		
		return sql.selectList(namespace + ".orderList", order);
	}

	//Ư�� �ֹ� ���
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreDAOImpl:: orderView");
		
		return sql.selectList(namespace + ".orderView", order);
	}
}
