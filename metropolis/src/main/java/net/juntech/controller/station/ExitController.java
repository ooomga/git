package net.juntech.controller.station;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectNameConstant;
import net.juntech.controller.base.BaseController;
import net.juntech.service.station.IExitService;
import net.juntech.service.station.IStationService;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class ExitController extends BaseController{
	

	@RequestMapping(value = "/station/toExit")
	public String selectExitList(@RequestParam Map<String,Object> params) {
		return "station.exitManage";
	}
	@RequestMapping(value = "/station/getExitList")
	@ResponseBody
	public void getExitList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IExitService exitService = ClientProUtil.createInterface(IExitService.class, ProjectNameConstant.METROPOLIS_STATION, "exitService");
		Map<String, Object>  resultMap = exitService.selectExitByStation(param);
//		System.err.println(ObjectUtil.objToJson(resultMap));
		writeGridJson(resultMap);
	}

	@RequestMapping(value="/station/toAddExit")
	public String toAddExit(){
		return "station/addExit";
	}
	@RequestMapping(value="/station/toAddMark")
	public String toAddMark(){
		return "station/addMark";
	}
	@RequestMapping(value="/station/toModifyExit")
	public String toModifyExit(@RequestParam Map<String, Object> param,Model model){
		IExitService exitService = ClientProUtil.createInterface(IExitService.class, ProjectNameConstant.METROPOLIS_STATION, "exitService");
		Map<String, Object>  resultMap = exitService.selectExitByStation(param);
		model.addAttribute("data", resultMap);
//		IStationService stationService = ClientProUtil.createInterface(IStationService.class, ProjectNameConstant.METROPOLIS_STATION, "stationService");
//		Map<String, Object>  result =stationService.getStationByLine(param);
//		model.addAttribute("dataStation", result);
		return "station/addMark";
	}
	@RequestMapping(value = "/station/saveExit")
	@ResponseBody
	public void saveExit(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IExitService exitService = ClientProUtil.createInterface(IExitService.class, ProjectNameConstant.METROPOLIS_STATION, "exitService");
		Map<String, Object> data = exitService.saveExitByStation(param);
	}
	@RequestMapping(value = "/station/updateExit")
	@ResponseBody
	public void updateExit(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IExitService exitService = ClientProUtil.createInterface(IExitService.class, ProjectNameConstant.METROPOLIS_STATION, "exitService");
		Map<String, Object> data = exitService.updateExit(param);
	}
	
	@RequestMapping(value="/station/deleteExit")
	@ResponseBody
	public void deleteExit(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IExitService exitService = ClientProUtil.createInterface(IExitService.class, ProjectNameConstant.METROPOLIS_STATION, "exitService");
		Map<String, Object> data = exitService.delExitByStation(param);
	}
	
	
}
