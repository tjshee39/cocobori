package com.sunny.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sunny.domain.MemberVO;
import com.sunny.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO dao;
	
	//ȸ������
	@Override
	public void signUp(MemberVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberServiceImpl:: signUp");
		
		dao.signUp(vo);
	}
	
	//�α���
	@Override
	public MemberVO logIn(MemberVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberServiceImpl:: logIn");
		
		return dao.logIn(vo);
	}
	
	//���̵� ���翩�� Ȯ��
	public String logInExistID(MemberVO vo, String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberServiceImpl:: logInExistID");
		
		String get_userID = dao.logInExistID(vo.getUserID());
		System.out.println("memberserviceimpl:loginexistid: " + get_userID);
		
		if(get_userID != null) {
			vo.setVerify(-1);
		} else {
			vo.setVerify(0);
		}
		
		return dao.logInExistID(userID);
	}
	
	//�α׾ƿ�
	@Override
	public void logOut(HttpSession session) throws Exception {
		session.invalidate();
	}

}
