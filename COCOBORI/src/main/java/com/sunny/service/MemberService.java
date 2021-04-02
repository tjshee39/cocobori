package com.sunny.service;

import javax.servlet.http.HttpSession;

import com.sunny.domain.MemberVO;

public interface MemberService {
	
	//ȸ������
	public void signUp(MemberVO vo) throws Exception;
	
	//�α���
	public MemberVO logIn(MemberVO vo) throws Exception;
	
	//���̵� ���翩�� Ȯ��
	public String logInExistID(MemberVO vo, String userID)throws Exception;
	
	//�α׾ƿ�
	public void logOut(HttpSession session) throws Exception;

}
