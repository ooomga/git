package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.ILostDao;

/**
 * <ul>
 * <li>GQG 2017年1月4日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class LostDaoImpl implements ILostDao{
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Map<String, Object>> selectLost(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from t_lost ");
		List<Map<String, Object>> result =template.queryForList(sql.toString(), params);
		return result;
	}

}
