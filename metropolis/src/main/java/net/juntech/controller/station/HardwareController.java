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
import net.juntech.service.station.IHardwareService;
import net.juntech.service.station.ILostService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>GQG 2017年1月4日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class HardwareController extends BaseController{

	@RequestMapping(value = "/station/toHardware")
	public String selectLineList(@RequestParam Map<String,Object> params) {
		return "station.hardwareStation";
	}
	@RequestMapping(value = "/station/getHardware")
	@ResponseBody
	public void getHardware(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IHardwareService hservice = ClientProUtil.createInterface(IHardwareService.class, ProjectNameConstant.METROPOLIS_STATION, "hardwareService");
		Map<String, Object>  resultMap = hservice.selectHardware(param);
		System.err.println(ObjectUtil.objToJson(resultMap));
		writeGridJson(resultMap);
	}

	@RequestMapping(value="/station/toAddHardware")
	public String toAddLine(){
		return "station/addHardware";
	}
//	@RequestMapping(value="/station/toModifyHardware")
//	public String toModifyHardware(@RequestParam Map<String, Object> param,Model model){
//		Map<String, Object>  resultMap = new HashMap<>();
//		model.addAttribute("data", resultMap);
//		return "station/modifyHardware";
//	}
}
