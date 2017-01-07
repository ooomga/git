package net.juntech.service.station;

import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IExitService {

	/**
	 * 根据线路 站点查询出口
	 */
	public Map<String,Object> selectExitByStation(Map<String,Object> params);
	//添加出口
	public Map<String,Object> saveExitByStation(Map<String, Object> params);
	//逻辑删除数据
	public Map<String,Object> delExitByStation(Map<String, Object> params);
	//修改出口
	public Map<String,Object> updateExit(Map<String, Object> params);
}
