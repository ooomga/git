package net.juntech.dao.system;

import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IPermissionDao {

	List<Map<String,Object>> getPermissionList(Map<String, Object> params);

	Integer countPermissionList(Map<String, Object> params);

	int savePermission(Map<String, Object> params);

	int delPermission(Map<String, Object> params);

	Map<String, Object> getPermissionInfo(Map<String, Object> params);

}
