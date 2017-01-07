package net.juntech.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public interface IStationDao {

	/**
	 * 根据线路id查询站点
	 */
	public List<Map<String,Object>> selectStationByLine(Map<String,Object> params);
	/**
	 * 添加站点
	 * <ul>
	 * <li>GQG 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @param params
	 * @return
	 */
	public int insertStationByLine(Map<String, Object> params);
	/**
	 * 
	 * 删除站点  隐藏数据
	 */
	public int deleteStationByLine(Map<String, Object> params);
	//查询站点 线路
	public List<Map<String,Object>> selectStationAndLine(Map<String,Object> params);
	//根据站点名查询
	public List<Map<String,Object>> selectStationByName(Map<String,Object> params);
	//修改站点
	public int updateStation(Map<String, Object> params);
}
