package net.juntech.util;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 图片
 * <ul>
 * <li>xhl 2016年5月6日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class ImageUtil {

	private static Log log = LogFactory.getLog(ImageUtil.class);

	/**
	 * TODO 未完善(无法使用) 设置图片完整路径(支持返回)，暂不支持二级循环(对象嵌套)
	 * <ul>
	 * <li>xhl 2016年5月6日 新建</li>
	 * </ul>
	 * 
	 * @param t
	 *            需要设置完整路径的对象(ps:user)
	 * @param key
	 *            需要设置的对象对应key(ps:userHeadImg)
	 * @return
	 */
	public static <T> T setImgFullPatn(T t, String... key) {
		if (null == t || key.length == 0) {
			log.error("参数错误");
			throw new IllegalArgumentException();
		}

		Class<?> clazz = null;
		try {
			clazz = Class.forName(t.getClass().getName());
		} catch (ClassNotFoundException e) {
			log.error(t.getClass() + "类未找到", e);
		}

		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			Class<?> type = method.getReturnType();
			// 判断是否是map
			if (Map.class.getName().equals(type.getName())) {

			}
		}

		return t;
	}

}
