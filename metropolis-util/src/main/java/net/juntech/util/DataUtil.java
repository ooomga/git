package net.juntech.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

/**
 * <ul>
 * <li>Dave 2016年7月5日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class DataUtil {

	/**
	 * 正则表达式：是否正整数
	 */
	public static final String REGEX_NUMBER = "^\\d+$";
	/**
	 * 正则表达式：验证用户名
	 */
	public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

	/**
	 * 正则表达式：验证密码
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE =
	// "^((\\+86)|(86))?[1][3456789][0-9]{9}$";
	"^((\\+86)|(86))?(((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8})$";

	/**
	 * 正则表达式：验证邮箱
	 */
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 正则表达式：验证汉字
	 */
	public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

	/**
	 * 正则表达式：验证身份证
	 */
	public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

	/**
	 * 正则表达式：验证URL
	 */
	public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	/**
	 * 正则表达式：验证IP地址
	 */
	public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

	/**
	 * 校验用户名
	 * 
	 * @param username
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isUsername(String username) {
		return Pattern.matches(REGEX_USERNAME, username);
	}

	/**
	 * 校验用户名
	 * 
	 * @param username
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isNumber(String number) {
		return Pattern.matches(REGEX_NUMBER, number);
	}

	/**
	 * 校验密码
	 * 
	 * @param password
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isPassword(String password) {
		return Pattern.matches(REGEX_PASSWORD, password);
	}

	/**
	 * 校验手机号
	 * 
	 * @param mobile
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isMobile(String mobile) {
		return Pattern.matches(REGEX_MOBILE, mobile);
	}

	/**
	 * 校验邮箱
	 * 
	 * @param email
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isEmail(String email) {
		return Pattern.matches(REGEX_EMAIL, email);
	}

	/**
	 * 校验汉字
	 * 
	 * @param chinese
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isChinese(String chinese) {
		return Pattern.matches(REGEX_CHINESE, chinese);
	}

	/**
	 * 校验身份证
	 * 
	 * @param idCard
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isIDCard(String idCard) {
		return Pattern.matches(REGEX_ID_CARD, idCard);
	}

	/**
	 * 校验URL
	 * 
	 * @param url
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isUrl(String url) {
		return Pattern.matches(REGEX_URL, url);
	}

	/**
	 * 校验IP地址
	 * 
	 * @param ipAddr
	 * @return
	 */
	public static boolean isIPAddr(String ipAddr) {
		return Pattern.matches(REGEX_IP_ADDR, ipAddr);
	}

	public static boolean isNotEmpty(Map map, String key) {
		return !isEmpty(map, key);
	}

	public static boolean isEmpty(Map map, String key) {
		if (map.containsKey(key)) {
			Object obj = map.get(key);
			return obj == null || (obj instanceof String && "".equals(obj));
		} else {
			return true;
		}
	}

	public static boolean isEmpty(Collection list) {
		return (list == null || list.size() == 0);
	}

	public static boolean isNotEmpty(Collection list) {
		return !isEmpty(list);
	}

	public static boolean isEmpty(String value) {
		return value == null || "".equals(value.trim());
	}

	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	/**
	 * @desc 将字符串数组转换为long数组
	 * @auther Dave
	 * @date 2016年11月2日
	 * 
	 * @param str
	 * @return
	 */
	public static Long[] coverStringToLong(String[] str) {
		Long[] ids = new Long[str.length];
		for (int i = 0; i < str.length; i++) {
			String id = str[i];
			if (isNotEmpty(id)) {
				ids[i] = Long.parseLong(id);
			}
		}
		return ids;
	}

	/**
	 * Map 通过KEY获取内容，如果没有，则给予默认参数
	 * <ul>
	 * <li>ZX 2016年11月10日 新建</li>
	 * </ul>
	 * 
	 * @param map
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getMapValue(Map<String, Object> map, String key, String defaultValue) {
		String result = defaultValue;
		if (map.containsKey(key)) {
			result = map.get(key).toString();
		}
		return result;
	}

	/**
	 * JSONObject 通过KEY获取内容，如果没有，则给予默认参数
	 * <ul>
	 * <li>ZX 2016年11月10日 新建</li>
	 * </ul>
	 * 
	 * @param jsonObject
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getJsonValue(JSONObject jsonObject, String key, String defaultValue) {
		String result = defaultValue;
		if (jsonObject.containsKey(key)) {
			result = jsonObject.get(key).toString();
		}
		return result;
	}

	/**
	 * 解码 Unicode \\uXXXX
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeUnicode(String str) {
		Charset set = Charset.forName("UTF-16");
		Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
		Matcher m = p.matcher(str);
		int start = 0;
		int start2 = 0;
		StringBuffer sb = new StringBuffer();
		while (m.find(start)) {
			start2 = m.start();
			if (start2 > start) {
				String seg = str.substring(start, start2);
				sb.append(seg);
			}
			String code = m.group(1);
			int i = Integer.valueOf(code, 16);
			byte[] bb = new byte[4];
			bb[0] = (byte) ((i >> 8) & 0xFF);
			bb[1] = (byte) (i & 0xFF);
			ByteBuffer b = ByteBuffer.wrap(bb);
			sb.append(String.valueOf(set.decode(b)).trim());
			start = m.end();
		}
		start2 = str.length();
		if (start2 > start) {
			String seg = str.substring(start, start2);
			sb.append(seg);
		}
		return sb.toString();
	}


	/**
	 * 验证Key是否过期（5分钟内有效）
	 * <ul>
	 * <li>ZX 2016年10月30日 新建</li>
	 * </ul>
	 * 
	 * @param key
	 * @return
	 */
	public static boolean checkRandomCodeTime(String sendTime) {
		boolean flag = false;
		if (DataUtil.isNotEmpty(sendTime)) {
			if (isNumber(sendTime)) {
				long send = Long.valueOf(sendTime);
				if (System.currentTimeMillis() < (send + (20 * 1000 * 60))) {
					flag = true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 票价补位
	 * <ul>
	 * <li>ZX 2016年11月21日 新建</li>
	 * </ul>
	 * 
	 * @param str
	 * @return
	 */
	public static String pricePatch(String str){
		DecimalFormat df = new DecimalFormat("######0.00");
		String result = "0.00";
		if (isNumber(str)) {
			result = df.format(Double.valueOf(str));
		}
		return result;
	}
	
	/**
	 * 站点补位
	 * <ul>
	 * <li>ZX 2016年11月21日 新建</li>
	 * </ul>
	 * 
	 * @param str
	 * @return
	 */
	public static String sitePatch(String str){
		String result = "0000";
		if (isNotEmpty(str)) {
			result = str;
		}
		return result;
	}

//	public static void main(String[] args) {
//		System.out.println(StringToDoubleStr("77"));
//		// System.out.println( decodeUnicode("𩂤"));
//	}

	/**
	 * 将request内的数据封装成map
	 * <ul>
	 * <li>ZX 2016年11月16日 新建</li>
	 * </ul>
	 * 
	 * @param request
	 * @return
	 */
	public static Map requestToMap(HttpServletRequest request) {
		Map map = new HashMap();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					map.put(paramName, paramValue);
				}
			}
		}
		return map;
	}
	
	/**
	 * 昵称是手机号的情况下隐藏中间4位
	 * <ul>
	 * <li>ZX 2016年12月2日 新建</li>
	 * </ul>
	 * 
	 * @param nickname
	 * @return
	 */
	public static String phoneHide(String nickname) {
		if (DataUtil.isMobile(nickname)) {
			return nickname.substring(0, 3) + "****" + nickname.substring(7, nickname.length());
		} else {
			return nickname;
		}
	}
}
