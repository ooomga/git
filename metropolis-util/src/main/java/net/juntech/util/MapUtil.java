package net.juntech.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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

	// 重新装载sql搜索结果字段集
	public static List<String> mapToList(List<Map<String, Object>> mapList, String key, String asfield) {
		List<String> list = new ArrayList<>();
		if (mapList.size() > 0) { // list是否有内容
			for (int i = 0; i < mapList.size(); i++) { // 循环
				if (mapList.get(i).containsKey(key)) { // 验证是否有这个key
					if (asfield != null && !"".equals(asfield)) { // 是否有设置 AS 别名
						if (mapList.get(i).containsKey(key)) { // 是否有别名的字段
							// 组合结果集字段
							list.add("IFNULL("+mapList.get(i).get(key).toString()+ ",0.00)" + " AS " + mapList.get(i).get(asfield).toString());
						}
					} else { // 没有设置 AS 别名
						// 组合结果集字段
						list.add(mapList.get(i).get(key).toString());
					}
				}
			}
		}
		return list;
	}
}
