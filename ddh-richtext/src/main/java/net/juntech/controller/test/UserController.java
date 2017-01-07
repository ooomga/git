package net.juntech.controller.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.controller.base.BaseWebController;
import net.juntech.entity.UserEntity;
import net.juntech.service.test.IUserService;

/**
 * <ul>
 * <li>xhl 2016年10月21日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class UserController extends BaseWebController {

	@Autowired
	private IUserService userService;

	/**
	 * 跳转测试页面
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "toTest.m")
	public String toTest() {

		return "test/user";
	}

	/**
	 * 保存用户
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 *
	 */
	@RequestMapping(value = "saveUser.m")
	public void saveUser(UserEntity userEntity) {
		userService.saveUser(userEntity);
	}

	/**
	 * 查询用户列表
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 *
	 */
	@RequestMapping(value = "listUser.m")
	public void listUser(Map<String, Object> param) {
		userService.selectUserList(param);
	}

	/**
	 * 查询所有用户
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 */
	@RequestMapping(value = "listAllUser.m")
	public void listAllUser(Map<String, Object> param) {
		userService.selectUserAllList(param);
	}

	/**
	 * 查询用户详情
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 *
	 */
	@RequestMapping(value = "viewUser.m")
	public void viewUser(Map<String, Object> param) {
		userService.selectUser(param);
	}

	/**
	 * 删除用户
	 * <ul>
	 * <li>xhl 2016年10月21日 新建</li>
	 * </ul>
	 * 
	 * @param ids
	 */
	@RequestMapping(value = "deleteUser.m")
	public void deleteUser(String ids) {
		userService.deleteUser(ids);
	}

}
