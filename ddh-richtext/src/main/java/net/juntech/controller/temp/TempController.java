package net.juntech.controller.temp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.juntech.controller.base.BaseWebController;
import net.juntech.util.StringEscapeEditor;

/**
 * <ul>
 * <li>xhl 2016年9月7日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "temp")
public class TempController extends BaseWebController {

	@InitBinder
	public void XSS(WebDataBinder binder) {

		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		/**
		 * 防止XSS攻击
		 */
		binder.registerCustomEditor(String.class, new StringEscapeEditor(true));
		// binder.registerCustomEditor(SortedMap.class, new CustomMapEditor(SortedMap.class));
	}

	/**
	 * 进入测试页面
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "toTest.htm")
	public String toTest() {
		return "temp/test";
	}

	/**
	 * 保存
	 * <ul>
	 * <li>xhl 2016年11月15日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "save.htm")
	public String save(@RequestParam Map<String, Object> param, Model model) {
		// System.err.println(param.getMap());
		// model.addAttribute("entity", param.getMap());
		model.addAttribute("entity", param);
		return "temp/verify";
	}

	/**
	 * 跳转页面测试
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "toJump.htm")
	public String toJump() {
		return "temp/jump";
	}

	/**
	 * 测试转发
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "toForward.htm")
	public void toForward(Model model) throws ServletException, IOException {
		request.setAttribute("jump", "forward刷新不消失");
		forwardUrl("toTest.htm");
	}

	/**
	 * 测试重定向
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "toRedirect.htm")
	public String toRedirect(Model model, RedirectAttributes attributes) throws ServletException, IOException {
		attributes.addFlashAttribute("jump", "redirect刷新后消失");
		return redirectUrl("toTest.htm");
	}

}
