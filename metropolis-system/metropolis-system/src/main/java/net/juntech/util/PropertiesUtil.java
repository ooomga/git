package net.juntech.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <ul>
 * <li>xn001 2016年4月26日 新建</li>
 * <li>{@link #getProperties(String)}获取properties文件内容自定义路径</li>
 * </ul>
 *
 */
public class PropertiesUtil {

	// TODO getProperties()构造方法传入 文件地址,完善以绝对路径获取配置信息

	private static Log log = LogFactory.getLog(PropertiesUtil.class);

	private static String fileName = "/base.properties";// 这里是指放在classes下，如果有包的话，前面加包名即可。例：/com/web/db.properties

	/**
	 * 获取base.properties文件内容
	 * <li>xn001 2016年4月27日 新建</li>
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Properties getProperties() throws IOException {
		Properties properties = new Properties();

		/**
		 * 使用 new FileInputStream(fileName) 需要文件的绝对路径 <br>
		 * 所以这里采用 类.class.getResourceAsStream(fileName) 获取文件流fileName 必须是以 / 开始
		 *
		 */
		InputStream inStream = PropertiesUtil.class.getResourceAsStream(fileName);

		try {
			properties.load(inStream);
			inStream.close();
		} catch (IOException e) {
			log.error(e);
			throw new IOException();
		}
		return properties;
	}

	/**
	 * 获取properties文件内容自定义路径
	 * <li>classes下相对路径(支持)：必须以 / 开始[/test/test.properties]
	 * <li>绝对路径(不支持)：
	 * <ul>
	 * <li>xn001 2016年4月27日 新建</li>
	 * </ul>
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Properties getProperties(String fileName) throws IOException {
		if (null == fileName || "".equals(fileName.trim())) {
			log.error("文件路径不存在");
			throw new FileNotFoundException();
		}

		Properties properties = new Properties();

		/**
		 * 使用 new FileInputStream(fileName) 需要文件的绝对路径 <br>
		 * 所以这里采用 类.class.getResourceAsStream(fileName) 获取文件流fileName 必须是以 / 开始
		 *
		 */
		InputStream inStream = PropertiesUtil.class.getResourceAsStream(fileName);
		try {
			properties.load(inStream);
			inStream.close();
		} catch (IOException e) {
			log.error(e);
			throw new IOException();
		}
		return properties;
	}

	public static void main(String[] args) throws IOException {
		Properties properties = PropertiesUtil.getProperties("/file/file.properties");
		System.out.println(properties);
	}

}
