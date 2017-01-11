package net.juntech.dao.common.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.ICommonDao;

/**
 * 数据持久操作实现
 * 
 * @author xhl
 *
 */
@Repository
public class CommonDaoImpl implements ICommonDao {

	private static Log log = LogFactory.getLog(CommonDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * 获取数据库时间
	 * 
	 * @return Date 返回一个Date类型的日期(yyyy-MM-dd hh:MM:ss:sss);
	 * 
	 */
	@Override
	public Date selectDBTime() {
		Date date = namedParameterJdbcTemplate.queryForObject("select now()", new MapSqlParameterSource(), Date.class);
		log.debug("当前数据库系统时间：" + date);
		return date;
	}

	@Override
	public int insert(Map<String, Object> param, String tableName) {
		StringBuffer sql = sqlInsert(param, tableName);
		log.debug("sql:" + sql + " param:" + param);
		int row = 0;
		try {
			row = namedParameterJdbcTemplate.update(sql.toString(), param);
		} catch (Exception e) {
			log.error("数据添加失败");
			throw e;
		}
		return row;
	}

	@Override
	public int insertBatch(List<Map<String, Object>> params, String tableName) {
		// TODO Auto-generated method stub
		int err = 0;
		int row = 0;
		try {
			if (params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					StringBuffer sql = sqlInsert(params.get(i), tableName);
					int result = namedParameterJdbcTemplate.update(sql.toString(), params.get(i));
					if (result != 1) {
						err++;
					} else {
						row++;
					}
					log.debug("sql:" + sql + " param:" + params.get(i));
				}
			}
			log.debug("insert:" + row + ", error:" + err + "。");
		} catch (Exception e) {
			log.error("数据添加失败");
			throw e;
		}
		return row;
	}

	@Override
	public int update(Map<String, Object> param, String tableName) {
		StringBuffer sql = sqlUpdate(param, tableName);
		log.debug("sql:" + sql + " param:" + param);
		int row = 0;
		try {
			row = namedParameterJdbcTemplate.update(sql.toString(), param);
		} catch (Exception e) {
			log.error("数据修改失败");
			throw e;
		}
		return row;
	}

	@Override
	public int updateBatch(List<Map<String, Object>> params, String tableName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map<String, Object> param, String tableName) {
		StringBuffer sql = sqlDelete(param, tableName);
		log.debug("sql:" + sql + " param:" + param);
		int row = 0;
		try {
			row = namedParameterJdbcTemplate.update(sql.toString(), param);
		} catch (Exception e) {
			log.error("数据删除失败");
			throw e;
		}
		return row;
	}

	@Override
	public int deleteBatch(List<Map<String, Object>> params, String tableName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Map<String, Object>> select(Map<String, Object> param, String tableName, List<String> selectItems, String orderBy){
		StringBuffer sql = sqlSelect(param, tableName, selectItems, orderBy);
		log.debug("sql:" + sql + " param:" + param);
		List<Map<String, Object>> list = namedParameterJdbcTemplate.queryForList(sql.toString(), param);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> select(String selectSql, Map<String, Object> param) {
		log.debug("sql:" + selectSql + " param:" + param);
		List<Map<String, Object>> list = namedParameterJdbcTemplate.queryForList(selectSql, param);
		return list;
	}

	/**
	 * 拼接添加sql
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 *            添加的数据
	 * @param tableName
	 *            表名
	 * @return
	 */
	private static StringBuffer sqlInsert(Map<String, Object> param, String tableName) {
		StringBuffer sql = new StringBuffer(); // 完整sql
		StringBuffer keySql = new StringBuffer(); // 键sql
		StringBuffer valSql = new StringBuffer(); // 值sql

		Iterator<Entry<String, Object>> iterator = param.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> next = iterator.next();
			String key = next.getKey();
			keySql.append(" ").append(key.toLowerCase()).append(",");
			valSql.append(" :").append(key).append(",");
		}
		// 去除最后一个逗号（,）
		if (keySql != null && keySql.length() >= 0) {
			keySql.deleteCharAt(keySql.length() - 1);
		}
		if (valSql != null && valSql.length() >= 0) {
			valSql.deleteCharAt(valSql.length() - 1);
		}

		sql.append("INSERT INTO ").append(tableName);
		sql.append(" (").append(keySql).append(" )");
		sql.append(" VALUES(").append(valSql).append(" )");
		return sql;
	}

	/**
	 * 拼接修改sql
	 * <ul>
	 * <li>xhl 2016年12月26日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 *            添加的数据
	 * @param tableName
	 *            表名
	 * @return
	 */
	private StringBuffer sqlUpdate(Map<String, Object> param, String tableName) {
		StringBuffer sql = new StringBuffer(); // 完整sql
		StringBuffer condSql = new StringBuffer(); // 条件sql
		StringBuffer coluSql = new StringBuffer(); // 列sql
		if (param.get("pk") == null) {
			throw new IllegalArgumentException("缺少修改条件");
		}
		List<String> list = Arrays.asList(param.get("pk").toString().split(",")); // 条件key

		Iterator<String> iterator = param.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();

			if (key.equals("pk")) {
				continue;
			}

			if (list.contains(key)) {
				condSql.append(key).append("=:").append(key).append(" AND ");
			} else {
				coluSql.append(key).append("=:").append(key).append(",");
			}

		}

		// 去除最后一个逗号（,）
		if (coluSql != null && coluSql.length() >= 0) {
			coluSql.deleteCharAt(coluSql.length() - 1);
		}
		// 去除最后一个and连接符（AND）
		if (condSql != null && condSql.length() >= 0) {
			int lastIndexOf = condSql.toString().toLowerCase().lastIndexOf("and");
			condSql.delete(lastIndexOf, condSql.length());
		}

		sql.append("UPDATE ").append(tableName);
		sql.append(" SET ").append(coluSql);
		sql.append(" WHERE ").append(condSql);
		return sql;
	}

