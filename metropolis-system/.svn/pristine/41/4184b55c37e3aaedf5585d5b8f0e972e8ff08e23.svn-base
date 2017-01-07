package net.juntech.service.member.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.juntech.constant.PageConstant;
import net.juntech.dao.common.ICommonDao;
import net.juntech.service.base.BaseService;
import net.juntech.service.member.IMemberService;
import net.juntech.util.DataUtil;
import net.juntech.util.GradeUtil;

/**
 * <ul>
 * <li>Dave 2017年1月3日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Service
public class MemberServiceImpl extends BaseService implements IMemberService {
	
	private static Log log = LogFactory.getLog(MemberServiceImpl.class);

	@Autowired
	private ICommonDao commonDao;

	@Override
	public Map<String, Object> getMemberList(Map<String, Object> params) {
		log.info("getMemberList:"+params.toString());
		this.init(params);
		StringBuffer sql = new StringBuffer("SELECT ur.id,ur.seq,ur.account,ur.source,ur.registTime,ur.status,ur.type,")
				.append(" ud.name,ud.mobile,ud.wechat,ud.maiho,ud.QQ,ud.score,ud.balance ")
				.append(" FROM t_user_basis ur ")
				.append(" LEFT JOIN t_user_deatil ud ")
				.append("  ON ur.id=ud.userId WHERE ur.display=0 ");
		if(DataUtil.isNotEmpty(params, "status")){
			sql.append(" and ur.status=:status ");
		}
		if(DataUtil.isNotEmpty(params, "account")){
			params.put("account", params.get("account").toString()+"%");
			sql.append(" and ur.account like :account ");
		}

		if(DataUtil.isNotEmpty(params, "name")){
			params.put("name", params.get("name").toString()+"%");
			sql.append(" and ud.name like :name ");
		}
		if(DataUtil.isNotEmpty(params, "type")){
			sql.append(" and ur.type=:type ");
		}
		if(DataUtil.isNotEmpty(params, "mobile")){
			sql.append(" and ud.mobile=:mobile ");
		}
		if(DataUtil.isNotEmpty(params, "source")){
			sql.append(" and ur.source=:source ");
		}
		
		if(DataUtil.isNotEmpty(params, "level")){
			Integer[] scoreRange = GradeUtil.scoreRange(params.get("level").toString());
			if(scoreRange!=null){
				sql.append(" and ud.score> :minscore  ");
				params.put("minscore", scoreRange[0]);
				if(scoreRange[1]!=null){
					sql.append(" and ud.score<= :maxscore  ");
					params.put("maxscore", scoreRange[1]);
				}
			}
		}
		if(DataUtil.isNotEmpty(params, "beginTime")){
			sql.append(" and ur.registTime>=:beginTime ");
		}
		if(DataUtil.isNotEmpty(params, "endTime")){
			sql.append(" and ur.registTime<=:endTime ");
		}
		
		if (!params.containsKey(PageConstant.ORDER_BY)) {
			sql.append(" order by ur.registTime desc ");
		}
		this.sqlBuild(sql, params);
		
		this.list = commonDao.queryForList(sql.toString(),params);
		GradeUtil.processGradeLevel(list,"level");
		this.totalRecords = commonDao.selectCount(sql, params);
		return result();
	}

	@Override
	public Map<String, Object> saveMember(Map<String, Object> params) {
		log.info("saveMember:"+params.toString());
		int insert = commonDao.insert(params, "t_user_basis");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", insert);
		boolean isSuccess = insert>0?true:false;
		resultMap.put("success", isSuccess);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> updateMember(Map<String, Object> params) {
		log.info("updateMember:"+params.toString());
		int row = commonDao.updateById(params, "t_user_basis");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", row);
		boolean isSuccess = row>0?true:false;
		resultMap.put("success", isSuccess);
		return resultMap;
	}

	@Override
	public Map<String, Object> delMember(Map<String, Object> param) {
		log.info("delMember:"+param.toString());
		int row = commonDao.delete(param,  "t_user_basis");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", row);
		boolean isSuccess = row>0?true:false;
		resultMap.put("success", isSuccess);
		return resultMap;
	}

	@Override
	public Map<String, Object> getMemberInfo(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer("SELECT ur.id,ur.account,ur.registTime,ur.status,ur.type,ur.modifyTime,")
				.append(" ud.mobile,ud.wechat,ud.maiho,ud.QQ ")
				.append(" FROM t_user_basis ur ")
				.append(" LEFT JOIN t_user_deatil ud ")
				.append("  ON ur.id=ud.userId WHERE ur.display=0 and ur.id=:id ");
		return commonDao.queryForMap(sql.toString(), params);
	}


}
