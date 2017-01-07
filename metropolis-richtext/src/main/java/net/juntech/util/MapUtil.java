package net.juntech.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * map
 * <ul>
 * <li>xhl 2016年5月16日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class MapUtil {

	/**
	 * map根据key排序，暂不支持map中包含map
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, Object> mapSequence(Map<String, Object> map) {
		Map<String, Object> result = new LinkedHashMap<>();
		Object[] array = map.keySet().toArray();
		Arrays.sort(array);
		for (Object key : array) {
			result.put(key.toString(), map.get(key));
		}
		return result;
	}

}
