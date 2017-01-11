package net.juntech.service.system.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.system.IOrganizationDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.system.IOrganizationService;

/**
 * <ul>
 * <li>Dave 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class OrganizationServiceImpl extends BaseService implements IOrganizationService{
	
	@Autowired
	private IOrganizationDao organizationDao;

	@Override
	public Map<String, Object> getOrganizationList(Map<String, Object> params) {
		this.init(params);
		Map<String, Object> resulMap = new HashMap<String,Object>();
		list = organizationDao.getOrganizationList(params);
		Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
		Integer totalRecords = organizationDao.countOrganizationList(params);
		int totalPage = (totalRecords%pageSize==0)?(totalRecords/pageSize):(totalRecords/pageSize+1);
		resulMap.put("list", list);
		resulMap.put("totalRecords", totalRecords);
		resulMap.put("totalPage", totalPage);
		return resulMap;
	}

	@Override
	public Map<String, Object> saveOrganization(Map<String, Object> params) {
		System.out.println(params);
		int rows = organizationDao.saveOrganization(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", rows);
		return resultMap;
	}

	@Override
	public Map<String, Object> delOrganization(Map<String, Object> params) {
		System.out.println(params);
		int rows = organizationDao.delOrganization(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", rows);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> viewOrganization(Map<String, Object> params) {
		System.out.println(params);
		Map<String,Object> infoMap =  organizationDao.getOrganizationInfo(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", infoMap);
		return resultMap;
	}

}
