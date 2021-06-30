package com.sunny.cocobori;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.domain.CartListVO;
import com.sunny.domain.CartVO;
import com.sunny.domain.CategoryVO;
import com.sunny.domain.CommunityVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.MemberVO;
import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;
import com.sunny.service.CommunityService;

import net.sf.json.JSONArray;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/community/*")
public class CommunityController {
	
	
	@Inject
	CommunityService service;
	
	//메인
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void getComunity(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityController:: getBoardList");
		
		List<CommunityVO> list= service.allList();
		
		model.addAttribute("list", list);
	}
	
	//게시글 작성 화면 출력
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void getRegister(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityController:: getRegister");
	} 
	
	/*
	//게시글 작성
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String postRegister(ComunityVO comunity, HttpSession session) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityController:: postRegister");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		comunity.setUserID(member.getUserID());
		
		service.register(comunity);
		
		return "redirect:/";
	}
	*/
	
	//게시글 등록(ckEditor)
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public String boardCkUpload(CommunityVO comunity, HttpSession session, HttpServletRequest req, 
			HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		System.out.println("========================================");
		System.out.println("CommunityController:: boardCkUpload");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		comunity.setUserID(member.getUserID());
		
		// 인코딩 
		res.setCharacterEncoding("utf-8"); 
		res.setContentType("text/html;charset=utf-8"); 
		
		// 파일 이름 가져오기
		String fileName = upload.getOriginalFilename(); 
		byte[] bytes = upload.getBytes(); 
			
		// 업로드 경로 
		String ckUploadPath = "C:\\Users\\PPC028\\Documents\\workspace-spring-tool-suite-4-4.11.0.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\cocobori\\WEB-INF\\views\\images";
			 
		OutputStream out = new FileOutputStream(new File(ckUploadPath + fileName));
			
		//서버로 업로드
		//write메소드의 매개값으로 파일의 총 바이트를 매개값으로 준다.
		//지정된 바이트를 출력 스트랩에 쓴다
		out.write(bytes); 
			
		//클라이언트 결과에 표시
		String callback = req.getParameter("CKEditorFuncNum");
			
		//서버 > 클라이언트로 텍스트 전송(자바스크립트 실행)
		PrintWriter printWriter = res.getWriter();
		String fileUrl = req.getContextPath() + "/images/" + fileName;
		printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
				+ "','이미지가 업로드 되었습니다.')" + "</script>");
		printWriter.flush();
		
		service.register(comunity);
		
		return "redirect:/community/boardList";
	}
	
	/*
	//
	@RequestMapping(value="/boardList", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: getView");
		
		GoodsViewVO view = service.goodsView(gdsNum);
		model.addAttribute("view", view);
		
	}
	*/

	
	//��ǰ �ı� �ۼ�
	@ResponseBody
	@RequestMapping(value="/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply, HttpSession session) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: registReply");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		reply.setUserID(member.getUserID());
		
		service.registReply(reply);
	}
	
	//��ǰ �ı� ���
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: getReplyList");
		
		List<ReplyListVO> reply = service.replyList(gdsNum);
		
		return reply;
	}
	
	//��ǰ �ı� ����
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply, HttpSession session) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: getReplyList(delete)");
		
		int result = 0;
		
		//���� ���� ������
		MemberVO member = (MemberVO)session.getAttribute("member");
		System.out.println("member: " + member);
		//userID Ȯ�� ������� ������
		String userID = service.idCheck(reply.getRepNum());
		System.out.println("userID: " + userID);
		
		//���ڿ� �� equals
		if(member.getUserID().equals(userID)) {
			reply.setUserID(member.getUserID());
			service.deleteReply(reply);
			
			result = 1;
		}
		System.out.println("result: " + result);
		return result;
	}
	
	//��ǰ �ı� ����
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: modifyReply");
		
		int result = 0;
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userID = service.idCheck(reply.getRepNum());	
		
		if(member.getUserID().equals(userID)) {
			reply.setUserID(member.getUserID());
			service.modifyReply(reply);
			result = 1;
		}
		return result;
	}
	
	//��ٱ��� ���
	@ResponseBody
	@RequestMapping(value = "view/addCart", method = RequestMethod.POST)
	public int addCart(CartVO cart, HttpSession session) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: addCart");
		
		int result = 0;
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member != null) {
			cart.setUserID(member.getUserID());
			service.addCart(cart);
			result = 1;
		}
		
		return result;
	}
	
	//��ٱ��� ���
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: getCartList");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userID = member.getUserID();
		
		List<CartListVO> cartList = service.cartList(userID);
		
		model.addAttribute("cartList", cartList);
	}
	
	//��ٱ��� ����
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: deleteCart");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userID = member.getUserID();
		
		int result = 0;
		int cartNum = 0;
		
		if(member != null) {
			cart.setUserID(userID);
			
			for(String i : chArr) {
				cartNum = Integer.parseInt(i);
				cart.setCartNum(cartNum);
				service.deleteCart(cart);
			}
			result = 1;
		}
		return result;
	}
	
	//�ֹ�
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: order");
		
		MemberVO member = (MemberVO)session.getAttribute("member");  
		String userID = member.getUserID();
		
		//��, ��, �� ����
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		 
		for(int i = 1; i <= 6; i ++) {
			//6�ڸ� ���� ����
			subNum += (int)(Math.random() * 10);
		}
		 
		//��¥_��������:: �ֹ� ������ȣ
		String orderID = ymd + "_" + subNum;
		 
		order.setOrderID(orderID);
		order.setUserID(userID);
		  
		service.orderInfo(order);
		 
		orderDetail.setOrderID(orderID);   
		service.orderInfo_Details(orderDetail);
		 
		service.cartAllDelete(userID);
		 
		return "redirect:/store/orderList"; 
	}
	
	//�ֹ� ���
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, OrderVO order, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: getOrderList(orderList)");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userID = member.getUserID();
		
		order.setUserID(userID);
		
		List<OrderVO> orderList = service.orderList(order);
		
		model.addAttribute("orderList", orderList);
	}
	
	//�ֹ� �� ���
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, @RequestParam("n") String orderID, OrderVO order, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("StoreController:: getOrderList(orderView");
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String userID = member.getUserID();
		
		order.setUserID(userID);
		order.setOrderID(orderID);
		
		List<OrderListVO> orderView = service.orderView(order);
		
		model.addAttribute("orderView", orderView);
	}
}
