package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.ICommonDao;
import net.juntech.dao.common.IWagesDao;
import net.juntech.util.OracleDbUtil;

/**
 * <ul>
 * <li>ZX 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class WagesDaoImpl implements IWagesDao {

	@Autowired
	private static Log log = LogFactory.getLog(WagesDaoImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private ICommonDao commonDao;
	
	@Override
	public List<Map<String, Object>> selectWagesAll() {
//		String sql = "select * from OIM_OIM.iamusers";
//		long systime = System.currentTimeMillis();
//		System.out.println(systime);
//		List<Map<String, Object>> list = OracleDbUtil.getStaffCompanyList(sql);
//		System.out.println(System.currentTimeMillis() - systime);
//		return list;
		return null;
	}

	@Override
	public Map<String, Object> selectWagesDetail(String date, String staffCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectWagesGeneral(String date, String staffCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> checkWagesItems() {
		// TODO Auto-generated method stub
		String sql = "describe t_wages_data :columnname ";
		commonDao.queryForMap(sql, null);
		return null;
	}
}
