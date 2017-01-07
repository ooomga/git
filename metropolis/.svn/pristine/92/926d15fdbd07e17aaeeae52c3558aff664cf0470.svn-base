package net.juntech.controller.notice;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.juntech.constant.ProjectNameConstant;
import net.juntech.controller.base.BaseController;
import net.juntech.service.message.IMessageService;
import net.juntech.service.notice.INoticeService;
import net.juntech.service.richtext.IRichTextService;
import net.juntech.service.station.ILineService;
import net.juntech.util.ObjectUtil;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>GQG 2016年12月31日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class NoticeController extends BaseController{
	
	private INoticeService getService(){
		return ClientProUtil.createInterface(INoticeService.class, ProjectNameConstant.METROPOLIS_STATION, "noticeService");
	}
	
	@RequestMapping(value = "/notice/toNoticeMaster")
	public String selectMaster(@RequestParam Map<String,Object> params) {
		return "notice.noticeMaster";
	}
	
	@RequestMapping(value = "/notice/getNoticeMaster")
	@ResponseBody
	public void getNoticeMaster(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		INoticeService noticeService = getService();
		Map<String, Object>  resultMap = noticeService.selectNoticeMaster(param);
//		System.err.println(ObjectUtil.objToJson(resultMap));
		writeGridJson(resultMap);
	}

	@RequestMapping(value="/notice/toAddNotice")
	public String toAddMessage(){
		return "notice/addNotice";
	}
	@RequestMapping(value = "/notice/saveNotice")
	@ResponseBody
	public void saveNotice(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		INoticeService noticeService = getService();
		Map<String, Object> data = noticeService.insertNotice(param);
	}
	@RequestMapping(value = "/notice/toEditNotice")
	public String toEditNotice(@RequestParam Map<String, Object> param,Model model) throws IOException {
		super.setSearchParam(param, null, null);
		INoticeService noticeService = getService();
		Map<String, Object> data = noticeService.selectNotice(param);
		model.addAttribute("data", data);
		return "notice/editNotice";
	}
	@RequestMapping(value = "/notice/editNotice")
	@ResponseBody
	public void editNotice(@RequestParam Map<String, Object> param) throws IOException {
		super.setSearchParam(param, null, null);
		INoticeService noticeService = getService();
		Map<String, Object> data = noticeService.editNotice(param);
	}
}
