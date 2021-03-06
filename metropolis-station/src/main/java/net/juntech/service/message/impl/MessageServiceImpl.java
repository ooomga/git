package net.juntech.service.message.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.IMessageDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.message.IMessageService;

/**
 * <ul>
 * <li>GQG 2016年12月31日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class MessageServiceImpl extends BaseService implements IMessageService{
	@Autowired
	private IMessageDao messageDao;

	@Override
	public Map<String, Object> selectMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> messages = messageDao.selectMessage(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", messages);
		resultMap.put("msg", "");
		resultMap.put("state", "SUCCESS");
		resultMap.put("totalRecords", 100);
		resultMap.put("totalPage", 10);
		return resultMap;
		
	}

	@Override
	public Map<String, Object> insertMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row=messageDao.insertMessage(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> publishMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row=messageDao.publishMessage(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectMessageInfo(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Map<String, Object> message = messageDao.selectMessageInfo(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", message);
		return resultMap;
	}

	@Override
	public Map<String, Object> delMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = messageDao.delMessage(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}
}
