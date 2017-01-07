package net.juntech.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <ul>
 * <li>GQG 2017年1月3日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public interface INoticeDao {
	//查询消息模版
	public List<Map<String,Object>> selectNotice(Map<String,Object> params);
	//消息master
	public List<Map<String,Object>> selectNoticeMaster(Map<String,Object> params);
	//添加发送
	public int insertNotice(Map<String,Object> params);
	//编辑模版
	public int editNotice(Map<String,Object> params);
}
