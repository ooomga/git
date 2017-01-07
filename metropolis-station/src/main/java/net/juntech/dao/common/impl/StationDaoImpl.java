package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.IStationDao;

/**
 * <ul>
 * <li>GQG 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class StationDaoImpl implements IStationDao{
	@Autowired
	private NamedParameterJdbcTemplate template;
	@Override
	public List<Map<String, Object>> selectStationByLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM t_station_info s WHERE 1=1 and display = 0 ");
		if(params.get("lineCode") != null && !"".equals(params.get("lineCode"))){
			sql.append("  and s.lineCode=:lineCode");
		}
		if(params.get("stationCode") != null && !"".equals(params.get("stationCode"))){
			sql.append("  and s.stationCode=:stationCode");
		}
		if(params.get("seq") != null && !"".equals(params.get("seq"))){
			sql.append("  and s.seq=:seq");
		}
		sql.append(" ORDER BY s.seq desc");
		if(params.get("lineCode") != null && !"".equals(params.get("lineCode"))){
			params.put("lineCode", params.get("lineCode"));
		}
		if(params.get("stationCode") != null && !"".equals(params.get("stationCode"))){
			params.put("stationCode", params.get("stationCode"));
		}
		if(params.get("seq") != null && !"".equals(params.get("seq"))){
			params.put("seq", params.get("seq"));
		}
		return template.queryForList(sql.toString(), params);
	}
	@Override
	public int insertStationByLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("lineCode", params.get("lineCode"));
		params.put("stationCode", params.get("stationCode"));
		params.put("stationName", params.get("stationName"));
		params.put("stationEName", params.get("stationEName"));
		params.put("extraLineCode", params.get("extraLineCode"));
		String sql="insert into t_station_info (stationCode,stationName,stationEName,lineCode,extraLineCode,display) values(:stationCode,:stationName,:stationEName,:lineCode,:extraLineCode,0)";
		return template.update(sql, params);
	}
	@Override
	public int deleteStationByLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("update t_station_info set display = 1 where 1=1 ");
		if(params.get("seq") != null && !"".equals(params.get("seq"))){
			sql.append(" and seq=:seq");
		}
		if(params.get("lineCode") != null && !"".equals(params.get("lineCode"))){
			sql.append(" and lineCode=:lineCode");
		}
		params.put("seq", params.get("seq"));
		params.put("lineCode", params.get("lineCode"));
		return template.update(sql.toString(), params);
	}
	@Override
	public List<Map<String, Object>> selectStationAndLine(Map<String, Object> params) {
		// TODO Auto-generated method stub
		String sql="select st.seq AS seq,st.stationCode AS stationCode,t.stationName AS stationName,GROUP_CONCAT(DISTINCT t.lineName ORDER BY t.lineName,',') AS lineList from t_station_info st "
				+ " LEFT JOIN (select l.lineName,s.stationName  from t_station_info s,t_line_info l where l.lineCode =s.lineCode) as t on st.stationName = t.stationName"
				+ " GROUP BY st.stationName ORDER BY seq ASC ";
		return template.queryForList(sql, params);
	}
	@Override
	public List<Map<String, Object>> selectStationByName(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("stationCode", params.get("stationCode"));
		String sql="select * from t_station_info where display = 0 and stationCode =:stationCode";
		return template.queryForList(sql, params);
	}
	@Override
	public int updateStation(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("seq", params.get("seq"));
		params.put("lineCode", params.get("lineCode"));
		params.put("stationCode", params.get("stationCode"));
		params.put("stationName", params.get("stationName"));
		String sql="update t_station_info set lineCode=:lineCode,stationCode =:stationCode，stationName =:stationName  where seq =:seq";
		return template.update(sql, params);
	}

}
