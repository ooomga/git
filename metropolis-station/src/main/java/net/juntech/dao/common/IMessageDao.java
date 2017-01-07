package net.juntech.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * <ul>
 * <li>GQG 2016年12月31日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Repository
public interface IMessageDao {
	
	//查询公示信息
	public List<Map<String,Object>> selectMessage(Map<String,Object> params);
	//新增
	public int insertMessage(Map<String,Object> params);
	//发布信息
	public int publishMessage(Map<String,Object> params);
	//查询信息内容
	public Map<String,Object> selectMessageInfo(Map<String,Object> params);
	//逻辑删除
	public int delMessage(Map<String,Object> params);

}
