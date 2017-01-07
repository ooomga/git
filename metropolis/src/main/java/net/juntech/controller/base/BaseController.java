package net.juntech.controller.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.juntech.constant.AppParamConstant;
import net.juntech.util.ImageUtil;
import net.juntech.util.ObjectUtil;
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
	private void init(Model model, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		this.base = request.getContextPath();
		this.fullPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		this.abstractPath = request.getSession().getServletContext().getRealPath("/");
		if (null != request.getParameter("channel")) {
			model.addAttribute("channel", request.getParameter("channel"));
		}
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
	 * url转发
	 * 
	 * <ul>
	 * <li>xhl 2016年5月9日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 *            转发的地址
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void forwardUrl(String url) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(this.request, this.response);
	}

	/**
	 * url重定向
	 * 
	 * <ul>
	 * <li>xhl 2016年5月9日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 *            转发的地址
	 * @throws ServletException
	 * @throws IOException
	 */
	protected String redirectUrl(String url) throws ServletException, IOException {
		return "redirect:" + url;
	}

	/**
	 * 转换grid需要的json格式的数据
	 * <ul>
	 * <li>xhl 2016年5月18日 新建</li>
	 * </ul>
	 * 
	 * @param jsonObj
	 * @throws IOException
	 */
	protected void writeGridJson(Map<String, Object> map) throws IOException {
		PrintWriter writer = null;
		this.response.setHeader("Content-type", "text/plan;charset=UTF-8");
		try {
			writer = this.response.getWriter();
		} catch (IOException e) {
			log.error("json数据写到页面是错误", e);
		}

		Map<String, Object> grid = new HashMap<>();
		grid.put("rows", map.get("list"));
		grid.put("page", map.get("pageIndex"));
		grid.put("total", map.get("totalPage"));
		grid.put("records", map.get("totalRecords"));

		String json = ObjectUtil.objToJson(grid);
		writer.write(json);
		writer.flush();
		writer.close();
	}

	/**
	 * 封装分页信息用于jqgrid
	 * <ul>
	 * <li>xhl 2016年5月18日 新建</li>
	 * </ul>
	 * 
	 * @param dataMap
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	private int[] getParamPage(Map<String, Object> dataMap, Integer pageIndex, Integer pageSize) {
		int[] pages = new int[2];
		if (dataMap != null) {
			Object page = dataMap.get("page");
			Object rows = dataMap.get("rows");

			if (page != null && rows != null) {
				pages[0] = Integer.parseInt(page.toString());
				pages[1] = Integer.parseInt(rows.toString());
			}
		}
		if (pageIndex != null) {
			pages[0] = pageIndex;
		}
		if (pageSize != null) {
			pages[1] = pageSize;
		}
		if (pages[0] == 0 && pages[1] == 0) {
			return null;
		} else {
			return pages;
		}
	}

	/**
	 * 封装查询参数 用于jqgrid
	 * <ul>
	 * <li>xhl 2016年5月18日 新建</li>
	 * </ul>
	 * 
	 * @param dataMap
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	protected Map<String, Object> setSearchParam(Map<String, Object> dataMap, Integer pageIndex, Integer pageSize) {
		int[] page = getParamPage(dataMap, pageIndex, pageSize);

		if (page != null) {
			dataMap.put("pageIndex", page[0]);
			dataMap.put("pageSize", page[1]);
		}

		if (null != dataMap.get("sidx") && !"".equals(dataMap.get("sidx").toString().trim())) {
			dataMap.put("orderBy", dataMap.get("sidx").toString().trim().replaceAll(" ", "\n") + " " + dataMap.get("sord").toString().trim().replaceAll(" ", "\n"));
		}

		/* 清除与jqgrid相关参数 */
		dataMap.remove("page");
		dataMap.remove("rows");
		dataMap.remove("sidx");
		dataMap.remove("sord");
		dataMap.remove("_search");
		dataMap.remove("nd");

		return dataMap;
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
	// @ExceptionHandler
	private Object exception(Exception exception) throws IOException {
		Map<String, Object> map = new HashMap<>();

		boolean writeJson = false;

		/**
		 * 判断是否是ajax请求，如果是返回json格式
		 */
		String ajax = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(ajax)) {
			writeJson = true;
		}

		map = ExceptionDeal.exception(exception);
		if (writeJson) {
			writeJson(map.get("json"));
		} else {
			return map.get("url");
		}
		return "common/error/500";
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
		if (map.containsKey(AppParamConstant.ERRORMSG)) {
			map.put(AppParamConstant.CODE, AppParamConstant.ERROR);
			map.put(AppParamConstant.DATA, new TreeMap<String, Object>());
		} else {
			map.put(AppParamConstant.CODE, AppParamConstant.SUCCESS);
			map.put(AppParamConstant.ERRORMSG, "\u8BF7\u6C42\u6210\u529F"); // 请求成功
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

	// 重定向
	protected String redirect(String url) {
		return "redirect:" + url;
	}

}
