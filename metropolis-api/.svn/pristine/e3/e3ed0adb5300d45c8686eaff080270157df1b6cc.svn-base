package net.juntech.controller.wages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.wages.IWagesService;
import net.juntech.util.zk.ClientProUtil;
import net.sf.json.JSONObject;

/**
 * <ul>
 * <li>ZX 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
@RequestMapping(value = "mobile/wages")
public class WagesController extends BaseController {
	
	// 获取用户工资及党费详细
	@RequestMapping(value = "getWagesDetail")
	public void getWagesDetail(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("date")) && isNull(param.get("psnCode"))) {
			result.put("msg", "日期和员工号不能为空");
		} else {
			IWagesService wagesService = ClientProUtil.createInterface(IWagesService.class, ProjectName.METROPOLIS_USER);
			String date = param.get("date").toString();
			String psnCode = param.get("psnCode").toString();
			Map<String, Object> wages = wagesService.selectWagesDetail(date, psnCode);
			result.put("data", wages);
		}
		writeApiJson(new TreeMap<>(result), false);
	}
	
	// 获取用户工资及党费概要
	@RequestMapping(value = "getWagesGeneral")
	public void getWagesGeneral(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("date")) && isNull(param.get("psnCode"))) {
			result.put("msg", "日期和员工号不能为空");
		} else {
			IWagesService wagesService = ClientProUtil.createInterface(IWagesService.class, ProjectName.METROPOLIS_USER);
			String date = param.get("date").toString();
			String psnCode = param.get("psnCode").toString();
			Map<String, Object> wages = wagesService.selectWagesGeneral(date, psnCode);
			result.put("data", wages);
		}
		writeApiJson(new TreeMap<>(result), false);
	}
	
	// 获取党支部年度缴费详细
	@RequestMapping(value = "getPartyBranchDetail")
	public void getPartyBranchDetail(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("year")) && isNull(param.get("partyBranchCode"))) {
			result.put("msg", "缴费年度和支部号不能为空");
		} else {
			IWagesService wagesService = ClientProUtil.createInterface(IWagesService.class, ProjectName.METROPOLIS_USER);
			String year = param.get("year").toString();
			String partyBranchCode = param.get("partyBranchCode").toString();
			Map<String, Object> wages = wagesService.selectPartyBranchDetail(year, partyBranchCode);
			result.put("data", wages);
		}
		writeApiJson(new TreeMap<>(result), false);
	}
	
	// 获取公司所有党支部年度缴费概要
	@RequestMapping(value = "getPartyBranchGeneral")
	public void getPartyBranchGeneral(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("year")) && isNull(param.get("companyCode"))) {
			result.put("msg", "日期和公司号不能为空");
		} else {
			IWagesService wagesService = ClientProUtil.createInterface(IWagesService.class, ProjectName.METROPOLIS_USER);
			String year = param.get("year").toString();
			String companyCode = param.get("companyCode").toString();
			Map<String, Object> wages = wagesService.selectPartyBranchGeneral(year, companyCode);
			result.put("data", wages);
		}
		writeApiJson(new TreeMap<>(result), false);
	}
	
	// 获取员工所属党支部信息
	@RequestMapping(value = "getStaffPartyBranch")
	public void getStaffPartyBranch(String json) throws IOException {
		Map<String, Object> param = verify(json, true);
		Map<String, Object> result = new HashMap<>();
		if (isNull(param.get("psnCode"))) {
			result.put("msg", "员工号不能为空");
		} else {
			IWagesService wagesService = ClientProUtil.createInterface(IWagesService.class, ProjectName.METROPOLIS_USER);
			String psnCode = param.get("psnCode").toString();
			Map<String, Object> wages = wagesService.selectStaffPartyBranch(psnCode);
			result.put("data", wages);
		}
		writeApiJson(new TreeMap<>(result), false);
	}
}
