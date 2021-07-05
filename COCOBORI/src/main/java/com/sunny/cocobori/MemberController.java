package com.sunny.cocobori;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunny.domain.MemberVO;
import com.sunny.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {

	return new BCryptPasswordEncoder();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입 화면 출력
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public void getSignUp() throws Exception {
		System.out.println("========================================");
		System.out.println("MemberController:: getSignUp");
	}
	
	//회원가입
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String postSignUp(MemberVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberController:: postSignUp");
		
		String inputPW = vo.getUserPW();
		String pw = passEncoder.encode(inputPW);
		vo.setUserPW(pw);
		
		service.signUp(vo);
		
		return "redirect:/";
	}
	
	//로그인 화면 출력
	@RequestMapping(value="/logIn", method = RequestMethod.GET)
	public void getLogIn() throws Exception {
		System.out.println("========================================");
		System.out.println("MemberController:: getLogIn");
	}
	
	//로그인
	@RequestMapping(value="/logIn", method = RequestMethod.POST)
	public String postLogIn(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr, String userID) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberController:: postLogIn");
		System.out.println("userID:: " + vo.getUserID());
		System.out.println("userPW:: " + vo.getUserPW());
		
		String logInExistID = service.logInExistID(vo, userID);
		System.out.println("MemberControlloer::logInExistID:: " + logInExistID);
		
		HttpSession session = req.getSession();
		
		if(logInExistID == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/logIn";
		}
		
		MemberVO logIn = service.logIn(vo);
		
		boolean passMatch = passEncoder.matches(vo.getUserPW(), logIn.getUserPW());
		
		if(logIn != null && passMatch) {
			session.setAttribute("member", logIn);
		} else if(logInExistID == null || logIn == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/logIn";
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/logIn";
		}
		
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value="/logOut", method = RequestMethod.GET)
	public String LogOut(HttpSession session) throws Exception {
		System.out.println("========================================");
		System.out.println("MemberController:: LogOut");
		
		service.logOut(session);
		
		return "redirect:/";
	}
}
