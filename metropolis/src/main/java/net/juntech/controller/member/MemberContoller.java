package net.juntech.controller.member;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.member.IMemberService;
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
public class MemberContoller extends BaseController {
	
	@RequestMapping(value="/member/toMember")
	public String toPermisisonList(){
		return "member.memberList";
	}
	
	/**
	 * 获取service实例
	 * <ul>
	 * <li>Dave 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	private IMemberService getService(){
		return ClientProUtil.createInterface(IMemberService.class, ProjectName.METROPOLIS_SYSTEM, "memberService");
	}
	
	@RequestMapping(value = "/member/searchMember")
	@ResponseBody
	public void getMemberList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IMemberService memberService = getService();
		Map<String, Object> data = memberService.getMemberList(param);
		System.err.println(ObjectUtil.objToJson(data));
		writeGridJson(data);
	}
	
	@RequestMapping(value="/member/toAddMember")
	public String toAddMember(Model model){
		return "member/addMember";
	}
	
	@RequestMapping(value = "/member/saveMember")
	@ResponseBody
	public void saveMember(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IMemberService memberService = getService();
		memberService.saveMember(param);
	}
	
	@RequestMapping(value="/member/toModifyMember")
	public String toModifyMember(Model model,@RequestParam Map<String,Object> params){
		IMemberService memberService = getService();
		Map<String, Object> memberInfo = memberService.getMemberInfo(params);
		model.addAttribute("data", memberInfo);
		return "member/addMember";
	}
	
	@RequestMapping(value = "/member/updateMember")
	@ResponseBody
	public void updateMember(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IMemberService memberService = getService();
		memberService.updateMember(param);
	}
	
	@RequestMapping(value="/member/deleteMember")
	@ResponseBody
	public void deleteMember(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IMemberService memberService = getService();
		memberService.delMember(param);
	}
	
	@RequestMapping(value="/member/viewMember")
	public String  viewMember(@RequestParam Map<String, Object> param){
		
		return "member.viewMember";
	}
	
}
