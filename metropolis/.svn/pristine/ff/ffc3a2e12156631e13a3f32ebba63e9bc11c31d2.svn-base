package net.juntech.controller.station;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.util.Hash;

import net.juntech.constant.ProjectName;
import net.juntech.constant.ProjectNameConstant;
import net.juntech.controller.base.BaseController;
import net.juntech.service.station.ILineService;
import net.juntech.service.station.ILostService;
import net.juntech.service.station.IStationService;
import net.juntech.service.system.IPermissionService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class LostController extends BaseController{
	

	@RequestMapping(value = "/station/toLost")
	public String selectLineList(@RequestParam Map<String,Object> params) {
		return "station.lostStation";
	}
	@RequestMapping(value = "/station/getLost")
	@ResponseBody
	public void getLost(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		ILostService lostService = ClientProUtil.createInterface(ILostService.class, ProjectNameConstant.METROPOLIS_STATION, "lostService");
		Map<String, Object>  resultMap = lostService.selectLost(param);
		System.err.println(ObjectUtil.objToJson(resultMap));
		writeGridJson(resultMap);
	}

	@RequestMapping(value="/station/toAddLost")
	public String toAddLine(){
		return "station/addLost";
	}
//	@RequestMapping(value="/station/toModifyLost")
//	public String tomodifyLine(@RequestParam Map<String, Object> param,Model model){
//		Map<String, Object>  resultMap = new HashMap<>();
//		model.addAttribute("data", resultMap);
//		return "station/modifyLost";
//	}
	
	
	
	
	
	
}
