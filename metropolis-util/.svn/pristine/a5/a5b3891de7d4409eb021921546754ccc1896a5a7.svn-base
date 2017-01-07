package net.juntech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <ul>
 * <li>xhl 2016年12月2日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class FileUtil {

	private static Log log = LogFactory.getLog(FileUtil.class);

	/**
	 * 下载本地文件
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @param abstractFilePath
	 *            文件绝对地址
	 * @param response
	 * @throws IOException
	 *
	 */
	public static void downloadLocal(HttpServletResponse response, String abstractFilePath) throws IOException {
		File file = new File(abstractFilePath);
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			log.error("下载文件不存在");
			throw e;
		}

		// 根据文件后缀获取返回类型
		String suff = abstractFilePath.substring(abstractFilePath.lastIndexOf(".") + 1);
		response.setContentType(FileContentType.valueOf(suff).getContentType());
		// 防止文件名乱码
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

		byte[] b = new byte[1024];
		int len;
		try {
			while ((len = inputStream.read(b)) > 0) {
				response.getOutputStream().write(b, 0, len);
			}
			inputStream.close();
		} catch (IOException e) {
			log.error("文件下载失败", e);
			throw e;
		}
	}

}
