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
public interface ILineService {
	/**
	 * 查询线路
	 * <ul>
	 * <li>GQG 2016年12月27日 新建</li>
	 * </ul>
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> selectLineList(Map<String, Object> params);
}
