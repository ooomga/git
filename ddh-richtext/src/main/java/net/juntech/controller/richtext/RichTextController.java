package net.juntech.controller.richtext;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.controller.base.BaseWebController;
import net.juntech.service.richtext.IRichTextService;

/**
 * <ul>
 * <li>Dave 2016年12月25日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class RichTextController extends BaseWebController{

	@Autowired
	private IRichTextService richTextService;
	
	
	/**
	 * 新建富文本
	 * @param params
	 * @throws IOException
	 */
	@RequestMapping(value="/richtext/addRichText")
	public String addRichText(){
		return "richtext/addRichText";
	}
	
	/**
	 * 保存富文本
	 * @param params
	 * @throws IOException
	 */
	@RequestMapping(value="/richtext/saveRichText")
	@ResponseBody
	public void saveRichText(@RequestParam Map<String,Object> params) throws IOException{
		System.out.println(params.toString());
		Map<String,Object> resultMap = richTextService.insertRichText(params);
		this.writeJson(resultMap);
	}
	
	@RequestMapping(value="/richtext/viewRichText")
	public String viewRichText(Model model,@RequestParam Map<String,Object> params){
		Map<String,Object>  resultMap= richTextService.searchRichTextById(params);
		model.addAttribute("data", resultMap.get("data"));
		return "/richtext/viewRichText";
	}
	
}
