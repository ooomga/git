package net.juntech.util;

public class StringUtil {

	public static String[] spritStr(String temp) {

		if (temp != null && temp.length() > 0) {

			String[] nameNumb = temp.split(",");
			return nameNumb;
		}
		return null;

	}

	/**
	 * 判断字符串不为空
	 * <ul>
	 * <li>xhl 2016年6月23日 新建</li>
	 * </ul>
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {

		if (null == object) {
			return true;
		}

		if (object.toString().trim().length() <= 0) {
			return true;
		}
		return false;
	}

	public static String sqlParamChange(String param) {
		String[] params = param.split(",");
		String temp = "";
		for (String p : params) {
			temp += "'" + p + "',";
		}
		temp = temp.substring(0, temp.length() - 1);
		return temp;
	}

	/**
	 * 字符串转换unicode
	 */
	public static String string2Unicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			// 取出每一个字符
			char c = string.charAt(i);
			// 转换为unicode
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}

	/**
	 * unicode 转字符串
	 */
	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\u");
		for (int i = 1; i < hex.length; i++) {
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);
			// 追加成string
			string.append((char) data);
		}
		return string.toString();
	}

	public static void main(String[] args) {
		System.err.println(string2Unicode("舒服撒啊啊空间哈师傅萨达省空间发生"));
		System.err.println(unicode2String("\u8212\u670d\u6492\u554a\u554a\u7a7a\u95f4\u54c8\u5e08\u5085\u8428\u8fbe\u7701\u7a7a\u95f4\u53d1\u751f"));
	}

}
