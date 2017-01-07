package net.juntech.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.juntech.util.ObjectUtil;

/**
 * <ul>
 * <li>xhl 2016年12月30日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class Temp {
	
	public static void main(String[] args) throws IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("account", "12414");
		map.put("password", "111111");
		System.err.println(ObjectUtil.objToJson(map));
	}

}
