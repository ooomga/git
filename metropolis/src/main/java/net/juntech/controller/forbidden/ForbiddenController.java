package net.juntech.controller.forbidden;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.system.IForbiddenService;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "forbidden")
public class ForbiddenController extends BaseController {

	/**
	 * 跳转敏感词页面
	 * <ul>
	 * <li>xhl 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "toForbiddenManage")
	public String toForbiddenManage(Model model) {
		IForbiddenService forbiddenService = ClientProUtil.createInterface(IForbiddenService.class, ProjectName.METROPOLIS_SYSTEM);
		Map<String, Object> map = forbiddenService.selectForbiddenAll(new HashMap<String, Object>());
		model.addAttribute("data", map);
		System.err.println(map);
		return "forbidden.forbiddenManage";
	}

	/**
	 * 跳转添加敏感词页面
	 * <ul>
	 * <li>xhl 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	@RequestMapping(value = "toForbiddenAdd")
	public String toForbiddenAdd() {

		return "forbidden/forbiddenAdd";
	}

	/**
	 * 保存敏感词
	 * <ul>
	 * <li>xhl 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @throws IOException
	 *
	 */
	@RequestMapping(value = "saveForbidden")
	@ResponseBody
	public void saveForbidden(@RequestParam Map<String, Object> param) throws IOException {
		IForbiddenService forbiddenService = ClientProUtil.createInterface(IForbiddenService.class, ProjectName.METROPOLIS_SYSTEM, "forbiddenService");
		int row = forbiddenService.insertForbidden(param);
		Map<String, Object> result = new HashMap<>();
		result.put("row", row);
		writeJson(result);
	}

	// 查看敏感词是否存在
	@RequestMapping(value = "viewForbidden")
	public void viewForbidden(@RequestParam Map<String, Object> param) throws IOException {
		IForbiddenService forbiddenService = ClientProUtil.createInterface(IForbiddenService.class, ProjectName.METROPOLIS_SYSTEM, "forbiddenService");
		Map<String, Object> map = forbiddenService.selectForbidden(param);
		writeJson(map);
	}

}
