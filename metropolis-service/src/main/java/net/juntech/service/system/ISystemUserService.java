package net.juntech.service.system;

import java.util.Map;

/**
 * <ul>
 * <li>xhl 2016年12月29日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface ISystemUserService {
	
	//查询系统用户分页数据
	public Map<String,Object>  getSystemUserList(Map<String,Object> params);
	//保存系统用户信息
	public Map<String,Object>  saveSystemUser(Map<String,Object> params);
	//逻辑删除
	public Map<String, Object> delSystemUser(Map<String, Object> param);
	//修改系统用户信息
	Map<String, Object> updateSystemUser(Map<String, Object> params);
	//获取系统用户信息
	Map<String, Object> getSystemUserInfo(Map<String, Object> params);
	// 查询系统用户
	Map<String, Object> selectSystemUser(Map<String, Object> param);

}
