package net.juntech.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class DateUtil {

	private static Logger logger = Logger.getLogger(DateUtil.class);

	/**
	 * the milli second of a day
	 */
	public static final long DAYMILLI = 24 * 60 * 60 * 1000;

	/**
	 * the milli seconds of an hour
	 */
	public static final long HOURMILLI = 60 * 60 * 1000;

	/**
	 * the milli seconds of a minute
	 */
	public static final long MINUTEMILLI = 60 * 1000;

	private DateUtil() {

	}

	/**
	 * 字符串转日期
	 * <ul>
	 * <li>xhl 2016年8月1日 新建</li>
	 * </ul>
	 * 
	 * @param value
	 * @return
	 */
	public static Date parseDate(String value) {
		String[] patterns = { "yyyy-MM-dd HH:mm:ss.sss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH", "yyyy-MM-dd", "yyyy/MM/dd" };
		Date parseDate = null;
		for (String pattern : patterns) {
			try {
				parseDate = parseDate(value, pattern);
				break;
			} catch (ParseException e) {
				continue;
			}
		}
		return parseDate;
	}

	/**
	 * 字符串转日期
	 * <ul>
	 * <li>xhl 2016年8月1日 新建</li>
	 * </ul>
	 * 
	 * @param value
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String value, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date parse = null;
		parse = format.parse(value);
		return parse;
	}

	/**
	 * 将日期转化成字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToStr(Object date, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return null;
		}
	}

	/**
	 * 
	 * 此方法描述的是：将日期 转化为DATE
	 * 
	 * @author: czl
	 * @version: 2011-1-21 上午09:45:36
	 */
	public static Date strToDate(String str, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * 时间+随机数
	 * 
	 * @return
	 */
	public static String getfeedBackNo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Random r = new Random();
		return sdf.format(date) + r.nextInt(9999);
	}

	/**
	 * 
	 * 此方法描述的是：获得本月信息
	 * 
	 * @author: zhanglei
	 * @version: Nov 30, 2011 3:07:34 PM
	 */
	public static Integer getNumberOfYearMonth(Integer year, Integer month) {
		GregorianCalendar date = new GregorianCalendar(year, month, 1);
		Integer number = date.getActualMaximum(GregorianCalendar.DATE);
		return number;
	}

	public static String getNowTimeToString() {
		Date now = new Date();
		// Calendar cal = Calendar.getInstance();
		DateFormat d1 = DateFormat.getDateInstance();
		String str1 = d1.format(now);
		return str1;
	}

	/**
	 * change timestamp to formatted string
	 * 
	 * @param t
	 *            Timestamp
	 * @param sFmt
	 *            date format
	 * @return formatted string
	 */
	private static String formatTimestamp(Timestamp t, String sFmt) {
		if (t == null)
			return "";
		t.setNanos(0);
		DateFormat ft = new SimpleDateFormat(sFmt);
		String str = "";
		try {
			str = ft.format(t);
		} catch (NullPointerException e) {
			logger.error("Null caught", e);
		}
		return str;

	}

	public static String getNowTime(String fmt) {
		Timestamp annalTime = new Timestamp(System.currentTimeMillis());
		String strAnnalTime = DateUtil.formatTimestamp(annalTime, fmt);
		return strAnnalTime;

	}

	/**
	 * get the time of the specified date after given days
	 * 
	 * @param date
	 *            the specified date day day distance
	 * 
	 * @return the format string of time
	 */
	public static String addDays(String date, int day) {
		if (date == null)
			return "";
		if (date.equals(""))
			return "";
		if (day == 0)
			return date;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");
			Calendar calendar = dateFormat.getCalendar();
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
			return dateFormat.format(calendar.getTime());
		} catch (Exception ex) {
			return "";
		}
	}

	public static int compareDate(String sDate1, String sDate2) {
		if (sDate1 == null || sDate2 == null) {
			return 0;
		}
		try {
			return sDate1.compareTo(sDate2);
		} catch (Exception e) {
			return 0;
		}

	}

	public static int getDisOf(Date d1, Date d2) {
		long time1 = d1.getTime();
		long time2 = d2.getTime();
		long dis = Math.abs(time1 - time2);
		return (dis % DAYMILLI == 0) ? (int) (dis / DAYMILLI) : (int) (dis / DAYMILLI) + 1;
	}

	/**
	 * change string to date
	 * 
	 * @param sDate
	 *            the date string sFmt the date format
	 * @return Date object
	 */
	public static Date toDate(String sDate, String sFmt) {
		SimpleDateFormat sdfFrom = null;
		java.util.Date dt = null;

		try {
			sdfFrom = new SimpleDateFormat(sFmt);
			dt = sdfFrom.parse(sDate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sdfFrom = null;
		}

		return dt;
	}

	/**
	 * 功能：得到当前月份月初 格式为：xxxx-yy-zz (eg: 2007-12-01)
	 * 
	 * @return String
	 * @author pure
	 */
	public static String getMonthBegin(String year, String month) {
		int x = Calendar.getInstance().get(Calendar.YEAR);
		int y = Calendar.getInstance().get(Calendar.MONTH);
		try {
			x = Integer.parseInt(year);
		} catch (Exception e) {
		}
		try {
			y = Integer.parseInt(month);
		} catch (Exception e) {
		}
		String strY = null;
		strY = y >= 10 ? String.valueOf(y) : ("0" + y);
		return x + "-" + strY + "-01";
	}

	/**
	 * 功能：得到当前月份月底 格式为：xxxx-yy-zz (eg: 2007-12-31)
	 * 
	 * @return String
	 * @author pure
	 **/
	public static String getMonthEnd(String year, String month) {
		int x = Calendar.getInstance().get(Calendar.YEAR);
		int y = Calendar.getInstance().get(Calendar.MONTH);
		try {
			x = Integer.parseInt(year);
		} catch (Exception e) {
		}
		try {
			y = Integer.parseInt(month);
		} catch (Exception e) {
		}

		String strY = null;
		String strZ = null;
		boolean leap = false;
		if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
			strZ = "31";
		}
		if (y == 4 || y == 6 || y == 9 || y == 11) {
			strZ = "30";
		}
		if (y == 2) {
			leap = leapYear(x);
			if (leap) {
				strZ = "29";
			} else {
				strZ = "28";
			}
		}
		strY = y >= 10 ? String.valueOf(y) : ("0" + y);
		return x + "-" + strY + "-" + strZ;
	}

	/**
	 * 功能：判断输入年份是否为闰年<br>
	 * 
	 * @param year
	 * @return 是：true 否：false
	 * @author pure
	 */
	public static boolean leapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;
		return leap;
	}

	/**
	 * 获取某年某月的最后一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 最后一天
	 */
	private static int getLastDayOfMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			if (leapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
		return 0;
	}

	/**
	 * 获得本季度第一天
	 * 
	 * @param month
	 * @return
	 */
	public static String getThisSeasonFirstTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		@SuppressWarnings("unused")
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days;
		return seasonDate;

	}

	/**
	 * 获得本季度第一天
	 * 
	 * @param month
	 * @return
	 */
	public static String getThisSeasonFirstTime(int years_value, int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		@SuppressWarnings("unused")
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days;
		return seasonDate;

	}

	/**
	 * 获得本季度最后一天
	 * 
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getThisSeasonFinallyTime(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	/**
	 * 获得本季度最后一天
	 * 
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getThisSeasonFinallyTime(int years_value, int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	public static Integer JudgeDate(String data) {
		int year = Integer.parseInt(data.substring(0, 4));
		int month = Integer.parseInt(data.substring(4, 6)) - 1;// 月是 0-11
		int day = Integer.parseInt(data.substring(6, 8));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, day);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		return week;
	}

	// 判断有没有这一天（日期是否合法）
	public static boolean isDateExist(String data) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date d = format.parse(data);
			String result = format.format(d);// 判断转换前后两个字符串是否相等即可知道合不合法
			return result.equals(data);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取开始时间
	 * <ul>
	 * <li>xhl 2016年7月21日 新建</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static long getDateStart(Object date) {
		Date temp = new Date();
		if (date instanceof Date) {
			temp = (Date) date;
		} else if (date instanceof Long) {
			temp = new Date((long) date);
		} else {
			throw new IllegalArgumentException("参数类型无法解析");
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(temp);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.clear();
		calendar.set(year, month, day, 0, 0, 0);
		return calendar.getTimeInMillis();
	}

	public static long getDateStart(Object date, String pattern) throws ParseException {
		if (date != null && StringUtils.isNotBlank(pattern)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Date parse = dateFormat.parse(date.toString());
			return getDateStart(parse);
		} else {
			return getDateStart(date);

		}
	}

	/**
	 * 获取某一天结束时间
	 * <ul>
	 * <li>xhl 2016年8月10日 新建</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static long getDateEnd(Object date) {
		Date temp = new Date();
		if (date instanceof Date) {
			temp = (Date) date;
		} else if (date instanceof Long) {
			temp = new Date((long) date);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(temp);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.clear();
		calendar.set(year, month, day, 23, 59, 59);
		return calendar.getTimeInMillis();
	}

	public static long getDateEnd(Object date, String pattern) throws ParseException {
		if (date != null && StringUtils.isNotBlank(pattern)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Date parse = dateFormat.parse(date.toString());
			return getDateEnd(parse);
		} else {
			return getDateEnd(date);

		}
	}

	public static void main(String[] args) throws ParseException {
		// long dateStart = getSqlDateStart("2012-12-12","yyyy-MM-dd");
		// System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateStart));
		// long dateEnd = getSqlDateEnd("2012-12-12","yyyy-MM-dd");
		// System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dateEnd));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.clear();
		calendar.set(year, month, day, 22, 59, 59);
		System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTimeInMillis()));
	}

}
