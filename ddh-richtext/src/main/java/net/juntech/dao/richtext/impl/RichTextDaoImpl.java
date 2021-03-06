package net.juntech.dao.richtext.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import net.juntech.dao.common.impl.CommonDaoImpl;
import net.juntech.dao.richtext.RichTextDao;
import net.juntech.util.UuidUtil;

/**
 * <ul>
 * <li>Dave 2016年12月25日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public class RichTextDaoImpl  extends CommonDaoImpl implements RichTextDao {

	private Log log = LogFactory.getLog(RichTextDaoImpl.class);
	
	@Override
	public Integer insertRichText(Map<String, Object> params) {
		params.put("id", UuidUtil.generateUuid());
		log.info("insertRichText:"+params);
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		SqlParameterSource sqlSource = new MapSqlParameterSource(params);
		String sql = " insert into t_rich_text (id,title,author,content,type)  values(:id,:title,:author,:content,:type)  ";
		log.info("sql:"+sql);
		return  this.jdbcTemplate.update(sql, sqlSource, keyHolder);
	}

	@Override
	public Map<String, Object> searchRichTextById(Map<String, Object> params) {
		log.info("params:"+params.toString());
		String sql = "select id,title,content,author,type,createTime from t_rich_text where id=:id ";
		return jdbcTemplate.queryForMap(sql, params);
	}
	

}
