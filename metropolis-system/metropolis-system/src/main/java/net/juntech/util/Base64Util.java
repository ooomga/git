package net.juntech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <ul>
 * <li>{@link #Base64Util()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月11日
 * 
 */
public class Base64Util {

	private static Log log = LogFactory.getLog(Base64Util.class);

	/**
	 * 将base64字符串保存到文件中
	 * 
	 * @author xhl 2016年8月12日
	 * @param base64
	 *            需要保存的base64字符串
	 * @param filePath
	 *            保存的地址（绝对路径）
	 * @throws IOException
	 */
	public static void base64SaveFile(String base64, String filePath) throws IOException {
		byte[] buffer = base64.getBytes();
		FileOutputStream outputStream = new FileOutputStream(filePath);
		outputStream.write(buffer);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 将base64字符串转为byte数组
	 * 
	 * @author xhl 2016年8月12日
	 * @param base64
	 *            需要转换的base64字符串
	 * @return
	 */
	public static byte[] base64ToByte(String base64) {
		return new Base64().decode(base64);
	}

	/**
	 * 将base64字符串转换为文件
	 * 
	 * @author xhl 2016年8月12日
	 * @param base64
	 *            需要转换的字符串
	 * @param filePath
	 *            转换后保存的文件的地址（绝对地址）
	 * @throws IOException
	 */
	public static void base64ToFile(String base64, String filePath) throws IOException {
		byte[] buffer = new Base64().decode(base64);
		FileOutputStream outputStream = new FileOutputStream(filePath);
		outputStream.write(buffer);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 将base64字符串保存到指定文件
	 * 
	 * @author xhl 2016年8月12日
	 * @param base64
	 *            需要保存的base64字符串
	 * @param file
	 *            保存的目标文件
	 * @throws IOException
	 */
	public static void base64ToFile(String base64, File file) throws IOException {
		if (!file.exists()) {
			log.error("目标文件不存在");
			throw new NullPointerException("目标文件不存在");
		}
		byte[] buffer = new Base64().decode(base64);
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(buffer);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 指定输出流写出文件base64字符串
	 * 
	 * @author xhl 2016年8月12日
	 * @param path
	 *            需要写出的文件
	 * @param outputStream
	 *            指定的输出流
	 * @throws IOException
	 */
	public static void base64Write(String path, OutputStream outputStream) throws IOException {
		InputStream inputStream = new FileInputStream(path);
		byte[] bs = new byte[inputStream.available()];
		inputStream.read(bs);
		inputStream.close();
		// 写出
		outputStream.write(bs);
		outputStream.flush();
		outputStream.close();
	}

}