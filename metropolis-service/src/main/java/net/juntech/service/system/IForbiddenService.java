package net.juntech.service.system;

import java.util.Map;

/**
 * 系统设置
 * <ul>
 * <li>xhl 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IForbiddenService {

	// 保存数据
	int insertForbidden(Map<String, Object> param);

	// 查询数据
	Map<String, Object> selectForbidden(Map<String, Object> param);

	// 查询全部数据
	Map<String, Object> selectForbiddenAll(Map<String, Object> param);

}
