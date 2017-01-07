package net.juntech.controller.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.system.IOrganizationService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>Dave 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class OrganizationController extends BaseController{

	
	@RequestMapping(value="/organization/toOrganization")
	public String toPermisisonList(){
		return "organization.organizationList";
	}
	
	/**
	 * 获取service实例
	 * <ul>
	 * <li>Dave 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	private IOrganizationService getService(){
		return ClientProUtil.createInterface(IOrganizationService.class, ProjectName.METROPOLIS_SYSTEM, "organizationService");
	}
	
	@RequestMapping(value = "/organization/searchOrganization")
	@ResponseBody
	public void getOrganizationList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IOrganizationService orgService = getService();
		Map<String, Object> data = orgService.getOrganizationList(param);
		System.err.println(ObjectUtil.objToJson(data));
		writeGridJson(data);
	}
	
	@RequestMapping(value="/organization/toAddOrganization")
	public String toAddOrganization(Model model){
		IOrganizationService orgService = getService();
		List<Map<String, Object>> orgList = orgService.getAllOrganizationForSelect(new HashMap<String,Object>());
		model.addAttribute("orgList", orgList);
		return "organization/addOrganization";
	}
	
	@RequestMapping(value = "/organization/saveOrganization")
	@ResponseBody
	public void saveOrganization(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IOrganizationService orgService = getService();
		orgService.saveOrganization(param);
	}
	
	@RequestMapping(value="/organization/deleteOrganization")
	@ResponseBody
	public void deleteOrganization(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IOrganizationService orgService = getService();
		orgService.delOrganization(param);
	}
	
	@RequestMapping(value="/organization/viewOrganization")
	@ResponseBody
	public void viewOrganization(@RequestParam Map<String, Object> param,Model model){
		super.setSearchParam(param, null, null);
		IOrganizationService orgService = getService();
		Map<String, Object> data = orgService.viewOrganization(param);
		model.addAttribute("data", data);
	}

}
