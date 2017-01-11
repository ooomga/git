package net.juntech.service.score.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.juntech.dao.common.ICommonDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.user.IScoreService;
import net.juntech.util.DateUtil;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>xhl 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class ScoreServiceImpl extends BaseService implements IScoreService {

	@Autowired
	private ICommonDao commonDao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertScore(Map<String, Object> params) {
		params.remove("uuid");
		params.put("id", UuidUtil.generateUuid());
		params.put("createDate", new Date());
		int row = commonDao.insert(params, "t_score");

		Map<String, Object> map = commonDao.queryForMap("select score from t_user_deatil where userId = :userId", params);
		Map<String, Object> userParam = new HashMap<>();
		if ("0".equals(params.get("type").toString())) {
			userParam.put("score", Integer.parseInt(map.get("score").toString()) - Integer.parseInt(params.get("score").toString()));
		} else {
			userParam.put("score", Integer.parseInt(map.get("score").toString()) + Integer.parseInt(params.get("score").toString()));
		}
		userParam.put("userId", params.get("userId"));
		userParam.put("pk", "userId");
		commonDao.update(userParam, "t_user_deatil");

		return row;
	}

	@Override
	public Map<String, Object> selectScoreList(Map<String, Object> params) {
		this.init(params);
		params.remove("uuid");
		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_score where userId = :userId");
		this.sqlBuild(sql, params);
		this.list = commonDao.queryForList(sql.toString(), params);
		this.totalRecords = commonDao.selectCount(sql, params);
		return result();
	}

	@Override
	public List<Map<String, Object>> selectScoreForCheckIn(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer();
		long start = DateUtil.getDateStart(new Date()); // 获取今天的开始时间
		sql.append("SELECT * FROM t_score WHERE source = 1 and createDate > '");
		sql.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(start))).append("'");
		sql.append(" and userId = :userId");
		return commonDao.queryForList(sql.toString(), params);
	}

}
