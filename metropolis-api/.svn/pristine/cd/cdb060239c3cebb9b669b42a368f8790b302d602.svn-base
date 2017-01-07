package net.juntech.controller.station;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.station.IStationService;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2017年1月3日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "mobile/station")
public class StationController extends BaseController {

	// 查询线路
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listLine")
	public void listLine(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectName.METROPOLIS_STATION);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> line = stationService.selectStationByLineCode(param);
		for (Map<String, Object> map : (List<Map<String, Object>>) line.get("list")) {
			map.remove("seq");
			map.remove("display");
			map.remove("extraLineCode");
		}
		result.put(MSG, "获取成功");
		result.put("data", line);
		writeApiJson(new TreeMap<>(result), false);
	}

	// 根据站点查询时刻
	@RequestMapping(value = "listTimeByStation")
	public void listTimeByStation(String json) throws IOException {
		Map<String, Object> params = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectName.METROPOLIS_STATION);
		List<Map<String, Object>> dates = stationService.selectTimeByStation(params);
		result.put("data", dates);
		writeApiJson(new TreeMap<>(result), false);
	}
}
