package com.kexin.classify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kexin.classify.service.ClassifyService;

@Controller
@RequestMapping("/classify")
public class ClassifyController {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private ClassifyService classifyService;
	
	/**
	 * 返回分类信息首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFindClassifyJsp")	 
	public ModelAndView  getFindClassifyJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("classify/index");
		return mv;		 
	}

	/**
	 * 查询分类信息
	 * 
	 * @param request
	 * @return 返回商品信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findClassify")
	@ResponseBody
	public List findClassify() throws Exception {
		List list = classifyService.findClassify();
		return list;
	}
	
	 
	/**
	 * 返回修改分类信息页面
	 * 
	 * @param request
	 * @return 返回修改分类页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getUpdateClassifyJsp")
	public ModelAndView getUpdateClassifyJsp(@RequestParam(value = "categoryId") String categoryid) throws Exception {		 
		ModelAndView mv = new ModelAndView();
		mv.addObject("categoryid", categoryid);
		mv.setViewName("classify/update");
		return mv;
	}

	/**
	 * 根据ID查询分类信息 ，修改分类信息
	 * 
	 * @param categoryid
	 *            分类信息ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getClassifyById")
	@ResponseBody
	public List getClassifyById(String categoryid) throws Exception {
		List list = classifyService.getClassifybyId(categoryid);
		return list;
	}

	/**
	 * 修改商品分类
	 * 
	 * @param request
	 * @return 返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateClassify")
	@ResponseBody
	public Map<String, String> updateClassify(String categoryId, String category) throws Exception {
		classifyService.updateClassify(category, categoryId);
		Map<String, String> mapRes = new HashMap<String, String>();
		mapRes.put("key1", "可心");
		return mapRes;
		// return new ModelAndView("redirect:/classify/findClassify.kexin");
	}

	/**
	 * 添加商品分类
	 * 
	 * @param request
	 * @return 返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addClassify")
	@ResponseBody
	public Map<String, String> addClassify(String category, String categoryId) throws Exception {
		classifyService.addClassify(category, categoryId);
		Map<String, String> mapRes = new HashMap<String, String>();
		mapRes.put("key1", "可心");
		return mapRes;
	//    return new ModelAndView("redirect:/classify/findClassify.kexin");
	}

	/**
	 * 删除商品分类
	 * 
	 * @param request
	 * @return 返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/deleteClassify")
	public ModelAndView deleteClassify(String categoryId) throws Exception {
		classifyService.deleteClassify(categoryId);
		return new ModelAndView("redirect:/classify/getFindClassifyJsp.kexin");
	}

	/**
	 * 返回添加分类页面
	 * 
	 * @return 返回添加分类页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/returnAddClassifyJsp")
	public ModelAndView returnAddClassifyJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("classify/add");
		return mv;
	}
}
