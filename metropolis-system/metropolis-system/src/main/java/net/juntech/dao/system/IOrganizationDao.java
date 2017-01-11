package net.juntech.dao.system;

import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IOrganizationDao {

	Map<String, Object> getOrganizationInfo(Map<String, Object> params);

	int delOrganization(Map<String, Object> params);

	int saveOrganization(Map<String, Object> params);

	Integer countOrganizationList(Map<String, Object> params);

	List<?> getOrganizationList(Map<String, Object> params);

}
