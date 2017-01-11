package net.juntech.service.system;

import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IOrganizationService {

	//查询权限分页数据
	public Map<String,Object>  getOrganizationList(Map<String,Object> params);
	//保存权限信息
	public Map<String,Object>  saveOrganization(Map<String,Object> params);
	//逻辑删除
	public Map<String, Object> delOrganization(Map<String, Object> param);
	//查询权限详情
	Map<String, Object> viewOrganization(Map<String, Object> params);
}
