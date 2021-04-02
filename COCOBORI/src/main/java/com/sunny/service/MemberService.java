package com.sunny.service;

import javax.servlet.http.HttpSession;

import com.sunny.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	public void signUp(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO logIn(MemberVO vo) throws Exception;
	
	//아이디 존재여부 확인
	public String logInExistID(MemberVO vo, String userID)throws Exception;
	
	//로그아웃
	public void logOut(HttpSession session) throws Exception;

}
