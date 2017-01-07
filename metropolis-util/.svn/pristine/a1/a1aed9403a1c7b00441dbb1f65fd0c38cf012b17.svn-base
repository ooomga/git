package net.juntech.util;

import java.util.List;
import java.util.Map;

/**
 * 积分
 * <ul>
 * <li>xhl 2017年1月2日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class GradeUtil {

	public static String scoreGrade(Object score) {

		if (score == null) {
			return "V0";
		}

		int sc = Integer.parseInt(score.toString());
		if (sc > 1600) {
			return "V4";
		} else if (sc > 800) {
			return "V3";
		} else if (sc > 400) {
			return "V2";
		} else if (sc > 100) {
			return "V1";
		} else {
			return "V0";
		}
	}
	
	public static Integer[] scoreRange(String level){
		Integer [] ranges = {};
		if(level==null||"".equals(level)){
			return null;
		}
		if("V0".equals(level)){
			ranges = new Integer[]{0,100};
		}else if("V1".equals(level)){
			ranges = new Integer[]{100,400};
		}else if("V2".equals(level)){
			ranges = new Integer[]{400,800};
		}else if("V3".equals(level)){
			ranges = new Integer[]{800,1600};
		}else if("V4".equals(level)){
			ranges = new Integer[]{1600,null};
		}
		return ranges;
	}

	public static void processGradeLevel(List<Map<String, Object>> list, String newKey) {
		if(list!=null&&list.size()>0){
			for(Map<String,Object> map:list){
				map.put(newKey, scoreGrade(map.get("score")));
			}
		}
	}

}
