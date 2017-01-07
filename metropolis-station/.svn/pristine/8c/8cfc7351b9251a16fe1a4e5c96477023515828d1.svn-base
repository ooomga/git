package net.juntech.service.station.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.dao.common.IStationDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.station.IStationService;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class StationServiceImpl extends BaseService implements IStationService{
	@Autowired
	private IStationDao stationDao;
	@Autowired
	private ICommonDao commonDao;

	@Override
	public Map<String, Object> getStationByLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> stationList = stationDao.selectStationByLine(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", stationList);
		resultMap.put("totalRecords", 500);
		resultMap.put("totalPage", 10);
		return resultMap;
	}

	@Override
	public Map<String, Object> saveStationByLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = stationDao.insertStationByLine(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> delStationByLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = stationDao.deleteStationByLine(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectStationAndLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> List = stationDao.selectStationAndLine(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", List);
		resultMap.put("totalRecords", 500);
		resultMap.put("totalPage", 10);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectStationByName(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> List = stationDao.selectStationByName(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("list", List);
		return resultMap;
	}

	@Override
	public Map<String, Object> updateStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int row = stationDao.updateStation(params);
		Map<String, Object> resultMap = new HashMap<String,Object>();	
		resultMap.put("data", row);
		return resultMap;
	}

	@Override
	public Map<String, Object> selectStationByLineCode(Map<String, Object> params) {
		super.init(params);
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_station_info WHERE display = 1 and lineCode = :lineCode ");
		super.sqlBuild(sql, params);
		super.list = commonDao.queryForList(sql.toString(), params);
		for (Map<String, Object> map : list) {
			Object extraLineCode = map.get("extraLineCode");
			String[] split = {};
			if (extraLineCode != null) {
				split = extraLineCode.toString().split(",");
			}
			map.put("extraLine", split);
		}
		super.totalRecords = commonDao.selectCount(sql, params);
		return result();
	}

	@Override
	public List<Map<String, Object>> selectTimeByStation(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer();
		params.put("stationName", "人民广场");
		params.put("direct", "下行");
		sql.append("SELECT (inTime-CURTIME()) time FROM t_line_time  WHERE stationName = :stationName AND direct = :direct AND inTime > SYSDATE() GROUP BY seq LIMIT 5");
		List<Map<String, Object>> dates = commonDao.queryForList(sql.toString(), params);
		return dates;
	}

}
