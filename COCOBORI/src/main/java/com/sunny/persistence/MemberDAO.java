package com.sunny.persistence;

import com.sunny.domain.MemberVO;

public interface MemberDAO {
	
	//ȸ������
	public void signUp(MemberVO vo) throws Exception;
	
	//�α���
	public MemberVO logIn(MemberVO vo) throws Exception;
	
	//���̵� ���翩�� Ȯ��
	public String logInExistID(String userID) throws Exception;

}
