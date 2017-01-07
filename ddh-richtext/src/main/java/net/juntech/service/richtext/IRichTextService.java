package net.juntech.service.richtext;

import java.util.Map;

/**
 * <ul>
 * <li>Dave 2016年12月25日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public interface IRichTextService {

	/**
	 * 保存富文本信息
	 * 
	 * @param params 数据
	 * @return
	 */
	Map<String, Object> insertRichText(Map<String, Object> params);

	Map<String, Object> searchRichTextById(Map<String, Object> params);

}
