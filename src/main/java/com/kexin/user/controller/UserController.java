package com.kexin.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kexin.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// 声明变量 为变量赋值
	@Autowired
	private UserService userService;

	/**
	 * 查询用户信息（用户登录）
	 * 
	 * @param request
	 * @return 如果查询的值与数据库匹配，则list.size()>0，登录成功，返回成功页面，否则登录失败，返回首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(String username, String password, HttpSession session) throws Exception {
		List<Map> list = userService.findUserName(username, password);
		ModelAndView mv = new ModelAndView();
		// 返回list的值，在servlet里面接收list的值。如果查询的值与数据库匹配，则list.size()>0，登录成功，否则登录失败
		if (list.size() > 0) {
			// session对象传用户名
			session.setAttribute("name", username);
			mv.setViewName("show/success");
			return mv;
		} else {
			mv.setViewName("show/register");
			return mv;
		}
	}

	/**
	 * 添加用户信息
	 * 
	 * @param request
	 * @return 返回用户信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addUserName")
	@ResponseBody
	public Map<String, String> addUserName(String userId, String loginName, String passWord) throws Exception {
		userService.addUserName(userId, loginName, passWord);
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("key2", "可心");
		return resMap;
		// return new ModelAndView("redirect:/user/findUser.kexin");
	}
	
	/**
	 * 根据ID查询用户的信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getUserById")
	@ResponseBody
	public List getUserById(String userId) throws Exception {
		List<Map> list = userService.getUserbyId(userId);
		return list;
	}

	/**
	 * 向前台传递用户ID的值,返回修改用户界面
	 * 
	 * @param request
	 * @return 返回修改用户信息页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getUpdateUserJsp")
	public ModelAndView getUpdateUserJsp(String userId) throws Exception {	  
		ModelAndView mv = new ModelAndView();
		mv.addObject("userId", userId);
		mv.setViewName("username/updateuser");
		return mv;
	}

	 

	/**
	 * 修改用户信息
	 * 
	 * @param request
	 * @return 返回用户信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateUserName")
	@ResponseBody
	public Map<String, String> updateUserName(String userId, String loginName, String passWord) throws Exception {
		userService.updateUserName(userId, loginName, passWord);
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("key3", "可心");
		return resMap;		 
	}

	/**
	 * 返回用户列表首页
	 * 
	 * @param request
	 * @return 返回用户信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getFindUserJsp")
	public ModelAndView getFindUserJsp() throws Exception {	 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("username/userindex");
		return mv;
	}
    
	/**
	 * 查询用户名信息，返回查询用户的信息到前台页面，用ajax处理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findUser")
	@ResponseBody
	public List findUser() throws Exception {
		List list = userService.findUser();
		return list;
	}
	/**
	 * 根据ID删除用户
	 * 
	 * @param request
	 * @return 返回用户信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/deleteUserName")
	public ModelAndView deleteUserName(String userId) throws Exception {
		userService.DeleteUserName(userId);
		return new ModelAndView("redirect:/user/getFindUserJsp.kexin");
	}

	/**
	 * 用户新增页面方法
	 * 
	 * @return 返回新增用户信息页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("returnAddUserJsp")
	public ModelAndView returnAddUserJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("username/add");
		return mv;
	}
}
