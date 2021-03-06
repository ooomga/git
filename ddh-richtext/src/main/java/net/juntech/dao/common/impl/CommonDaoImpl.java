package net.juntech.dao.common.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	private Log log = LogFactory.getLog(CommonDaoImpl.class);

	// springJDBC注入
	@Autowired
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * 获取数据库时间
	 * 
	 * @return Date 返回一个Date类型的日期(yyyy-MM-dd hh:MM:ss:sss);
	 * 
	 */
/*	@Override
	public Date selectDBTime() {
		return jdbcTemplate.queryForObject("select now()", Date.class);
	}*/

}
