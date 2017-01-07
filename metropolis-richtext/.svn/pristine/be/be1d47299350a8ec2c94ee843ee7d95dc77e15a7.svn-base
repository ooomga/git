package net.juntech.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
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
	private static Log log = LogFactory.getLog(OrganizationServiceImpl.class);
	
	@Autowired
	private IOrganizationDao organizationDao;
	@Autowired
	private ICommonDao commonDao;

	@Override
	public Map<String, Object> getOrganizationList(Map<String, Object> params) {
		log.info("getOrganizationList:"+params.toString());
		this.init(params);
		StringBuffer sql = new StringBuffer("SELECT org.id,org.seq,org.name,org.code,org.status,org.parentId,")
				.append(" parentOrg.name parentName,org.createTime,org.modifyTime ")
				.append(" FROM t_organization org ")
				.append(" LEFT JOIN t_organization parentOrg ")
				.append("  ON org.parentId=parentOrg.id where org.isDeleted=0 ");
		this.sqlBuild(sql, params);
		this.list = commonDao.queryForList(sql.toString(),params);
		this.totalRecords = commonDao.selectCount(sql, params);
		return result();
	}

	@Override
	public Map<String, Object> saveOrganization(Map<String, Object> params) {
		log.info("saveOrganization:"+params.toString());
		System.out.println(params);
		int insert = commonDao.insert(params, "t_organization");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", insert);
		return resultMap;
	}

	@Override
	public Map<String, Object> delOrganization(Map<String, Object> params) {
		log.info("delOrganization:"+params.toString());
		System.out.println(params);
		int rows = organizationDao.delOrganization(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", rows);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> viewOrganization(Map<String, Object> params) {
		log.info("viewOrganization:"+params.toString());
		System.out.println(params);
		Map<String,Object> infoMap =  organizationDao.getOrganizationInfo(params);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", infoMap);
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> getAllOrganizationForSelect(Map<String, Object> params) {
		log.info("getAllOrganizationForSelect:"+params.toString());
		this.init(params);
		StringBuffer sql = new StringBuffer("SELECT org.id,org.name ")
				.append(" FROM t_organization org  where org.isDeleted=0 ");
		List<Map<String, Object>> list = commonDao.queryForList(sql.toString(), params);
		return list;
	}

}
