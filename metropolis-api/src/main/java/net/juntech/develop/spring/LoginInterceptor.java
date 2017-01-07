package net.juntech.develop.spring;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.juntech.util.JsonUtil;
import net.juntech.util.ObjectUtil;
import net.juntech.util.RedisUtil;

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

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String json = request.getParameter("json");
		Map<String, Object> map = JsonUtil.jsonToObj(json, Map.class);
		Object uuid = map.get("uuid");

		Map<String, Object> result = new HashMap<>();
		PrintWriter writer = response.getWriter();
		if (uuid == null) {
			result.put("code", "400");
			result.put("emsg", "\u53c2\u6570\u9519\u8bef");
			result.put("msg", "");
			result.put("data", new HashMap<>());
			writer.write(ObjectUtil.objToJson(result));
			return false;
		}
		if (!RedisUtil.exists(uuid.toString())) {
			result.put("code", "400");
			result.put("emsg", "\u7528\u6237\u672a\u767b\u5f55");
			result.put("msg", "");
			result.put("data", new HashMap<>());
			writer.write(ObjectUtil.objToJson(result));
			return false;
		}
		return super.preHandle(request, response, handler);
	}

}
