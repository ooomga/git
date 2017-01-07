package net.juntech.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.system.IDepartmentService;

/**
 * <ul>
 * <li>Dave 2016年12月29日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class DepartmentServiceImpl extends BaseService implements IDepartmentService{
	
	private static Log log = LogFactory.getLog(DepartmentServiceImpl.class);
	
	@Autowired
	private ICommonDao commonDao;

	@Override
	public Map<String, Object> getDepartmentList(Map<String, Object> params) {
		log.info("getDepartmentList:"+params.toString());
		this.init(params);
		StringBuffer sql = new StringBuffer("SELECT dev.name,dev.seq,dev.id,dev.description,dev.createTime,")
				.append(" dev.modifyTime,org.name orgName,org.id orgId ")
				.append(" FROM t_department dev ")
				.append(" INNER JOIN t_organization org ")
				.append("  ON dev.orgId = org.id WHERE dev.isDeleted=0 and org.isDeleted=0");
		this.sqlBuild(sql, params);
		this.list = commonDao.queryForList(sql.toString(),params);
		this.totalRecords = commonDao.selectCount(sql, params);
		return result();
	}

	@Override
	public Map<String, Object> saveDepartment(Map<String, Object> params) {
		log.info("saveDepartment:"+params.toString());
		int insert = commonDao.insert(params, "t_department");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", insert);
		boolean isSuccess = insert>0?true:false;
		resultMap.put("success", isSuccess);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> updateDepartment(Map<String, Object> params) {
		log.info("updateDepartment:"+params.toString());
		int row = commonDao.updateById(params, "t_department");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", row);
		boolean isSuccess = row>0?true:false;
		resultMap.put("success", isSuccess);
		return resultMap;
	}

	@Override
	public Map<String, Object> delDepartment(Map<String, Object> param) {
		log.info("delDepartment:"+param.toString());
		int row = commonDao.delete(param,  "t_department");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", row);
		boolean isSuccess = row>0?true:false;
		resultMap.put("success", isSuccess);
		return resultMap;
	}

	@Override
	public Map<String, Object> getDepartmentInfo(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer("SELECT dev.name,dev.seq,dev.id,dev.description,dev.createTime,")
				.append(" dev.modifyTime,org.name orgName,org.id orgId ")
				.append(" FROM t_department dev ")
				.append(" INNER JOIN t_organization org ")
				.append("  ON dev.orgId = org.id WHERE dev.isDeleted=0 and org.isDeleted=0 and dev.id=:id ");
		return commonDao.queryForMap(sql.toString(), params);
	}

	@Override
	public List<Map<String, Object>> getDepartmentByOrgId(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer("SELECT dev.name,dev.seq,dev.id,dev.description,dev.createTime,")
				.append(" dev.modifyTime,org.name orgName,org.id orgId ")
				.append(" FROM t_department dev ")
				.append(" INNER JOIN t_organization org ")
				.append("  ON dev.orgId = org.id WHERE dev.isDeleted=0 and org.isDeleted=0 and org.id=:orgId ");
		return commonDao.queryForList(sql.toString(), params);
	}


}
