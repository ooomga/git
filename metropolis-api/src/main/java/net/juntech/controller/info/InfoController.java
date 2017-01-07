package net.juntech.controller.info;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.richtext.IRichTextService;
import net.juntech.util.DateUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "mobile/info")
public class InfoController extends BaseController {

	// 查询资讯类型列表
	@RequestMapping(value = "listInfoTypeAll")
	public void listInfoTypeAll(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		IRichTextService richTextService = ClientProUtil.createInterface(IRichTextService.class, ProjectName.METROPOLIS_RICHTEXT);
		Map<String, Object> result = new HashMap<>();
		result.put("data", richTextService.getRichTextTypes(param));
		result.put(MSG, "获取成功");
		writeApiJson(new TreeMap<>(result), false);
	}

	// 查询资讯列表
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listInfo")
	public void listInfo(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		IRichTextService richTextService = ClientProUtil.createInterface(IRichTextService.class, ProjectName.METROPOLIS_RICHTEXT);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> maps = richTextService.getRichTextList(param);
		for (Map<String, Object> map : (List<Map<String, Object>>) maps.get("list")) {
			map.put("image_full", fullPath + map.get("image"));
			map.put("grapType", "1");
			map.put("url", fullWebPath + "/richtext/viewRichText?id=" + map.get("id"));
			map.remove("seq");
			map.remove("author");
			map.remove("content");
			map.remove("content");
			map.remove("publish");
			map.remove("id");
			map.put("createTime", DateUtil.dateToStr(map.get("createTime"), "yyyy-MM-dd"));
		}
		result.put("data", maps);
		result.put(MSG, "获取成功");
		writeApiJson(new TreeMap<>(result), false);
	}

}
