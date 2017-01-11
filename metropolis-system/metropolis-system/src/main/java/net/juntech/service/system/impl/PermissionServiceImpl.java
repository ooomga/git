package net.juntech.service.system.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Map<String, Object> getPermissionList(Map<String, Object> params) {
		this.init(params);
		Map<String, Object> resulMap = new HashMap<String,Object>();
		list = permissionDao.getPermissionList(params);
		Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
		Integer totalRecords = permissionDao.countPermissionList(params);
		int totalPage = (totalRecords%pageSize==0)?(totalRecords/pageSize):(totalRecords/pageSize+1);
		resulMap.put("list", list);
		resulMap.put("totalRecords", totalRecords);
		resulMap.put("totalPage", totalPage);
		return resulMap;
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
