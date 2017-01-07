package net.juntech.dao.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.system.IPermissionDao;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>Dave 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class PermissionDaoImpl implements IPermissionDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Map<String, Object>> getPermissionList(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder("select id,name,description,level,module from t_permission  where "
				+ " isDeleted=0  limit :start,:pageSize ");
		return namedParameterJdbcTemplate.queryForList(sql.toString(), params);
	}

	@Override
	public Integer countPermissionList(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder("select count(id) from t_permission where isDeleted=0  ");
		return namedParameterJdbcTemplate.queryForObject(sql.toString(), params,Integer.class);
	}

	@Override
	public int savePermission(Map<String, Object> params) {
		params.put("id", UuidUtil.generateUuid());
		String sql = " insert into t_permission (id,name,module,description,level)  values(:id,:name,:module,:description,:level)";
		return namedParameterJdbcTemplate.update(sql, params);
	}

	@Override
	public int delPermission(Map<String, Object> params) {
		int rows = 0;
		if(params.containsKey("id")){
			String sql = " update  t_permission  set isDeleted=1 where id=:id  ";
			rows = namedParameterJdbcTemplate.update(sql, params);
		}
		return rows;
	}

	@Override
	public Map<String, Object> getPermissionInfo(Map<String, Object> params) {
		String sql = " select * from t_permission where id=:id ";
		return namedParameterJdbcTemplate.queryForMap(sql, params);
	}

}
