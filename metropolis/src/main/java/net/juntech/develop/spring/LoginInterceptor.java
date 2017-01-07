package net.juntech.develop.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登陆拦截器，用户未登录跳转到登陆界面
 * <ul>
 * <li>{@link #LoginInterceptor()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月12日
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/system/toSystemLogin");
			return false;
		}
		Object loginUser = session.getAttribute("user");
		if (null == loginUser) {
			response.sendRedirect(request.getContextPath() + "/system/toSystemLogin");
			return false;
		}

		return super.preHandle(request, response, handler);
	}

}
