package com.kexin.commodity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kexin.classify.service.ClassifyService;
import com.kexin.commodity.service.CommodityService;
import com.kexin.user.service.UserService;

/**
 * controller类，调用业务层方法，返回相应页面
 * 
 * @author caokexin
 *
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
	// 声明成员变量。@Autowired为成员变量赋值
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private ClassifyService classifyService;
	@Autowired
	private UserService userService;

	/**
	 * 跳转到展示商品首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCommodityShowJsp")
	public ModelAndView getCommodityShowJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		// 跳转到商品的首页
		mv.setViewName("show/show");
		return mv;
	}

	/**
	 * 查询商品信息
	 * 
	 * @param request
	 * @return 根据 用户名，分类查询属性，名称查询属性，排序属性 查询商品信息。返回商品信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findCommodity")
	@ResponseBody
	public List findCommodity(String classify, String sort, String designation, HttpSession session) throws Exception {
		// session接收用户名
		String loginname = (String) session.getAttribute("name");
		// 变量名调用方法
		List<Map<String, String>> list = commodityService.findCommodity(loginname, classify, designation, sort);
		return list;
	}

	/**
	 * 返回添加商品的页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addCommodityJsp")
	public ModelAndView addCommodityJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		// 视图名
		mv.setViewName("show/add");
		return mv;
	}

	/**
	 * 查询分类（添加,修改商品使用）
	 * 
	 * @param request
	 * @return 查询商品分类。返回添加商品页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/selectClassify")
	@ResponseBody
	public List selectClassify() throws Exception {
		// 实列化查询商品分类      获取商品分类和商品ID
		List list = classifyService.selectClassify();
		return list;
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @return 添加商品的ID,名称，数量，价格保质期，生产地，分类，用户名。返回查询商品首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addCommodity")
	@ResponseBody
	public Map<String, String> addCommodity(String commodityId, String commodityName, String commodityPrice,
			String commodityMuch, String commodityPeriod, String commodityYiedly, String categoryId,
			HttpSession session) throws Exception {
		String loginName = (String) session.getAttribute("name");
		// 返回用户ID
		String userId = userService.getUserId(loginName);
		// 实列化类 创建对象 添加商品
		commodityService.addCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId, userId);
		// controller间的跳转 需要重定向
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("key1", "可心");
		return resMap;		 
	}

	/**
	 * 返回修改商品的页面
	 * @param commodityId
	 *    商品ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateCommodityJsp")
	public ModelAndView updateCommodityJsp(String commodityId) throws Exception {
		ModelAndView mv = new ModelAndView();
		// 向修改页面传商品ID
		mv.addObject("commodityId", commodityId);
		//跳转到修改页面
		mv.setViewName("show/update");
		return mv;
	}
	
	/**
	 * 根据ID查询商品信息（编辑商品信息使用）
	 * 
	 * @param request
	 * @return 根据ID查询商品信息。返回修改商品信息页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getCommoditybyId")
	@ResponseBody
	public List getCommoditybyId(String commodityId) throws Exception {
		// 根据ID查询商品的信息
		List list1 = commodityService.getCommoditybyId(commodityId);
		ModelAndView mv = new ModelAndView();
	//	mv.addObject("list", list1);
		// 实列化查询分类的的类 获取分类
	//	List list = classifyService.selectClassify();
		// 封装要显示到视图的数据
	//	mv.addObject("category", list);
		// 视图名
	//	mv.setViewName("show/update");
		return list1;
	}
	
	 	
	/**
	 * 修改商品信息
	 * 
	 * @param request
	 * @return 修改商品的ID,名称，数量，价格保质期，生产地，分类。返回查询商品首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateCommodity")
	@ResponseBody
	public Map<String, String> updateCommodity(String commodityId, String commodityName, String commodityPrice,
			String commodityMuch, String commodityPeriod, String commodityYiedly, String categoryId) throws Exception {
		commodityService.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId);
		Map<String, String> mapres = new HashMap<String, String>();
		mapres.put("key2", "心");
		return mapres;	 
	}

	/**
	 * 删除商品信息
	 * 
	 * @param request
	 * @return 根据商品ID删除商品的信息。返回查询商品信息首页
	 * @throws Exception
	 *             抛出
	 */
	@RequestMapping("/deleteCommodity")
	public ModelAndView deleteCommodity(String commodityId) throws Exception {
		commodityService.deleteCommodity(commodityId);
		return new ModelAndView("redirect:/commodity/getCommodityShowJsp.kexin");
	}

	/**
	 * 根据用户名 查询商品总数
	 * 
	 * @param request
	 * @return 根据用户名 ，查询商品总数。返回商品总数页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/commoditySum")
	public ModelAndView commoditySum(HttpSession session) throws Exception {
		String username = (String) session.getAttribute("name");
		List list = commodityService.commoditySum(username);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("show/sum");
		return mv;
	}

	/**
	 * 跳转到展示每天录入商品总数的页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDaySumCommodityJsp")
	public ModelAndView getDaySumCommodityJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show/daysum");
		return mv;
	}

	/**
	 * 查询每天录入商品总数
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/daySumCommodity")
	@ResponseBody
	public List daySumCommodity() throws Exception {
		List list = commodityService.daySumCommodity();
		return list;
	}

	/**
	 * 返回分类总数页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/classifySumCommodityJsp")
	public ModelAndView classifySumCommodityJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show/classifysum");
		return mv;
	}

	/**
	 * 查询每个分类商品总数
	 * 
	 * @param request
	 * @return 查询每个分类商品总数，返回查询分类商品总数页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/classifySumCommodity")
	@ResponseBody
	public List classifySumCommodity() throws Exception {
		List list = commodityService.classifySumCommodity();
		return list;
	}
}
