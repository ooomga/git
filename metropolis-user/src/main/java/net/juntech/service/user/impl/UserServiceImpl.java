package net.juntech.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.juntech.dao.common.ICommonDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.user.IUserService;
import net.juntech.util.GradeUtil;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>xhl 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

	@Autowired
	private ICommonDao commonDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertUser(Map<String, Object> param) {
		param.put("id", UuidUtil.generateUuid());
		param.put("display", 0);
		param.put("status", "normal");
		param.put("registTime", new Date());
		param.put("type", "1");
		int row = commonDao.insert(param, "t_user_basis");
		// 添加用户详细信息
		Map<String, Object> detail = new HashMap<>();
		detail.put("userId", param.get("id"));
		detail.put("headImg", "/resources/develop/image/defult/head_default.jpg");
		commonDao.insert(detail, "t_user_deatil");
		return row;
	}

	@Override
	public int updateUser(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
		map.put("account", param.get("account"));
		map.put("password", param.get("password"));
		map.put("display", 0);
		map.put("pk", "account,display");
		int row = commonDao.update(map, "t_user_basis");
		return row;
	}

	@Override
	public Map<String, Object> selectUser(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer();
		sql.append("select id,account,password,status,type,registTime,display FROM t_user_basis where 1 = 1");
		sql.append(" id = :id ");
		Map<String, Object> map = commonDao.queryForMap(sql.toString(), param);
		return map;
	}

	@Override
	public Map<String, Object> selectUserByAccount(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer();
		sql.append("select id,account,password,status,type,registTime FROM t_user_basis where 1 = 1");
		sql.append(" and account = :account ");
		sql.append(" and display = 0");
		Map<String, Object> map = commonDao.queryForMap(sql.toString(), param);

		if (!isNull(map)) {
			StringBuffer sqlDetail = new StringBuffer();
			sqlDetail.append("select headImg,score from t_user_deatil where 1 =1");
			sqlDetail.append(" and  userId = :id");
			Map<String, Object> mapDetail = commonDao.queryForMap(sqlDetail.toString(), map);
			mapDetail.put("grade", GradeUtil.scoreGrade(mapDetail.get("score")));
			map.putAll(mapDetail);
			if ("2".equals(map.get("type"))) {
				sql.append("SELECT sc.usrLogin AS psnCode,sc.usrUdfCompanyId AS companyCode,sc.usrUdfDeptId AS deptCode,sc.partyFlag AS partyFlag,sc.usrEmpNo AS usrOrdEmpNo,sc.usrUdfCompanyName AS companyName,sc.usrUdfDeptName AS deptName, pb.partyBranchCode AS partyBranchCode, pb.partyBranchName AS partyBranchName FROM t_staff_company sc LEFT JOIN t_party_branch pb ON sc.usrUdfDeptId = pb.deptCode WHERE sc.id=:id");
				Map<String, Object> staffMap = commonDao.queryForMap(sql.toString(), map);
				map.putAll(staffMap);
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> selectUserList(Map<String, Object> param) {
		this.init(param);
		StringBuffer sql = new StringBuffer();
		this.sqlBuild(sql, param);
		this.list = commonDao.queryForList(sql.toString(), param);
		this.totalRecords = commonDao.selectCount(sql, param);
		return result();
	}

	@Override
	public Map<String, Object> selectScore(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ud.score FROM t_user_basis ub LEFT JOIN t_user_deatil ud ON ub.id = ud.userId  WHERE ud.userId = :userId");
		return commonDao.queryForMap(sql.toString(), params);
	}

}
