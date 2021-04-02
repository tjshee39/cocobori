package com.sunny.persistence;

import com.sunny.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void signUp(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO logIn(MemberVO vo) throws Exception;
	
	//아이디 존재여부 확인
	public String logInExistID(String userID) throws Exception;

}
