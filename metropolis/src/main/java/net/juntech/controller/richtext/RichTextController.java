package net.juntech.controller.richtext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectName;
import net.juntech.controller.base.BaseController;
import net.juntech.service.richtext.IRichTextService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>Dave 2016年12月25日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class RichTextController extends BaseController{

	@RequestMapping(value = "/editor/config")
	public String config() {
		return "ueditor/controller";
	}
	
	/**
	 * 获取service实例
	 * <ul>
	 * <li>Dave 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	private IRichTextService getService(){
		return ClientProUtil.createInterface(IRichTextService.class, ProjectName.METROPOLIS_RICHTEXT, "richTextService");
	}
	
	@RequestMapping(value="/richtext/toRichText")
	public String toPermisisonList(){
		return "richtext.richtextList";
	}
	
	@RequestMapping(value = "/richtext/searchRichText")
	@ResponseBody
	public void getRichTextList(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IRichTextService richtextService = getService();
		Map<String, Object> data = richtextService.getRichTextList(param);
		System.err.println(ObjectUtil.objToJson(data));
		writeGridJson(data);
	}
	
	@RequestMapping(value="/richtext/toAddRichText")
	public String toAddRichText(Model model,@RequestParam Map<String, Object> param){
		IRichTextService richtextService = getService();
		List<Map<String,Object>> list = richtextService.getRichTextTypes(param);
		model.addAttribute("typeList", list);
		return "richtext/addRichText";
	}
	
	@RequestMapping(value = "/richtext/saveRichText")
	@ResponseBody
	public void saveRichText(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IRichTextService richtextService = getService();
		richtextService.saveRichText(param);
	}
	
	@RequestMapping(value="/richtext/toModifyRichText")
	public String toModifyRichText(Model model,@RequestParam Map<String,Object> params){
		IRichTextService richtextService = getService();
		Map<String, Object> richtextInfo = richtextService.getRichTextInfo(params);
		model.addAttribute("data", richtextInfo);
		List<Map<String,Object>> list = richtextService.getRichTextTypes(params);
		model.addAttribute("typeList", list);
		return "richtext/addRichText";
	}
	
	@RequestMapping(value="/richtext/viewRichText")
	public String viewRichText(Model model,@RequestParam Map<String,Object> params){
		IRichTextService richtextService = getService();
		Map<String, Object> richtextInfo = richtextService.getRichTextInfo(params);
		model.addAttribute("data", richtextInfo);
		return "richtext/viewRichText";
	}
	
	@RequestMapping(value = "/richtext/updateRichText")
	@ResponseBody
	public void updateRichText(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		IRichTextService richtextService = getService();
		richtextService.updateRichText(param);
	}
	
	@RequestMapping(value="/richtext/deleteRichText")
	@ResponseBody
	public void deleteRichText(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IRichTextService richtextService = getService();
		richtextService.delRichText(param);
	}
	
	@RequestMapping(value="/richtext/publishRichText")
	@ResponseBody
	public void publishRichText(@RequestParam Map<String, Object> param){
		super.setSearchParam(param, null, null);
		IRichTextService richtextService = getService();
		richtextService.publishRichText(param);
	}
	
//	/**
//	 * 保存富文本
//	 * @param params
//	 * @throws IOException
//	 */
//	@RequestMapping(value="/richtext/saveRichText")
//	@ResponseBody
//	public void saveRichText(@RequestParam Map<String,Object> params) throws IOException{
//		System.out.println(params.toString());
//		IRichTextService richTextService = getService();
//		Map<String,Object> resultMap = richTextService.insertRichText(params);
//		this.writeJson(resultMap);
//	}
//	
//	@RequestMapping(value="/richtext/viewRichText")
//	public String viewRichText(Model model,@RequestParam Map<String,Object> params){
//		IRichTextService richTextService = getService();
//		Map<String,Object>  resultMap= richTextService.searchRichTextById(params);
//		model.addAttribute("data", resultMap.get("data"));
//		return "/richtext/viewRichText";
//	}
	
}