	private StringBuffer sqlDelete(Map<String, Object> param, String tableName) {
		StringBuffer sql = new StringBuffer(); // 完整sql
		StringBuffer condSql = new StringBuffer(); // 条件sql
		Iterator<String> iterator = param.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (key.equals("pk")) {
				continue;
			}
			condSql.append(key).append("=:").append(key).append(" AND ");
		}

		// 去除最后一个and连接符（AND）
		if (condSql != null && condSql.length() >= 0) {
			int lastIndexOf = condSql.toString().toLowerCase().lastIndexOf("and");
			condSql.delete(lastIndexOf, condSql.length());
		}
		sql.append("DELETE FROM ").append(tableName).append(" WHERE ").append(condSql);
		return sql;
	}
	
	private static StringBuffer sqlSelect(Map<String, Object> param, String tableName, List<String> selectItems, String orderBy) {
		StringBuffer sql = new StringBuffer(); // 完整sql
		StringBuffer condSql = new StringBuffer(); // 条件sql
		Iterator<String> iterator = param.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (key.equals("pk")) {
				continue;
			}
			condSql.append(key).append("=:").append(key).append(" AND ");
		}
		// 去除最后一个and连接符（AND）
		if (condSql != null && condSql.length() >= 0) {
			int lastIndexOf = condSql.toString().toLowerCase().lastIndexOf("and");
			condSql.delete(lastIndexOf, condSql.length());
		}
		sql.append("SELECT ");
		if (selectItems != null&&selectItems.size()>0) {
			sql.append(selectItems.toString().toString().replace("[", "").replace("]", ""));
		} else {
			sql.append(" * ");
		}
		sql.append(" FROM ").append(tableName).append(" WHERE ").append(condSql);
		if (orderBy != null && !"".equals(orderBy)) {
			sql.append(" ORDER BY ").append(orderBy);
		}
		System.out.println(sql);
		return sql;
	}
	


	/**
	 * 查询list
	 * <ul>
	 * <li>Dave 2016年12月29日 新建</li>
	 * </ul>
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryForList(String sql, Map<String, Object> params) {
		return this.namedParameterJdbcTemplate.queryForList(sql, params);
	}

	@Override
	public <T> T queryForObject(String sql, Map<String, Object> params, Class<T> c) {
		return this.namedParameterJdbcTemplate.queryForObject(sql, params, c);
	}

	@Override
	public Map<String, Object> queryForMap(String sql, Map<String, Object> params) {
		Map<String, Object> map = new HashMap<>();
		try {
			map = this.namedParameterJdbcTemplate.queryForMap(sql, params);
		} catch (EmptyResultDataAccessException e) {
			log.error("查询数据不存在");
			return null;
		}
		return map;
	}

	@Override
	public int updateById(Map<String, Object> param, String tableName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCount(StringBuffer sql, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}
}
