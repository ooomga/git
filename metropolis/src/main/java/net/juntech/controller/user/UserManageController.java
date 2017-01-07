package net.juntech.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.controller.base.BaseController;

/**
 * 
 * 会员
 * <ul>
 * <li>xhl 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserManageController extends BaseController {

	/**
	 * 进入会员管理
	 * <ul>
	 * <li>xhl 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "toUserManage")
	public String toUserManage() {
		
		return "user.userManage";
	}

}
