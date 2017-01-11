package net.juntech.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.user.IScoreService;
import net.juntech.service.user.IUserService;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2017年1月2日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "mobile/socre")
public class UserScoreController extends BaseController {

	@RequestMapping(value = "userCheckIn")
	public void userCheckIn(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		Map<String, Object> reult = new HashMap<>();
		IScoreService scoreService = ClientProUtil.createInterface(IScoreService.class, ProjectName.METROPOLIS_USER);
		List<Map<String, Object>> list = scoreService.selectScoreForCheckIn(params);
		if (list.size() != 0) {
			reult.put(EMSG, "已经签到，不能重复签到");
		} else {
			int row = scoreService.insertScore(params);
			if (row != 0) {
				IUserService userService = ClientProUtil.createInterface(IUserService.class, ProjectName.METROPOLIS_USER);
				Map<String, Object> map = userService.selectScore(params);
				reult.put(MSG, "签到成功");
				reult.put("data", map);
			} else {
				reult.put(EMSG, "签到失败");
			}
		}
		writeApiJson(new TreeMap<>(reult), false);
	}

	// 添加积分
	@RequestMapping(value = "saveSocre")
	public void saveSocre(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		Map<String, Object> result = new HashMap<>();

		IScoreService scoreService = ClientProUtil.createInterface(IScoreService.class, ProjectName.METROPOLIS_USER);
		int row = scoreService.insertScore(params);
		if (row != 0) {
			result.put(MSG, "添加成功");
		}
		writeApiJson(new TreeMap<>(result), false);
	}

	// 积分列表
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listSocreAll")
	public void listSocreAll(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		IScoreService scoreService = ClientProUtil.createInterface(IScoreService.class, ProjectName.METROPOLIS_USER);
		Map<String, Object> result = scoreService.selectScoreList(params);
		for (Map<String, Object> map : (List<Map<String, Object>>) result.get("list")) {
			map.remove("seq");
			map.remove("id");
			map.remove("userId");
		}
		result.put(MSG, "获取成功");
		writeApiJson(new TreeMap<>(result), false);
	}

}
