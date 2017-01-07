package net.juntech.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.user.IUserService;
import net.juntech.util.HttpInvoker;
import net.juntech.util.ObjectUtil;
import net.juntech.util.RedisUtil;
import net.juntech.util.UuidUtil;
import net.juntech.util.zk.ClientProUtil;

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
@RequestMapping(value = "mobile/user")
public class UserController extends BaseController {

	// 登陆
	@RequestMapping(value = "login")
	public void login(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("account")) || isNull(param.get("password"))) {
			result.put(EMSG, "用户名密码不能为空");
		} else {
			IUserService userService = ClientProUtil.createInterface(IUserService.class, ProjectName.METROPOLIS_USER);
			Map<String, Object> user = userService.selectUserByAccount(param);
			if (isNull(user)) {
				result.put(EMSG, "用户不存在");
			} else {
				if (user.get("account").toString().equals(param.get("account")) && user.get("password").toString().equals(param.get("password"))) {
					user.remove("password");
					user.put("headImg_full", fullPath + user.get("headImg"));
					String uuid = UuidUtil.generateUuid();
					RedisUtil.set(uuid, ObjectUtil.objToJson(user));
					user.put("uuid", uuid);
					result.put("data", user);
					result.put(MSG, "登陆成功");
				} else {
					result.put(EMSG, "用户名或密码错误");
				}
			}
		}

		writeApiJson(new TreeMap<>(result), false);
	}

	// 快速登陆
	@SuppressWarnings("serial")
	@RequestMapping(value = "mobileLogin")
	public void mobileLogin(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("mobile")) || isNull(param.get("code"))) {
			result.put(EMSG, "手机号码或者验证码不能为空");
		} else {
			String mobile = param.get("mobile").toString();
			String code = param.get("code").toString();
			if (code.equals(RedisUtil.get(mobile))) {
				IUserService userService = ClientProUtil.createInterface(IUserService.class, ProjectName.METROPOLIS_USER);
				param.put("account", mobile);
				Map<String, Object> user = userService.selectUserByAccount(param);
				if (isNull(user)) {
					result.put("data", new HashMap<String, Object>() {
						{
							put("isFrist", "1"); // 1 第一次返回
						}
					});
					result.put(MSG, "验证成功");
				} else {
					user.remove("password");
					user.put("isFrist", "0");
					user.put("headImg_full", fullPath + user.get("headImg"));
					String uuid = UuidUtil.generateUuid();
					RedisUtil.set(uuid, ObjectUtil.objToJson(user));
					user.put("uuid", uuid);
					result.put("data", user);
					result.put(MSG, "登陆成功");
				}
				RedisUtil.del(mobile);
			} else {
				result.put(EMSG, "验证码错误");
			}
		}

		writeApiJson(new TreeMap<>(result), false);
	}

	// 注册
	@RequestMapping(value = "regist")
	public void regist(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("account")) || isNull(param.get("password"))) {
			result.put(EMSG, "用户名密码不能为空");
		} else {
			IUserService userService = ClientProUtil.createInterface(IUserService.class, ProjectName.METROPOLIS_USER);
			Map<String, Object> user = userService.selectUserByAccount(param);
			if (!isNull(user)) {
				result.put(EMSG, "用户已存在");
			} else {
				int row = userService.insertUser(param);
				if (row == 0) {
					result.put(EMSG, "注册失败");
				} else {
					result.put(MSG, "注册成功");
				}
			}
		}
		writeApiJson(new TreeMap<>(result), false);
	}

	// 忘记密码/修改密码
	@RequestMapping(value = "updPassword")
	public void updPassword(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("account")) || isNull(param.get("password"))) {
			result.put(EMSG, "用户名密码不能为空");
		} else {
			IUserService userService = ClientProUtil.createInterface(IUserService.class, ProjectName.METROPOLIS_USER);
			Map<String, Object> user = userService.selectUserByAccount(param);
			if (isNull(user)) {
				result.put(EMSG, "用户不存在");
			} else {
				int row = userService.updateUser(param);
				if (row == 0) {
					result.put(EMSG, "密码修改失败");
				} else {
					result.put(MSG, "密码修改成功");
				}
			}
		}
		writeApiJson(new TreeMap<>(result), false);
	}

	public static void main(String[] args) throws Exception {

		Map<String, Object> map = new HashMap<>();
		map.put("account", "18584506987");
		map.put("password", "111111");
		System.err.println(ObjectUtil.objToJson(map));
		Map<String, Object> params = new HashMap<>();
		params.put("json", ObjectUtil.objToJson(map));

		HttpInvoker invoker = HttpInvoker.newInstance();
		String url = "http://120.92.141.251:7081/metropolis-api/mobile/user/login";
		String invoke = invoker.invoke(url, params, true);
		System.err.println(invoke);
	}

}
