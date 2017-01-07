package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.odianyun.common.DateUtil;
import com.odianyun.soa.common.uuid.UUIDUtils;

import net.juntech.dao.common.IMessageDao;

/**
 * <ul>
 * <li>GQG 2016年12月31日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class MessageDaoImpl implements IMessageDao{
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	@Override
	public List<Map<String, Object>> selectMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from t_message where display = 0 ");
		List<Map<String, Object>> result =template.queryForList(sql.toString(), params);
		return result;
	}

	@Override
	public int insertMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("id", UUIDUtils.getUUID());
		params.put("author", UUIDUtils.getUUID());
		params.put("createTime", DateUtil.getFormatCurrentTime("yyyy-MM-dd"));
		String sql="insert into t_message (id,title,author,content,createTime) values(:id,:title,:author,:content,:createTime)";
		return template.update(sql, params);
	}

	@Override
	public int publishMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("seq", params.get("seq"));
		params.put("publishTime", DateUtil.getFormatCurrentTime("yyyy-MM-dd"));
		String sql = "update t_message set publish = 1,publishTime=:publishTime where seq =:seq";
		return template.update(sql, params);
	}

	@Override
	public Map<String, Object> selectMessageInfo(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		params.put("seq", params.get("seq"));
		sql.append(" select * from t_message where seq=:seq ");
		Map<String, Object> result =template.queryForMap(sql.toString(), params);
		return result;
	}

	@Override
	public int delMessage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("seq", params.get("seq"));
		String sql="update t_message set display = 1 where seq =:seq";
		return template.update(sql, params);
	}

}
