package com.fanyi.scm.interceptor;


import com.fanyi.scm.vo.User;
import com.fanyi.scm.utils.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 系统过滤器
 * @author wangyds
 * @date 2019/4/9
 */
public class SysInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.USER_SESSION);
		if(null == user){
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}
