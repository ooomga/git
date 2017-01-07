package net.juntech.controller.station;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectNameConstant;
import net.juntech.controller.base.BaseController;
import net.juntech.service.station.ILineService;
import net.juntech.service.station.IStationService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class StationManageController extends BaseController {

	// 跳转车站信息管理
	@RequestMapping(value = "/station/toStationManage")
	public String toStationManage() {
		return "station.stationManage";
	}

	// 查询车站信息列表
	@RequestMapping(value = "/station/listStation")
	public void listStation(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectNameConstant.METROPOLIS_STATION, "stationService");
		Map<String, Object> result = stationService.getStationByLine(param);
		System.err.println(ObjectUtil.objToJson(result));
		writeGridJson(result);
	}
	@RequestMapping(value="/station/toAddStation")
	public String toAddStation(@RequestParam Map<String, Object> param,Model model){
		ILineService lineService = ClientProUtil.createInterface(ILineService.class, ProjectNameConstant.METROPOLIS_STATION, "lineService");
		Map<String, Object>  resultMap = lineService.getLineList(param);
		model.addAttribute("data", resultMap);
		return "station/addStation";
	}
	@RequestMapping(value="/station/toModifyStation")
	public String toModifyStation(@RequestParam Map<String, Object> param,Model model){
		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectNameConstant.METROPOLIS_STATION, "stationService");
		Map<String, Object>  resultMap = stationService.selectStationByName(param);
		model.addAttribute("dataStation", resultMap);
//		ILineService lineService = ClientProUtil.createInterface(ILineService.class, ProjectNameConstant.METROPOLIS_STATION, "lineService");
//		Map<String, Object>  result = lineService.getLineList(param);
//		model.addAttribute("dataLine", result);
		return "station/modifyStation";
	}
	@RequestMapping(value = "/station/saveStation")
	@ResponseBody
	public void saveStation(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectNameConstant.METROPOLIS_STATION, "stationService");
		Map<String, Object> data = stationService.saveStationByLine(param);
	}
	@RequestMapping(value="/station/deleteStation")
	@ResponseBody
	public void deleteStation(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectNameConstant.METROPOLIS_STATION, "stationService");
		Map<String, Object> data = stationService.delStationByLine(param);
	}
	// 跳转车站出口信息管理
	@RequestMapping(value = "toExitManage")
	public String toExitManage() {

		return "station.exitManage";
	}

}
