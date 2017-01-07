package net.juntech.dao.system.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.odianyun.common.DateUtil;
import com.odianyun.soa.common.uuid.UUIDUtils;

import net.juntech.dao.system.IOrganizationDao;

/**
 * <ul>
 * <li>Dave 2016年12月28日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class OrganizationDaoImpl  implements IOrganizationDao{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Map<String, Object> getOrganizationInfo(Map<String, Object> params) {
		String sql = "SELECT org.id,org.name,org.code,org.status,org.parentId,"
				+ " parentOrg.name parentName,org.createTime "
				+ " FROM t_organization org "
				+ " LEFT JOIN t_organization parentOrg "
				+ "  ON org.parentId=parentOrg.id where org.isDeleted=0 "
				+ " and org.id=:id  ";
		return namedParameterJdbcTemplate.queryForMap(sql, params);
	}

	@Override
	public int delOrganization(Map<String, Object> params) {
		String sql = " update t_organization set isDeleted=1 where id=:id ";
		return namedParameterJdbcTemplate.update(sql, params);
	}

	@Override
	public int saveOrganization(Map<String, Object> params) {
		params.put("id", UUIDUtils.getUUID());
		params.put("createTime", DateUtil.getFormatCurrentTime("yyyy-MM-dd HH:mm:ss"));
		String sql = " insert into t_organization (id,name,code,status,parentId,createTime) "
				+ " values (:id,:name,:code,:status,:parentId,:createTime) ";
		return namedParameterJdbcTemplate.update(sql, params);
	}

}
