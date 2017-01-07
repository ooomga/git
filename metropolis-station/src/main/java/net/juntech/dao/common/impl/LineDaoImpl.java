package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.ILineDao;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class LineDaoImpl implements ILineDao{
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Map<String, Object>> selectLineList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM t_line_info line WHERE 1=1 and display = 0 ");
		if(params.get("lineCode") != null && !"".equals(params.get("lineCode"))){
			sql.append("  and line.lineCode=:lineCode");
		}
		if(params.get("seq") != null && !"".equals(params.get("seq"))){
			sql.append("  and line.seq=:seq");
		}
		sql.append(" ORDER BY line.seq ASC");
		List<Map<String, Object>> result = template.queryForList(sql.toString(), params);
		if(params.get("lineCode") != null && !"".equals(params.get("lineCode"))){
			params.put("lineCode", params.get("lineCode"));
		}
		if(params.get("seq") != null && !"".equals(params.get("seq"))){
			params.put("seq", params.get("seq"));
		}
		return result;
	}

	@Override
	public int insertLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("lineCode", params.get("lineCode"));
		params.put("lineName", params.get("lineName"));
		params.put("lineEName", params.get("lineEName"));
		String sql="insert into t_line_info (lineCode,lineName,lineEName,display) values(:lineCode,:lineName,:lineEName,0)";
		return template.update(sql, params);
	}

	@Override
	public int deleteLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("seq", params.get("id"));
		String sql="update t_line_info set display = 1 where seq =:seq";
		return template.update(sql, params);
	}

	@Override
	public int updataLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("seq", params.get("seq"));
//		params.put("lineCode", params.get("lineCode"));
		params.put("lineName", params.get("lineName"));
		params.put("lineEName", params.get("lineEName"));
		String sql="update t_line_info set lineName =:lineName,lineEName =:lineEName  where seq =:seq ";
		return template.update(sql, params);
	}
	

}
