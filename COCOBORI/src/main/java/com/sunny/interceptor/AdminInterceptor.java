package com.sunny.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sunny.domain.MemberVO;


public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	//������ ���� 
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		HttpSession session = req.getSession();
		MemberVO member =(MemberVO)session.getAttribute("member");
		
		if(member == null) {
			res.sendRedirect("/member/logIn");
			return false;
		}
		
		//일반회원이 url로 관리자 페이지에 접속하면 메인화면으로 돌려보냄
		if(member.getVerify() != 9) {
			res.sendRedirect("/");
			return false;
		}
		return true;
	}

}
