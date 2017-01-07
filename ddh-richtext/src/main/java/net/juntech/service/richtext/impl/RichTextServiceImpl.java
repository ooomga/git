package net.juntech.service.richtext.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.richtext.RichTextDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.richtext.IRichTextService;

/**
 * <ul>
 * <li>Dave 2016年12月25日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class RichTextServiceImpl extends BaseService  implements IRichTextService {
	
	@Autowired
	private RichTextDao richTextDao;

	@Override
	public Map<String, Object> insertRichText(Map<String, Object> params) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Integer richId = richTextDao.insertRichText(params);
			resultMap.put("data", richId);
			resultMap.put("status", this.SUCCESS);
		} catch (Exception e) {
			resultMap.put("status", this.FAILED);
			resultMap.put("msg","插入富文本失败");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> searchRichTextById(Map<String, Object> params) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Map<String,Object> data = richTextDao.searchRichTextById(params);
			resultMap.put("data", data);
			resultMap.put("status", this.SUCCESS);
		} catch (Exception e) {
			resultMap.put("status", this.FAILED);
			resultMap.put("msg","插入富文本失败");
		}
		return resultMap;
	}

}
