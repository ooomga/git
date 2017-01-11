package net.juntech.service.address.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.user.IAddressService;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>xhl 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class AddressServiceImpl extends BaseService implements IAddressService {

	@Autowired
	private ICommonDao commonDao;

	@Override
	public List<Map<String, Object>> selectAddressListAll(Map<String, Object> params) {
		params.remove("uuid");
		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_address where userId = :userId");
		return commonDao.queryForList(sql.toString(), params);
	}

	@Override
	public int insertAddress(Map<String, Object> params) {
		params.remove("uuid");
		if (isNull(params.get("home"))) {
			params.put("home", 1);
		}
		params.put("id", UuidUtil.generateUuid());
		int row = commonDao.insert(params, "t_address");
		return row;
	}

	@Override
	public int deleteAddress(Map<String, Object> params) {
		params.remove("uuid");
		params.put("pk", "id,userId");
		int row = commonDao.delete(params, "t_address");
		return row;
	}

}
