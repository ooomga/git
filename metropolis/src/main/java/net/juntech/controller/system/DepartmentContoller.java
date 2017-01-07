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
import net.juntech.service.system.IDepartmentService;
import net.juntech.service.system.IOrganizationService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>Dave 2016年12月29日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class DepartmentContoller extends BaseController {
	
	@RequestMapping(value="/department/toDepartment")
	public String toPermisisonList(){
		return "department.departmentList";
	}
	
	/**
	 * 获取service实例
	 * <ul>
	 * <li>Dave 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	private IDepartmentService getService(){
		return ClientProUtil.createInterface(IDepartmentService.class, ProjectName.METROPOLIS_SYSTEM, "departmentService");
	}
	
	@RequestMapping(value = "/department/searchDepartment")
	@ResponseBody
	public void getDepartmentList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IDepartmentService depService = getService();
		Map<String, Object> data = depService.getDepartmentList(param);
		System.err.println(ObjectUtil.objToJson(data));
		writeGridJson(data);
	}
	
	@RequestMapping(value="/department/toAddDepartment")
	public String toAddDepartment(Model model){
		IOrganizationService orgService = ClientProUtil.createInterface(IOrganizationService.class, ProjectName.METROPOLIS_SYSTEM, "organizationService");
		List<Map<String, Object>> orgList = orgService.getAllOrganizationForSelect(new HashMap<String,Object>());
		model.addAttribute("orgList", orgList);
		return "department/addDepartment";
	}
	
	@RequestMapping(value = "/department/saveDepartment")
	@ResponseBody
	public void saveDepartment(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IDepartmentService depService = getService();
		depService.saveDepartment(param);
	}
	
	@RequestMapping(value="/department/toModifyDepartment")
	public String toModifyDepartment(Model model,@RequestParam Map<String,Object> params){
		IDepartmentService depService = getService();
		Map<String, Object> departmentInfo = depService.getDepartmentInfo(params);
		model.addAttribute("data", departmentInfo);
		IOrganizationService orgService = ClientProUtil.createInterface(IOrganizationService.class, ProjectName.METROPOLIS_SYSTEM, "organizationService");
		List<Map<String, Object>> orgList = orgService.getAllOrganizationForSelect(new HashMap<String,Object>());
		model.addAttribute("orgList", orgList);
		return "department/addDepartment";
	}
	
	@RequestMapping(value = "/department/updateDepartment")
	@ResponseBody
	public void updateDepartment(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IDepartmentService depService = getService();
		depService.updateDepartment(param);
	}
	
	@RequestMapping(value="/department/deleteDepartment")
	@ResponseBody
	public void deleteDepartment(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IDepartmentService depService = getService();
		depService.delDepartment(param);
	}
	
}
