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
public interface ILostService {
	//查询
	public Map<String,Object> selectLost(Map<String,Object> params);
}
