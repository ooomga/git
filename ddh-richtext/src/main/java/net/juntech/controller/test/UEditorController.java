package net.juntech.controller.test;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.juntech.controller.base.BaseWebController;

/**
 * <ul>
 * <li>Dave 2016年12月24日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class UEditorController extends BaseWebController{

	@RequestMapping(value="/test/testUEditor")
	public String testUEditor(){
		
		return "test/testUEditor";
	}
	
	@RequestMapping(value = "/editor/config")
	public String config() {
		return "ueditor/controller";
	}
	
	public void uploadFile(){
	        boolean isMultipart = ServletFileUpload.isMultipartContent(this.request);
	}
}
