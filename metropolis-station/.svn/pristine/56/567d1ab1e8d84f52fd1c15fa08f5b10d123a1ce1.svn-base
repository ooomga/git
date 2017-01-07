package net.juntech.service.notice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.IMessageDao;
import net.juntech.dao.common.INoticeDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.message.IMessageService;
import net.juntech.service.notice.INoticeService;

/**
 * <ul>
 * <li>GQG 2016年12月31日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class NoticeServiceImpl extends BaseService implements INoticeService{
	@Autowired
	private INoticeDao noticeDao;


	@Override
	public Map<String, Object> insertNotice(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row=noticeDao.insertNotice(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> editNotice(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row=noticeDao.editNotice(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectNoticeMaster(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> master = noticeDao.selectNoticeMaster(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", master);
		resultMap.put("totalRecords", 100);
		resultMap.put("totalPage", 10);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectNotice(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> notice = noticeDao.selectNotice(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", notice);
		resultMap.put("totalRecords", 100);
		resultMap.put("totalPage", 10);
		return resultMap;
	}
}
