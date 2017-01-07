package net.juntech.service.test.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.dao.common.ICommonDao;
import net.juntech.dao.mapper.UserEntityMapper;
import net.juntech.entity.UserEntity;
import net.juntech.entity.UserEntityCriteria;
import net.juntech.entity.UserEntityCriteria.Criteria;
import net.juntech.service.base.BaseService;
import net.juntech.service.test.IUserService;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>xhl 2016年10月21日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

	@Autowired
	private UserEntityMapper userEntityMapper;
	@Autowired
	private ICommonDao commonDaoImpl;

	/**
	 * 对分页信息和排序处理（提供通用方法）
	 * <ul>
	 * <li>xhl 2016年6月23日 新建</li>
	 * </ul>
	 * 
	 * @param criteria
	 * @param param
	 */
	private void select(UserEntityCriteria criteria, Map<String, Object> param) {

		if (param.containsKey("orderBy")) {
			criteria.setOrderByClause(param.get("orderBy").toString());
		}

		if (isPage) {
			criteria.setLimitStart((pageIndex - 1) * pageSize);
			criteria.setLimitEnd(pageSize);
		}

		list = userEntityMapper.selectByExample(criteria);

		if (super.isPage) {
			totalRecords = userEntityMapper.countByExample(criteria);
		}
	}

	@Override
	public int saveUser(UserEntity userEntity) {
		int row = 0;
		if (null == userEntity.getId() || "".equals(userEntity.getId())) {
			userEntity.setId(UuidUtil.generateUuid());
			row = userEntityMapper.insertSelective(userEntity);
		} else {
			row = userEntityMapper.updateByPrimaryKeySelective(userEntity);
		}
		return row;
	}

	@Override
	public Map<String, Object> selectUserList(Map<String, Object> param) {
		super.init(param);
		UserEntityCriteria criteria = new UserEntityCriteria();
		Criteria createCriteria = criteria.createCriteria();

		if (null != param.get("name") && !"".equals(param.get("name"))) {
			createCriteria.andNameLike(param.get("name").toString());
		}

		select(criteria, param);
		return result();
	}

	@Override
	public List<UserEntity> selectUserAllList(Map<String, Object> param) {
		UserEntityCriteria criteria = new UserEntityCriteria();
		Criteria createCriteria = criteria.createCriteria();

		if (null != param.get("name") && !"".equals(param.get("name"))) {
			createCriteria.andNameLike(param.get("name").toString());
		}

		List<UserEntity> userEntities = userEntityMapper.selectByExample(criteria);
		return userEntities;
	}

	@Override
	public UserEntity selectUser(Map<String, Object> param) {
		UserEntity entity = userEntityMapper.selectByPrimaryKey(param.get("id").toString());
		return entity;
	}

	@Override
	public int deleteUser(String ids) {
		String[] split = ids.split(",");
		int row = 0;
		for (String id : split) {
			row += userEntityMapper.deleteByPrimaryKey(id);
		}

		return row;
	}

	@Override
	public Date selectDBDate() {
//		Date date = commonDaoImpl.selectDBTime();
		Date date = new Date();
		return date;
	}

}
