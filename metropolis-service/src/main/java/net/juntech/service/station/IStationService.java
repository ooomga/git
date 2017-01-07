package net.juntech.service.station;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IStationService {

	/**
	 * 根据线路id查询站点
	 */
	public Map<String, Object> getStationByLine(Map<String, Object> params);

	// 添加站点
	public Map<String, Object> saveStationByLine(Map<String, Object> params);

	// 逻辑删除站点
	public Map<String, Object> delStationByLine(Map<String, Object> params);

	// 查询站点 线路
	public Map<String, Object> selectStationAndLine(Map<String, Object> params);

	// 根据站点名查询
	public Map<String, Object> selectStationByName(Map<String, Object> params);

	// 修改站点
	public Map<String, Object> updateStation(Map<String, Object> params);

	// 查询站点根据线路代码
	public Map<String, Object> selectStationByLineCode(Map<String, Object> params);

	// 根据站点查询下一班时间
	public List<Map<String, Object>> selectTimeByStation(Map<String, Object> params);
}
