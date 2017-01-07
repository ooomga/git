package net.juntech.controller.system;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.system.IPermissionService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>Dave 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class PermissionController extends BaseController {
	
	
	@RequestMapping(value="/permission/toPermission")
	public String toPermisisonList(){
		return "permission.permissionList";
	}
	
	@RequestMapping(value = "/permission/searchPermission")
	@ResponseBody
	public void getPermissionList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);

		IPermissionService perService = ClientProUtil.createInterface(IPermissionService.class, ProjectName.METROPOLIS_SYSTEM, "permissionService");
		Map<String, Object> data = perService.getPermissionList(param);
		System.err.println(ObjectUtil.objToJson(data));
		writeGridJson(data);
	}

	
	@RequestMapping(value="/permission/toAddPermission")
	public String toAddPermission(){
		return "permission/addPermission";
	}
	
	@RequestMapping(value = "/permission/savePermission")
	@ResponseBody
	public void savePermission(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IPermissionService perService = ClientProUtil.createInterface(IPermissionService.class, ProjectName.METROPOLIS_SYSTEM, "permissionService");
		Map<String, Object> data = perService.savePermission(param);
	}
	
	@RequestMapping(value="/permission/deletePermission")
	@ResponseBody
	public void deletePermission(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IPermissionService perService = ClientProUtil.createInterface(IPermissionService.class, ProjectName.METROPOLIS_SYSTEM, "permissionService");
		Map<String, Object> data = perService.delPermission(param);
	}
	
	@RequestMapping(value="/permission/viewPermission")
	@ResponseBody
	public void viewPermission(@RequestParam Map<String, Object> param,Model model){
		super.setSearchParam(param, null, null);
		IPermissionService perService = ClientProUtil.createInterface(IPermissionService.class, ProjectName.METROPOLIS_SYSTEM, "permissionService");
		Map<String, Object> data = perService.viewPermission(param);
		model.addAttribute("data", data);
	}
}
