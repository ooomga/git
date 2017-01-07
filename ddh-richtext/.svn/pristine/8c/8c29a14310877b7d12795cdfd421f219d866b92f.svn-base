package net.juntech.controller.test;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.controller.base.BaseWebController;
import net.juntech.service.test.IUserService;

/**
 * <ul>
 * <li>xhl 2016年11月7日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class SystemController extends BaseWebController {

	@Autowired
	private IUserService userService;

	/**
	 * 获取数据库系统时间
	 * <ul>
	 * <li>xhl 2016年11月7日 新建</li>
	 * </ul>
	 * @throws IOException 
	 *
	 */
	@RequestMapping(value = "DBDate")
	public void DBDate() throws IOException {
		Date date = userService.selectDBDate();
		writeJson(date);
	}

}
