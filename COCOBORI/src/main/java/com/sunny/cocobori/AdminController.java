package com.sunny.cocobori;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;

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
		
		if(file != null) {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		adminService.register(vo);
		
		return "redirect:/admin/AdminMain";
	}
	
	//��ǰ���
	@RequestMapping(value="/goodsList", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: getGoodsList");
		
		List<GoodsVO> list = adminService.goodslist();
		
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
	public String postGoodsModify(GoodsVO vo) throws Exception {
		System.out.println("========================================");
		System.out.println("AdminController:: postGoodsModify");
		
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
}
