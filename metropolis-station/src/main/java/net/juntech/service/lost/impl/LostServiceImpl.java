package net.juntech.service.lost.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ILostDao;
import net.juntech.dao.common.IMessageDao;
import net.juntech.dao.common.INoticeDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.message.IMessageService;
import net.juntech.service.notice.INoticeService;
import net.juntech.service.station.ILostService;

/**
 * <ul>
 * <li>GQG 2016年12月31日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class LostServiceImpl extends BaseService implements ILostService{
	@Autowired
	private ILostDao lostDao;

	@Override
	public Map<String, Object> selectLost(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list=lostDao.selectLost(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", list);
		resultMap.put("totalRecords", 5);
		resultMap.put("totalPage", 1);
		return resultMap;
	}


	
}
