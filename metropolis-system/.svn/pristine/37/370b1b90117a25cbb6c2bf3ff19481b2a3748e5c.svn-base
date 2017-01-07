package net.juntech.service.system.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.dao.system.IPermissionDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.system.IPermissionService;

/**
 * <ul>
 * <li>Dave 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class PermissionServiceImpl extends BaseService implements IPermissionService{
	
	@Autowired
	private IPermissionDao permissionDao;
	@Autowired
	private ICommonDao commonDao;

	@Override
	public Map<String, Object> getPermissionList(Map<String, Object> params) {
		this.init(params);
		StringBuffer sql = new StringBuffer("select id,name,description,level,module from t_permission  where "
				+ " isDeleted=0  ");
		this.sqlBuild(sql, params);
		this.list = commonDao.queryForList(sql.toString(),params);
		this.totalRecords = commonDao.selectCount(sql, params);
		return result();
	}

	@Override
	public Map<String, Object> savePermission(Map<String, Object> params) {
		System.out.println(params);
		int rows = permissionDao.savePermission(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", rows);
		return resultMap;
	}

	@Override
	public Map<String, Object> delPermission(Map<String, Object> params) {
		System.out.println(params);
		int rows = permissionDao.delPermission(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", rows);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> viewPermission(Map<String, Object> params) {
		System.out.println(params);
		Map<String,Object> infoMap =  permissionDao.getPermissionInfo(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", infoMap);
		return resultMap;
	}

}
