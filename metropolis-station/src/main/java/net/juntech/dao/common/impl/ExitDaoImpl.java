package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.IExitDao;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class ExitDaoImpl implements IExitDao{
	@Autowired
	private NamedParameterJdbcTemplate template;
	@Override
	public List<Map<String, Object>> selectExitByStation(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM t_station_exit e WHERE 1=1 and display = 0 ");
		if(params.get("stationCode") != null && !"".equals(params.get("stationCode"))){
			sql.append("  and e.stationCode=:stationCode");
		}
		if(params.get("exitCode") != null && !"".equals(params.get("exitCode"))){
			sql.append("  and e.exitCode=:exitCode");
		}
		sql.append(" ORDER BY e.seq desc");
		if(params.get("stationCode") != null && !"".equals(params.get("stationCode"))){
			params.put("stationCode", params.get("stationCode"));
		}
		if(params.get("exitCode") != null && !"".equals(params.get("exitCode"))){
			params.put("exitCode", params.get("exitCode"));
		}
		return template.queryForList(sql.toString(), params);
	}
	@Override
	public int insertExitByStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		if(params.get("stationCode") == null || "".equals(params.get("stationCode"))){
			return 0;
		}
		params.put("stationCode", params.get("stationCode"));
		params.put("exitCode", params.get("exitCode"));
		params.put("exitName", params.get("exitName"));
		String sql="insert into t_station_exit (exitCode,exitName,display) values(:exitCode,:exitName,0) where stationCode=:stationCode ";
		return template.update(sql, params);
	}
	@Override
	public int deleteExitByStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		if(params.get("stationCode") == null || "".equals(params.get("stationCode")) 
				|| params.get("exitCode") == null || "".equals(params.get("exitCode"))){
			return 0;
		}
		params.put("stationCode", params.get("stationCode"));
		params.put("exitCode", params.get("exitCode"));
		String sql="update t_station_exit set display = 1 where stationCode =:stationCode and exitCode =:exitCode ";
		return template.update(sql, params);
	}
	@Override
	public int updateExit(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("seq", params.get("seq"));
		params.put("exitCode", params.get("exitCode"));
		params.put("stationCode", params.get("stationCode"));
		params.put("stationName", params.get("stationName"));
		String sql="update t_station_exit set exitCode=:exitCode,exitName =:exitName  where seq =:seq";
		return template.update(sql, params);
	}

}
