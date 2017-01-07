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
public interface IExitDao {

	/**
	 * 根据线路 站点查询出口
	 */
	public List<Map<String,Object>> selectExitByStation(Map<String,Object> params);
	/**
	 * 添加出口
	 * <ul>
	 * <li>GQG 2016年12月28日 新建</li>
	 * </ul>
	 * 
	 * @param params
	 * @return
	 */
	public int insertExitByStation(Map<String, Object> params);
	/**
	 * 
	 * 删除出口  隐藏数据
	 */
	public int deleteExitByStation(Map<String, Object> params);
	//修改出口
	public int updateExit(Map<String, Object> params);
}
