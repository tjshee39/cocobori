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
	
	//������ ȭ��
	@RequestMapping(value = "/AdminMain", method = RequestMethod.GET)
	public void getAdminMain() throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getAdminMain");
	}
	
	//��ǰ ���
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void getRegister(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getRegister");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//��ǰ���
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String postRegister(GoodsVO vo, MultipartFile file) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postRegister");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		//���� ��ǲ�ڽ��� ÷�ε� ������ ���ٸ�
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			
			//gdsImg: �������� ��� + ���ϸ�
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			//gdsThumbImg: ����� ��� + ���ϸ�
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		} else {
			//÷�ε� ������ ������ none.png������ ��� ���
			fileName = File.separator + "images" + File.separator + "none_image.png";
			
			vo.setGdsImg(fileName);
			vo.setGdsThumbImg(fileName);
		}
				
		adminService.register(vo);
		
		return "redirect:/admin/goodsList";
	}
	
	//��ǰ���
	@RequestMapping(value="/goodsList", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getGoodsList");
		
		List<GoodsViewVO> list = adminService.goodslist();
		
		model.addAttribute("list", list);
	}
	
	//��ǰ��ȸ(ī�װ� ����)
	@RequestMapping(value="/goodsView", method = RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getGoodsView");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		
		model.addAttribute("goods", goods);
	}
	
	
	//��ǰ ����
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
	
	//��ǰ ����
	@RequestMapping(value="/goodsModify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postGoodsModify");
		
		//���ο� ������ ��ϵǾ����� Ȯ��
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			//���� ���� ����
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			//���� ÷���� ���� ���
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		} else {  //���ο� ������ ��ϵ��� �ʾҴٸ�
			//���� �̹��� �״�� ���
			vo.setGdsImg(req.getParameter("gdsImg"));
			vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		
		
		adminService.goodsModify(vo);
		
		return "redirect:/admin/goodsList";
	}
	
	//��ǰ ����
	@RequestMapping(value="/goodsDelete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postGoodsDelete");
		
		adminService.goodsDelete(gdsNum);
		
		return "redirect:/admin/goodsList";
	}
	
	//�ֹ� ���
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getOrderList");
		
		List<OrderVO> orderList = adminService.orderList();
		
		model.addAttribute("orderList", orderList);
	}
	
	//�ֹ� �� ���
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(@RequestParam("n") String orderID, OrderVO order, Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getOrderList_orderView");
		
		order.setOrderID(orderID);
		List<OrderListVO> orderView = adminService.orderView(order);
		
		model.addAttribute("orderView", orderView);
	}
	
	//�ֹ� �� ��� - ���� ����, ��ǰ ���� ����
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
	
	//��� ��ǰ �ı� ���
	@RequestMapping(value = "/allReply", method = RequestMethod.GET)
	public void getAllReply(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getAllReply");
		
		List<ReplyListVO> reply = adminService.allReply();
		
		model.addAttribute("reply", reply);
	}
	
	//�ı� ����
	@RequestMapping(value="/allReply", method = RequestMethod.POST)
	public String postAllReply(@RequestParam("repNum") int repNum) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postAllReply");
			
		adminService.deleteReply(repNum);
		
		return "redirect:/admin/allReply";
	}
	
}
