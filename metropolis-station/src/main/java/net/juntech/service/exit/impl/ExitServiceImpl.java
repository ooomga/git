package net.juntech.service.exit.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.IExitDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.station.IExitService;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class ExitServiceImpl extends BaseService implements IExitService{
	@Autowired
	private IExitDao exitDao;

	@Override
	public Map<String, Object> selectExitByStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> exits = exitDao.selectExitByStation(params);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", exits);
		resultMap.put("totalRecords", 5);
		resultMap.put("totalPage", 1);
		return resultMap;
	}

	@Override
	public Map<String, Object> saveExitByStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = exitDao.insertExitByStation(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> delExitByStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = exitDao.deleteExitByStation(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> updateExit(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = exitDao.updateExit(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}
	
}
