package com.sunny.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sunny.domain.MemberVO;


public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	//관리자 여부 확인
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO member =(MemberVO)session.getAttribute("member");
		
		if(member == null) {
			res.sendRedirect("/member/logIn");
			return false;
		}
		
		//관리자 아니면 메인페이지로 보내줌
		if(member.getVerify() != 9) {
			res.sendRedirect("/");
			return false;
		}
		return true;
	}

}
