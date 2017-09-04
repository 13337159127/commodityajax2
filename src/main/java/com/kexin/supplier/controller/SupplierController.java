package com.kexin.supplier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kexin.supplier.entity.SupplierEntity;
import com.kexin.supplier.service.SupplierService;

/**
 * controller类 调用service层 实现跳转增 删 改 查页面
 * 
 * @author caokexin
 *
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * 跳转到供货商首页，返回前台页面，由ajax处理
	 * 
	 * @return 返回供货商首页
	 * @throws Exception
	 */
	@RequestMapping("/getSupplierShowJsp")	 
	public ModelAndView getSupplierShowJsp() throws Exception {
		ModelAndView mv = new ModelAndView();		 
		mv.setViewName("supplier/supplierindex");
		return mv;
	}

	/**
	 * 查询供货商信息，返回前台页面
	 * 
	 * @param request
	 * 
	 * @return 返回展示页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findSupplier")
	@ResponseBody
	public List findSupplier() throws Exception {
	   List  list = supplierService.findSupplier();
	   return list; 
	}

	/**
	 * 返回修改供货商页面
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getUpdataSupplierJsp")	 
	public ModelAndView getUpdataSupplierJsp(String supplierID) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplierID", supplierID);
		mv.setViewName("supplier/updatesupplier");
		return mv;
	}
	 
	/**
	 * 根据id查询供货商信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getSupplierbyId")
	@ResponseBody
	public List getSupplierbyId(String supplierID) throws Exception {
		 List list = supplierService.getSupplierbyId(supplierID);
		 return list;
	}


	/**
	 * 修改供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @param request
	 *            设置字符集
	 * @return 返回修改页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateSupplier")
	@ResponseBody
	public Map<String, String> updateSupplier(@RequestParam String supplierID, String supplierName,
			String supplierAddress, String supplierPhone) throws Exception {
		supplierService.updateSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
		Map<String, String> mapRes = new HashMap<String, String>();
		mapRes.put("key1", "可心");
		return mapRes;
		// return new ModelAndView("redirect:/supplier/findSupplier.kexin");
	}

	/**
	 * 
	 * @return 返回添加jsp页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/returnAddSupplierJsp")
	public ModelAndView returnAddSupplierJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("supplier/addsupplier");
		return mv;
	}

	/**
	 * 添加供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @param request
	 *            设置字符集
	 * @return 返回展示页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addSupplier")
	@ResponseBody
	public Map<String, String> addSupplier(@RequestParam String supplierID, String supplierName, String supplierAddress,
			String supplierPhone) throws Exception {
		supplierService.addSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
		Map<String, String> mapRes = new HashMap<String, String>();
		mapRes.put("key1", "可心");
		return mapRes;
		// return new ModelAndView("redirect:/supplier/findSupplier.kexin");
	}

	/**
	 * 
	 * @param request
	 *            接收参数
	 * @return 返回首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/deleteSupplier")
	public ModelAndView deleteSupplier(@RequestParam String supplierID) throws Exception {
		supplierService.deleteSupplier(supplierID);
		return new ModelAndView("redirect:/supplier/getSupplierShowJsp.kexin");
	}
}