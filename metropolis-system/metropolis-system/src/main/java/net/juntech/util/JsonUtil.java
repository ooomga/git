package net.juntech.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * json对象操作工具
 * 
 * <ul>
 * <li>xhl 2016年5月6日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class JsonUtil {

	private static Log log = LogFactory.getLog(JsonUtil.class);

	/**
	 * json 转 对象(字符串中""不替换)
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @param json
	 *            转换的json字符串
	 * @param t
	 *            转换后的对象
	 * @return
	 * @throws IOException
	 */
	public static <T> T jsonToObj(String json, Class<T> t) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(json, t);
		} catch (IOException e) {
			log.error("json转对象失败");
			throw e;
		}
	}

	/**
	 * json转对象(字符串中的""替换为null)
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @param json
	 *            转换的json字符串
	 * @param t
	 *            转换后的对象
	 * @return
	 * @throws IOException
	 */
	public static <T> T jsonToObjTrim(String json, Class<T> t) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(json.replaceAll(":\"\"", ":null"), t);
		} catch (IOException e) {
			log.error("json转对象失败");
			throw e;
		}
	}

}
