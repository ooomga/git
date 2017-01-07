package net.juntech.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <ul>
 * <li>GQG 2017年1月4日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public interface IHardwareDao {
	//查询
	public List<Map<String,Object>> selectHardware(Map<String,Object> params);
}
