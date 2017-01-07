package net.juntech.controller.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 异常处理
 * <ul>
 * <li>xhl 2016年5月13日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class ExceptionDeal {

	private static Log log = LogFactory.getLog(ExceptionDeal.class);

	/**
	 * 异常统一处理
	 * <ul>
	 * <li>xhl 2016年5月13日 新建</li>
	 * </ul>
	 * 
	 * @param exception
	 *            出现的异常
	 * @return
	 */
	public static Map<String, Object> exception(Exception exception) {
		Map<String, Object> map = new HashMap<>();
		String msg = exception.getMessage();

		log.error(exception);

		switch (exception.getClass().getSimpleName()) {
		case "IllegalArgumentException": // 参数不合法
			map = setExceptionInfo("01001", null == msg ? "参数不合法" : msg, "common/exception/IllegalArgumentException");
			break;
		case "NullPointerException": // 空指针
			map = setExceptionInfo("01002", null == msg ? "服务运行异常" : msg, "common/exception/NullPointerException");
			break;
		case "SizeLimitExceededException": // 文件大小超过限制
			map = setExceptionInfo("01003", null == msg ? "大小超过限制" : msg, "common/exception/SizeLimitExceededException");
			break;
		case "FileFormatException": // 文件格式不支持
			map = setExceptionInfo("01004", null == msg ? "文件格式不支持" : msg, "common/exception/FileFormatException");
			break;
		case "FileNotFoundException": // 文件不存在
			map = setExceptionInfo("01005", null == msg ? "文件不存在" : msg, "common/exception/FileNotFoundException");
			break;
		default: // 默认，缺少异常处理
			map = setExceptionInfo("01000", "请联系管理员", "common/error/500");
			break;

		}
		return map;
	}

	/**
	 * 设置异常返回消息
	 * <ul>
	 * <li>xhl 2016年5月13日 新建</li>
	 * </ul>
	 * 
	 * @param msg
	 *            返回字符串
	 * @param code
	 *            返回错误码
	 * @return
	 */
	private static Map<String, Object> setExceptionInfo(String code, String msg, String url) {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> json = new HashMap<>();

		json.put("code", code);
		json.put("msg", msg);
		result.put("json", json);
		result.put("url", url);
		return result;
	}

	public static void main(String[] args) {
		NullPointerException exception = new NullPointerException("参数不能为空");
		Map<String, Object> map = ExceptionDeal.exception(exception);
		System.err.println(map);
	}

}
