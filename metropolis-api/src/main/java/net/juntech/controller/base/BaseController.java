package net.juntech.controller.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.juntech.constant.AppParamConstant;
import net.juntech.util.Config;
import net.juntech.util.ImageUtil;
import net.juntech.util.JsonUtil;
import net.juntech.util.ObjectUtil;
import net.juntech.util.RedisUtil;
import net.juntech.util.StringUtil;
import net.juntech.util.verify.IntegrityVerify;

/**
 * <ul>
 * <li>xn001 2016年5月5日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
/**
 * @author xhl
 *
 */
@Controller
public class BaseController {

	private static Log log = LogFactory.getLog(BaseController.class);

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String base; // 相对路径
	protected String abstractPath; // 绝对路径本机地址
	protected String fullPath; // 绝对路径网络地址
	protected String fullWebPath = Config.getString("fullWebPath"); // web绝对路径网络地址
	protected Map<String, Object> redisUser; // 用户信息
	protected static String EMSG = AppParamConstant.ERRORMSG;
	protected static String MSG = AppParamConstant.MSG;

	/**
	 * 初始化路径
	 * <ul>
	 * <li>xhl 2016年5月5日 新建</li>
	 * </ul>
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@ModelAttribute
	private void init(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.base = request.getContextPath();
		this.fullPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		this.abstractPath = request.getSession().getServletContext().getRealPath("/");
		String uuid = request.getParameter("uuid");
		if (!isNull(uuid)) {
			redisUser = JsonUtil.jsonToObj(RedisUtil.get("uuid"), Map.class);
		}
		if (null != request.getParameter("channel")) {
			model.addAttribute("channel", request.getParameter("channel"));
		}
		model.addAttribute("base", base);
		model.addAttribute("fullPath", fullPath);
	}

	protected Map<String, Object> getUser() {

		return null;
	}

	/**
	 * 统一异常处理
	 * <ul>
	 * <li>xhl 2016年5月6日 新建</li>
	 * </ul>
	 * 
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler
	private void exception(Exception exception) throws IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("emsg", exception.getMessage());
//		map.put("emsg", "服务器错误");
		writeApiJson(new TreeMap<>(map), false);
	}

	/**
	 * 转换需要获取json格式的数据
	 * <ul>
	 * <li>xhl 2016年5月6日 新建</li>
	 * </ul>
	 * 
	 * @param jsonObj
	 *            需要以json格式写出的对象
	 * @throws IOException
	 */
	protected void writeJson(Object jsonObj) throws IOException {
		PrintWriter writer = null;
		this.response.setHeader("Content-type", "text/plan;charset=UTF-8");
		try {
			writer = this.response.getWriter();
		} catch (IOException e) {
			log.error("json数据写到页面是错误", e);
		}

		String json = ObjectUtil.objToJson(jsonObj);

		writer.write(json);
		writer.flush();
		writer.close();
	}

	/**
	 * 写出字符串到页面
	 * <ul>
	 * <li>xhl 2016年6月23日 新建</li>
	 * </ul>
	 * 
	 * @param str
	 * @throws IOException
	 */
	protected void write(Object str) throws IOException {
		PrintWriter writer = null;
		this.response.setHeader("Content-type", "text/plan;charset=UTF-8");
		try {
			writer = this.response.getWriter();
		} catch (IOException e) {
			log.error("json数据写到页面是错误", e);
		}

		writer.write(str.toString());
		writer.flush();
		writer.close();
	}

	/**
	 * 写出移动端需要的json格式数据
	 * <ul>
	 * <li>xhl 2016年7月7日 新建</li>
	 * </ul>
	 * 
	 * @param map
	 *            需要返回的数据TreeMap 用于做加密比较
	 * @param isEncrypt
	 *            是否加密
	 * @throws IOException
	 * @throws Exception
	 */
	protected void writeApiJson(TreeMap<String, Object> map, boolean isEncrypt) throws IOException {

		if (map.containsKey(EMSG)) { // 如果包含错误信息
			map.put(AppParamConstant.CODE, AppParamConstant.ERROR);
			map.put(AppParamConstant.DATA, new TreeMap<String, Object>());
			map.put(MSG, "");
		} else {
			map.put(AppParamConstant.CODE, AppParamConstant.SUCCESS);
			map.put(EMSG, "");
			if (!map.containsKey(AppParamConstant.DATA)) {
				map.put(AppParamConstant.DATA, new TreeMap<>());
			}
			if (!map.containsKey(MSG)) {
				map.put(MSG, "\u8BF7\u6C42\u6210\u529F"); // 请求成功
			}
		}

		PrintWriter writer = null;
		this.response.setHeader("Content-type", "text/plan;charset=UTF-8");
		try {
			writer = this.response.getWriter();
		} catch (IOException e) {
			log.error("json数据写到页面是错误", e);
		}

		if (isEncrypt) {
			map = IntegrityVerify.encrypt(map);
		}
		String json = ObjectUtil.objToJsonTrim(map);
		System.err.println(json);
		writer.write(json);
		writer.flush();
		writer.close();
	}

	/**
	 * TODO 无法使用(待完善) 设置图片的完整路径，支持返回完整路径对象
	 * <ul>
	 * <li>xhl 2016年5月6日 新建</li>
	 * </ul>
	 * 
	 * @param obj
	 *            需要设置完整路径的对象(ps:user)
	 * @param key
	 *            需要设置的对象对应key(ps:userHeadImg)
	 */
	@Deprecated
	protected <T> T setImgFullUrl(T t, String... key) {
		ImageUtil.setImgFullPatn(t, key);
		return t;
	}

	/**
	 * 
	 * 获取请求手机、浏览器版本、操作系统等
	 * <ul>
	 * <li>xhl 2016年5月13日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	protected String getRequestType() {
		String header = request.getHeader("User-Agent");
		return header;
	}

	// json转换和解密
	@SuppressWarnings("unchecked")
	protected Map<String, Object> verify(String json, boolean isEncrypt) throws IOException {
		Map<String, Object> map = new HashMap<>();
		log.info(json);
		if (!isNull(json)) {
			map = JsonUtil.jsonToObj(json, Map.class);
			if (map.containsKey("uuid")) {
				Map<String, Object> user = RedisUtil.getMap(map.get("uuid"));
				map.put("userId", user.get("id"));
			}
		}
		return map;
	}

	// 是否为空
	@SuppressWarnings("unchecked")
	protected boolean isNull(Object object) {
		if (object instanceof Map) {
			Map<String, Object> map = (HashMap<String, Object>) object;
			return map.isEmpty();
		}
		return StringUtil.isNull(object);
	}

	// 重定向
	protected String redirect(String url) {
		return "redirect:" + url;
	}

}
