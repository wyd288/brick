package com.fan1111.controller;

import com.fan1111.entity.User;
import com.fan1111.service.user.UserService;
import com.fan1111.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
	@Resource
	private UserService userService;
	
	//控制访问登陆页面
	@RequestMapping(value="/")
	public String login(){
		return "login";
	}




	//访问注册页面
	@RequestMapping("/regist.html")
	public String register(){
		return "regist";
	}
	//修改密码页面
	@RequestMapping(value="/forgetPassword.html")
	public String forgetPassword(){
		return "error";
	}
	
	
	//登陆页面控制，成功进入首页，失败返回登录页
	@RequestMapping(value="/welcome")
	public String doLogin(@RequestParam(value="userCode")String userCode,
			@RequestParam(value="userPassword")String userPassword,
			HttpSession session,
			HttpServletRequest request,
			Model model){
		User user = userService.getUserLogin(userCode, userPassword);
		if(null != user){
			session.setAttribute(Constants.USER_SESSION, user);
			model.addAttribute("activeFrame", "activeMenu");
			return "frame";
		}
		request.setAttribute("error", "用户名或密码错误！");
		return "login";
	}
	
	//控制退出，清空登陆信息，返回登陆页
	@RequestMapping("/exit.html")
	public String loginOut(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "redirect:/";
	}
	
}
