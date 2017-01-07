package net.juntech.service.system;

import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月29日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IDepartmentService {
	
	//查询部门分页数据
	public Map<String,Object>  getDepartmentList(Map<String,Object> params);
	//保存部门信息
	public Map<String,Object>  saveDepartment(Map<String,Object> params);
	//逻辑删除
	public Map<String, Object> delDepartment(Map<String, Object> param);
	//修改部门信息
	Map<String, Object> updateDepartment(Map<String, Object> params);
	//获取部门信息
	Map<String, Object> getDepartmentInfo(Map<String, Object> params);
	//根据组织获取部门信息
	List<Map<String, Object>> getDepartmentByOrgId(Map<String, Object> params);

}
