package net.juntech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * FTP 必须自己手动断开连接
 * <ul>
 * <li>xhl 2016年5月20日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class FtpUtil {

	private static Log log = LogFactory.getLog(FtpUtil.class);

	private static FTPClient ftp;

	/**
	 * <ul>
	 * <li>xhl 2016年5月20日 新建</li>
	 * </ul>
	 * 
	 * @param pathname
	 *            ftp服务器上传地址
	 * @param hostname
	 *            本地地址
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 * @throws IOException
	 */
	public static boolean connect(String pathname, String hostname, String port, String username, String password) throws IOException {
		boolean flag = false;

		ftp = new FTPClient();
		try {
			ftp.connect(hostname, Integer.parseInt(port));
		} catch (IOException e) {
			log.error("ftp服务器地址错误", e);
			throw e;
		}
		ftp.login(username, password);
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		int code = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(code)) {
			ftp.disconnect();
			return flag;
		}
		boolean directory = ftp.changeWorkingDirectory(pathname);
		if (!directory) {
			ftp.makeDirectory(pathname);
			ftp.changeWorkingDirectory(pathname);
		}
		flag = true;
		return flag;
	}

	/**
	 * 需要上传的文件或者文件夹
	 * <ul>
	 * <li>xhl 2016年5月20日 新建</li>
	 * </ul>
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void ftpUpload(File file) throws IOException {

		if (file.isDirectory()) {
			try {
				ftp.makeDirectory(file.getName());
			} catch (IOException e) {
				log.error("创建文件或文件夹失败,可能是权限不足");
				throw e;
			}
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (String f : files) {
				File tempFile = new File(file.getPath() + "\\" + f);
				System.err.println(tempFile.isDirectory());
				if (tempFile.isDirectory()) { // 如果是文件夹 进行递归调用
					ftpUpload(tempFile);
					ftp.changeToParentDirectory();
				} else {
					FileInputStream inputStream = new FileInputStream(tempFile);
					ftp.storeFile(tempFile.getName(), inputStream);
					inputStream.close();
				}
			}
		} else {
			File tempFile = new File(file.getPath());
			FileInputStream inputStream = new FileInputStream(tempFile);
			ftp.storeFile(tempFile.getName(), inputStream);
			inputStream.close();
		}
	}

	/**
	 * 上传单个文件，以流的形式
	 * <ul>
	 * <li>xhl 2016年5月20日 新建</li>
	 * </ul>
	 * 
	 * @param filename
	 * @param inputStream
	 * @throws IOException
	 */
	public static void ftpUpload(String filename, InputStream inputStream) throws IOException {
		ftp.storeFile(filename, inputStream);
		inputStream.close();
	}

	/**
	 * 断开连接
	 * <ul>
	 * <li>xhl 2016年5月20日 新建</li>
	 * </ul>
	 * 
	 * @param filename
	 * @param inputStream
	 * @throws IOException
	 */
	public static void disconnect() throws IOException {
		ftp.disconnect();
	}

	public static void main(String[] args) throws IOException {
		FtpUtil.connect("", "localhost", "21", "juntech", "admin");
		FtpUtil.ftpUpload(new File("D:\\logs"));
	}
}
