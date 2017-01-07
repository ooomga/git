package net.juntech.controller.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.juntech.util.ImageUtil;
import net.juntech.util.ObjectUtil;

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
	protected HttpSession session;
	protected String base; // 相对路径
	protected String abstractPath; // 绝对路径本机地址
	protected String fullPath; // 绝对路径网络地址

	/**
	 * 初始化路径
	 * <ul>
	 * <li>xhl 2016年5月5日 新建</li>
	 * </ul>
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@ModelAttribute
	private void init(Model model) {
		this.base = request.getContextPath();
		this.fullPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		this.abstractPath = request.getSession().getServletContext().getRealPath("/");
		model.addAttribute("base", base);
		model.addAttribute("fullPath", fullPath);
	}

	/**
	 * 获取request请求
	 * <ul>
	 * <li>xhl 2016年5月5日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return this.request;
	}

	/**
	 * 获取response响应
	 * <ul>
	 * <li>xhl 2016年5月5日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	protected HttpServletResponse getResponse() {
		return this.response;
	}

	/**
	 * 获取session会话
	 * <ul>
	 * <li>xhl 2016年5月5日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	protected HttpSession getSession() {
		return this.session;
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

}
