package com.sunny.cocobori;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.GoodsVO;
import com.sunny.domain.GoodsViewVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderVO;
import com.sunny.domain.ReplyListVO;
import com.sunny.domain.ReplyVO;
import com.sunny.service.AdminService;
import com.sunny.utils.UploadFileUtils;

import net.sf.json.JSONArray;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject 
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//관리자 화면
	@RequestMapping(value = "/AdminMain", method = RequestMethod.GET)
	public void getAdminMain() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getAdminMain");
	}
	
	//상품 등록
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void getRegister(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getRegister");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//상품등록
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String postRegister(GoodsVO vo, MultipartFile file) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postRegister");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		//파일 인풋박스에 첨부된 파일이 없다면
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			
			//gdsImg: 원본파일 경로 + 파일명
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			//gdsThumbImg: 썸네일 경로 + 파일명
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		} else {
			//첨부된 파일이 없으면 none.png파일을 대신 출력
			fileName = File.separator + "images" + File.separator + "none_image.png";
			
			vo.setGdsImg(fileName);
			vo.setGdsThumbImg(fileName);
		}
				
		adminService.register(vo);
		
		return "redirect:/admin/goodsList";
	}
	
	//상품목록
	@RequestMapping(value="/goodsList", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getGoodsList");
		
		List<GoodsViewVO> list = adminService.goodslist();
		
		model.addAttribute("list", list);
	}
	
	//상품조회(카테고리 조인)
	@RequestMapping(value="/goodsView", method = RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getGoodsView");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		
		model.addAttribute("goods", goods);
	}
	
	
	//상품 수정
	@RequestMapping(value="/goodsModify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getGoodsModify");
		System.out.println("gdsNum:: " + gdsNum);
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//상품 수정
	@RequestMapping(value="/goodsModify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postGoodsModify");
		
		//새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			//기존 파일 삭제
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			//새로 첨부한 파일 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		} else {  //새로운 파일이 등록되지 않았다면
			//기존 이미지 그대로 사용
			vo.setGdsImg(req.getParameter("gdsImg"));
			vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		
		
		adminService.goodsModify(vo);
		
		return "redirect:/admin/goodsList";
	}
	
	//상품 삭제
	@RequestMapping(value="/goodsDelete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postGoodsDelete");
		
		adminService.goodsDelete(gdsNum);
		
		return "redirect:/admin/goodsList";
	}
	
	//주문 목록
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getOrderList");
		
		List<OrderVO> orderList = adminService.orderList();
		
		model.addAttribute("orderList", orderList);
	}
	
	//주문 상세 목록
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(@RequestParam("n") String orderID, OrderVO order, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getOrderList_orderView");
		
		order.setOrderID(orderID);
		List<OrderListVO> orderView = adminService.orderView(order);
		
		model.addAttribute("orderView", orderView);
	}
	
	//주문 상세 목록 - 상태 변경, 상품 수량 조절
	@RequestMapping(value = "/orderView", method = RequestMethod.POST)
	public String delivery(@RequestParam("delivery") String delivery, OrderVO order) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: delivery");
		
		adminService.delivery(order);
		
		List<OrderListVO> orderView = adminService.orderView(order);
		GoodsVO goods = new GoodsVO();
		
		if(delivery.equals("배송중")) {
			for(OrderListVO i : orderView) {
				goods.setGdsNum(i.getGdsNum());
				goods.setGdsStock(i.getCartStock());
				adminService.changeStock(goods);
			}
		}
		
		
		return "redirect:/admin/orderView?n=" + order.getOrderID();
	}
	
	//모든 상품 후기 출력
	@RequestMapping(value = "/allReply", method = RequestMethod.GET)
	public void getAllReply(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getAllReply");
		
		List<ReplyListVO> reply = adminService.allReply();
		
		model.addAttribute("reply", reply);
	}
	
	//후기 삭제
	@RequestMapping(value="/allReply", method = RequestMethod.POST)
	public String postAllReply(@RequestParam("repNum") int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postAllReply");
			
		adminService.deleteReply(repNum);
		
		return "redirect:/admin/allReply";
	}
	
}
