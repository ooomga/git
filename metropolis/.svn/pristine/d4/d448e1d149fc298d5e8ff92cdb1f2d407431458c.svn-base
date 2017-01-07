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
import net.juntech.service.system.ISystemUserService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class SystemUserController extends BaseController {

	// 跳转后台管理登陆
	@RequestMapping(value = "/system/toSystemLogin")
	public String toSystemLogin() {

		return "system/systemLogin";
	}

	// 后台管理登陆
	@RequestMapping(value = "/system/systemLogin")
	public void systemLogin(@RequestParam Map<String, Object> param) throws IOException {
		ISystemUserService systemUserService = ClientProUtil.createInterface(ISystemUserService.class, ProjectName.METROPOLIS_SYSTEM);
		Map<String, Object> systemUser = systemUserService.selectSystemUser(param);
		String password = param.get("password").toString();
		Map<String, Object> result = new HashMap<>();
		// 登陆失败
		result.put("login", "0");
		// 登陆成功
		if (systemUser != null && password.equals(systemUser.get("password"))) {
			result.put("login", "1");
			session.setAttribute("user", systemUser);
		}
		writeJson(result);
	}

	/**
	 * 获取service实例
	 * <ul>
	 * <li>Dave 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	private ISystemUserService getService() {
		return ClientProUtil.createInterface(ISystemUserService.class, ProjectName.METROPOLIS_SYSTEM, "systemUserService");
	}
	

	@RequestMapping(value = "/systemuser/toSystemUser")
	public String toPermisisonList() {
		return "systemuser.systemUserList";
	}


	@RequestMapping(value = "/systemuser/searchSystemUser")
	@ResponseBody
	public void getSystemUserList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		ISystemUserService depService = getService();
		Map<String, Object> data = depService.getSystemUserList(param);
		System.err.println(ObjectUtil.objToJson(data));
		writeGridJson(data);
	}

	@RequestMapping(value="/systemuser/toAddSystemUser")
	public String toAddSystemUser(Model model){
		processDepartmentAndOrgData(model);
		return"systemuser/addSystemUser";
	}

	@RequestMapping(value = "/systemuser/saveSystemUser")
	@ResponseBody
	public void saveSystemUser(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		ISystemUserService systemUserService = getService();
		systemUserService.saveSystemUser(param);
	}
	
	private void processDepartmentAndOrgData(Model model){
		IOrganizationService orgService = ClientProUtil.createInterface(IOrganizationService.class, ProjectName.METROPOLIS_SYSTEM, "organizationService");
		List<Map<String, Object>> orgList = orgService.getAllOrganizationForSelect(new HashMap<String, Object>());
		model.addAttribute("orgList", orgList);
		IDepartmentService depService = ClientProUtil.createInterface(IDepartmentService.class, ProjectName.METROPOLIS_SYSTEM, "departmentService");
		if(orgList.size()>0&&orgList.get(0)!=null){
			String orgId = orgList.get(0).get("id").toString();
			HashMap<String, Object> hashMap = new HashMap<String,Object>();
			hashMap.put("orgId", orgId);
			List<Map<String, Object>> depList = depService.getDepartmentByOrgId(hashMap);
			model.addAttribute("depList", depList);
		}
	}

	@RequestMapping(value = "/systemuser/toModifySystemUser")
	public String toModifySystemUser(Model model, @RequestParam Map<String, Object> params) {
		ISystemUserService systemUserService = getService();
		Map<String, Object> systemUserInfo = systemUserService.getSystemUserInfo(params);
		model.addAttribute("data", systemUserInfo);
		processDepartmentAndOrgData(model);
		return "systemuser/addSystemUser";
	}

	@RequestMapping(value = "/systemuser/updateSystemUser")
	@ResponseBody
	public void updateSystemUser(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		ISystemUserService suService = getService();
		suService.updateSystemUser(param);
	}

	@RequestMapping(value = "/systemuser/deleteSystemUser")
	@ResponseBody
	public void deleteSystemUser(@RequestParam Map<String, Object> param) {
		super.setSearchParam(param, null, null);
		ISystemUserService depService = getService();
		depService.delSystemUser(param);
	}
	
	@RequestMapping(value = "/systemuser/getOrgDepartments")
	@ResponseBody
	public void getOrgDepartments(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IDepartmentService depService = ClientProUtil.createInterface(IDepartmentService.class, ProjectName.METROPOLIS_SYSTEM, "departmentService");
		List<Map<String, Object>> list = depService.getDepartmentByOrgId(param);
		this.writeJson(list);
	}

}
