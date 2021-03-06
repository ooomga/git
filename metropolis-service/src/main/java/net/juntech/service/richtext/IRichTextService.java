package net.juntech.service.richtext;

import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月25日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IRichTextService {
	
	//查询资讯分页数据
	public Map<String,Object>  getRichTextList(Map<String,Object> params);
	//保存资讯信息
	public Map<String,Object>  saveRichText(Map<String,Object> params);
	//逻辑删除
	public Map<String, Object> delRichText(Map<String, Object> param);
	//修改资讯信息
	Map<String, Object> updateRichText(Map<String, Object> params);
	//获取资讯信息
	Map<String, Object> getRichTextInfo(Map<String, Object> params);
	//获取资讯类型
	List<Map<String, Object>> getRichTextTypes(Map<String, Object> params);
	//发布资讯
	public void publishRichText(Map<String, Object> param);

}
