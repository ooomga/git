package net.juntech.service.system;

import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IOrganizationService {

	//查询组织分页数据
	public Map<String,Object>  getOrganizationList(Map<String,Object> params);
	//保存组织信息
	public Map<String,Object>  saveOrganization(Map<String,Object> params);
	//逻辑删除
	public Map<String, Object> delOrganization(Map<String, Object> param);
	//查询组织详情
	public Map<String, Object> viewOrganization(Map<String, Object> params);
	//查询所有组织-用于下拉选
	public List<Map<String, Object>> getAllOrganizationForSelect(Map<String, Object> params);
}
