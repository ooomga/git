package net.juntech.dao.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.odianyun.common.DateUtil;
import com.odianyun.soa.common.uuid.UUIDUtils;

import net.juntech.dao.common.INoticeDao;

/**
 * <ul>
 * <li>GQG 2017年1月3日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class NoticeDaoImpl implements INoticeDao{

	@Autowired
	private NamedParameterJdbcTemplate template;
	@Override
	public int insertNotice(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("id", UUIDUtils.getUUID());
		params.put("author", UUIDUtils.getUUID());
		params.put("createTime", DateUtil.getFormatCurrentTime("yyyy-MM-dd"));
		String sql="insert into t_notice (id,title,author,content,createTime,noticeType,send_object,nodeType,is_send) values(:id,:title,:author,:content,:createTime,:noticeType,:send_object,:nodeType,:is_send)";
		return template.update(sql, params);
	}

	@Override
	public int editNotice(Map<String, Object> params) {
		// TODO Auto-generated method stub
		params.put("id", params.get("id"));
		String sql="update t_notice set title=:title,content=:content where id=:id";
		return template.update(sql, params);
	}

	@Override
	public List<Map<String, Object>> selectNoticeMaster(Map<String,Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from t_notice_master ");
		List<Map<String, Object>> result =template.queryForList(sql.toString(), params);
		return result;
	}

	@Override
	public List<Map<String, Object>> selectNotice(Map<String, Object> params) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		params.put("noticeType", params.get("noticeType"));
		params.put("nodeType", params.get("nodeType"));
		sql.append("select n.id as id,n.title AS title,n.content as content,m.node as node,m.disable as disable from t_notice n,t_notice_master m where n.nodeType=m.nodeType and n.noticeType =:noticeType and m.nodeType =:nodeType ");
		List<Map<String, Object>> result =template.queryForList(sql.toString(), params);
		return result;
	}

}
