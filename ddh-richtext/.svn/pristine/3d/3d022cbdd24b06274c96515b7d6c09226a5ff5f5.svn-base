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
public class BaseApiController extends BaseController {

	private static Log log = LogFactory.getLog(BaseApiController.class);

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
	private void init(HttpServletRequest request, HttpServletResponse response, Model model) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 写出移动端需要的json格式数据
	 * <ul>
	 * <li>xhl 2016年7月7日 新建</li>
	 * </ul>
	 * 
	 * @param map
	 * @throws IOException
	 * @throws Exception
	 */
	protected void writeApiJson(TreeMap<String, Object> map, boolean isEncrypt) throws IOException {
		PrintWriter writer = null;
		this.response.setHeader("Content-type", "text/plan;charset=UTF-8");
		try {
			writer = this.response.getWriter();
		} catch (IOException e) {
			log.error("json数据写到页面是错误", e);
		}

		String json = ObjectUtil.objToJsonTrim(map);

		writer.write(json);
		writer.flush();
		writer.close();
	}

	/**
	 * 统一异常处理
	 * <ul>
	 * <li>xhl 2016年5月6日 新建</li>
	 * </ul>
	 * 
	 * @param exception
	 * @throws IOException
	 */
	@ExceptionHandler
	private void exception(Exception exception) throws IOException {
		Map<String, Object> map = new HashMap<>();

		map = ExceptionDeal.exception(exception);
		writeJson(map.get("json"));
	}

}
