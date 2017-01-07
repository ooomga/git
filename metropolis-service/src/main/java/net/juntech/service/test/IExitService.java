package net.juntech.service.test;

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
}
