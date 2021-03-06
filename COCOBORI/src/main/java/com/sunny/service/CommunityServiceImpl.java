package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.CommunityVO;
import com.sunny.domain.CommunityViewVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;
import com.sunny.persistence.CommunityDAO;
import com.sunny.persistence.StoreDAO;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Inject
	private CommunityDAO dao;
	
	//커뮤니티 게시글 작성
	@Override
	public void register(CommunityVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityServiceImpl:: register");
		
		dao.register(vo);
	}
	
	//커뮤니티 게시글 목록
	@Override
	public List<CommunityViewVO> allList() throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityServiceImpl:: allList");
		
		return dao.allList();
	}


	//커뮤니티 게시글 조회
	@Override
	public CommunityViewVO boardView(int boardNum) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityServiceImpl:: boardView");
		
		return dao.boardView(boardNum);
	}

	//커뮤니티 게시글 수정
	@Override
	public void boardModify(CommunityVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityServiceImpl:: boardModify");
		
		dao.boardModify(vo);
	}

	//커뮤니티 게시글 삭제
	@Override
	public void boardDelete(int boardNum) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityServiceImpl:: boardDelete");
		
		dao.boardDelete(boardNum);
	}

	//��ǰ �ı� ����
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: deleteReply");
		
		dao.deleteReply(reply);
	}

	
	//��ǰ �ı� userID Ȯ��
	@Override
	public String idCheck(int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: idCheck");
		
		return dao.idCheck(repNum);
	}

	//��ǰ �ı� ����
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: modifyReply");
		
		dao.modifyReply(reply);
	}
	
	//��ٱ��� ���
	@Override
	public void addCart(CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: addCart");
		
		dao.addCart(cart);
	}

	//��ٱ��� ���
	@Override
	public List<CartListVO> cartList(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: cartList");
		
		return dao.cartList(userID);
	}
	
	//��ٱ��� ����
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: deleteCart");
		
		dao.deleteCart(cart);
	}
	
	//�ֹ� ����
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: orderInfo");
		
		dao.orderInfo(order);
	}
	
	//�ֹ� �� ����
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: orderInfo_Details");
		
		dao.orderInfo_Details(orderDetail);
	}
	
	//���� �� ��ٱ��� ����
	@Override
	public void cartAllDelete(String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: cartAllDelete");
		
		dao.cartAllDelete(userID);
	}
	
	//�ֹ� ���
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: orderList");
		
		return dao.orderList(order);
	}
	
	//Ư�� �ֹ� ���
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreServiceImpl:: orderView");
		
		return dao.orderView(order);
	}

}
