package net.juntech.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

/**
 * 对象操作
 * <ul>
 * <li>xhl 2016年5月6日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class ObjectUtil {

	private static Log log = LogFactory.getLog(Object.class);

	/**
	 * 对象转json字符串(不替换null)
	 * <ul>
	 * <li>xhl 2016年5月6日 新建</li>
	 * </ul>
	 * 
	 * @param jsonObj
	 *            需要转换的json格式对象
	 * @return
	 * @throws IOException
	 */
	public static String objToJson(Object jsonObj) throws IOException {

		if (null == jsonObj) {
			log.error("jsonObj is null");
			return null;
		}
		CustomDateMapper mapper = new CustomDateMapper();

		try {
			String json = mapper.writeValueAsString(jsonObj);
			return json;
		} catch (IOException e) {
			log.error("对象转json出现错误", e);
			throw e;
		}
	}

	/**
	 * 对象转json字符串(将null替换为"")
	 * <ul>
	 * <li>xhl 2016年5月16日 新建</li>
	 * </ul>
	 * 
	 * @param jsonObj
	 * @return
	 * @throws IOException
	 */
	public static String objToJsonTrim(Object jsonObj) throws IOException {

		if (null == jsonObj) {
			log.error("jsonObj is null");
			return null;
		}
		CustomDateMapper mapper = new CustomDateMapper();

		try {
			return mapper.writeValueAsString(jsonObj).replaceAll("(:null|:NULL)", ":\"\"");
		} catch (IOException e) {
			log.error("对象转json出现错误", e);
			throw e;
		}
	}
	
	/**
	 * 判断未知对象不为空
	 * <ul>
	 * <li>xhl 2016年6月23日 新建</li>
	 * </ul>
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		} else if (o instanceof Collection<?>) {
			if (((Collection<?>) o).isEmpty()) {
				return true;
			}
		} else if (o instanceof String) {
			if (((String) o).trim().length() <= 0 || "undefined".equals(((String) o).trim())) {
				return true;
			}
		} else if (o instanceof Map<?, ?>) {
			if (((Map<?, ?>) o).isEmpty()) {
				return true;
			}
		} else if (o.getClass().isArray()) {
			if (Array.getLength(o) <= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @Description Object 对象转换为map对象
	 * @date 2016年1月14日
	 * @author schoff xhlim@outlook.com
	 * @param entity
	 *            实体对象
	 * @return map集合
	 * @throws Exception
	 *             对象实例化失败,值封装失败
	 * 
	 * @version 1.0 支持bean对象
	 */
	public static Map<String, Object> objToMap(Object entity, String dateFormat) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (entity == null) {
			return null;
		}

		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(entity.getClass());
		} catch (IntrospectionException e) {
			log.error("bean对象" + entity.getClass().getName() + "实例化失败");
			throw e;
		}

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor descriptor : propertyDescriptors) {
			String key = descriptor.getName();
			Object value = null;
			if (!key.equals("class")) {
				try {
					// 使用get方法获取值
					value = descriptor.getReadMethod().invoke(entity, new Object[0]);
					if (value instanceof Date) {
						if (null == dateFormat || "".equals(dateFormat.trim())) {
							value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss").format(value);
						} else {
							value = new SimpleDateFormat(dateFormat).format(value);
						}
					}
					map.put(key, value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					log.error(descriptor.getReadMethod().getName() + "(" + descriptor.getPropertyType().getName() + ") " + "方法调用失败,可能是类型不匹配");
					throw e;
				}
			}
		}
		return map;
	}

	/**
	 * 对象转map不自动格式时间
	 * <ul>
	 * <li>xhl 2016年7月7日 新建</li>
	 * </ul>
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objToMapNotFormaDate(Object entity) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (entity == null) {
			return null;
		}

		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(entity.getClass());
		} catch (IntrospectionException e) {
			log.error("bean对象" + entity.getClass().getName() + "实例化失败");
			throw e;
		}

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor descriptor : propertyDescriptors) {
			String key = descriptor.getName();
			Object value = null;
			if (!key.equals("class")) {
				try {
					// 使用get方法获取值
					value = descriptor.getReadMethod().invoke(entity, new Object[0]);
					map.put(key, value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					log.error(descriptor.getReadMethod().getName() + "(" + descriptor.getPropertyType().getName() + ") " + "方法调用失败,可能是类型不匹配");
					throw e;
				}
			}
		}
		return map;
	}

	/**
	 * 单个对象转换为map
	 * <ul>
	 * <li>xhl 2016年7月1日 新建</li>
	 * </ul>
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objToMap(Object entity) throws Exception {

		return objToMap(entity, null);
	}

	/**
	 * list 对象转listMap
	 * <ul>
	 * <li>xhl 2016年7月1日 新建</li>
	 * </ul>
	 * 
	 * @param entitys
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> listObjToMap(List<? extends Object> entitys) throws Exception {

		return listObjToMap(entitys, null);
	}

	public static List<Map<String, Object>> listObjToMap(List<? extends Object> entitys, String dateFormat) throws Exception {
		if (entitys.isEmpty()) {
			if (log.isDebugEnabled()) {
				log.debug("数据为空");
			}
			entitys = new ArrayList<>();
		}

		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		for (Object obj : entitys) {
			Map<String, Object> map = objToMap(obj, dateFormat);
			results.add(map);
		}
		return results;
	}
	
	public static void main(String[] args) {
		System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss").format(new Date()));
	}

}

/**
 * 解决date类型返回json格式为自定义格式
 * 
 * @author xhl
 *
 */
class CustomDateMapper extends ObjectMapper {

	public CustomDateMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jsonGenerator.writeString(sdf.format(value));
			}
		});
		this.setSerializerFactory(factory);
	}
}
