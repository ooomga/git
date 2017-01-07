package net.juntech.controller.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import net.juntech.controller.base.BaseController;
import net.juntech.util.FileUtil;

/**
 * <ul>
 * <li>xhl 2016年9月7日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
@Controller
public class UploadController extends BaseController {

	/**
	 * 
	 * @desc 上传文件
	 * @auther Dave
	 * @date 2016年10月28日
	 * 
	 * @throws IOException
	 * @param file
	 *            <input type="file" multiple="multiple" />
	 * @param folder
	 *            文件件名称 文件上传路径默认为WEB-INFO/upload/[folder/]
	 */
	@RequestMapping(value = "/file/uploadFile", method = RequestMethod.POST)
	public void uploadFile() throws IOException {
		Map<String, Object> result = new HashMap<>();
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);

		Iterator<String> iterator = multipartRequest.getFileNames();
		String folder = String.valueOf(multipartRequest.getParameter("folder"));
		while (iterator.hasNext()) {
			String fileName = iterator.next();
			MultipartFile multipartFile = multipartRequest.getFile(fileName);
			try {
				String name = copyFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), folder);
				result.put("fileName", name);
				result.put("fileNamePath", File.separator + "upload" + File.separator + folder + File.separator + name);
			} catch (IOException e) {
				result.put("error", "文件上传失败");
				throw e;
			}
		}
		writeJson(result);
	}

	/**
	 * 文件上传
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "upload.htm", method = RequestMethod.POST)
	public void upload() throws IOException {
		Map<String, Object> result = new HashMap<>();
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);

		Iterator<String> iterator = multipartRequest.getFileNames();
		Boolean isRename = Boolean.valueOf(multipartRequest.getParameter("isRename"));
		String folder = String.valueOf(multipartRequest.getParameter("folder"));

		while (iterator.hasNext()) {
			String fileName = iterator.next();
			MultipartFile multipartFile = multipartRequest.getFile(fileName);
			byte[] bs = null;
			try {
				bs = multipartFile.getBytes();
				copyFile(bs, multipartFile.getOriginalFilename(), isRename, folder);
			} catch (IOException e) {
				result.put("error", "文件上传失败");
				throw e;
			}
		}
		writeJson(result);
	}

	/**
	 * 复制文件
	 * <ul>
	 * <li>xhl 2016年9月8日 新建</li>
	 * </ul>
	 * 
	 * @param bs
	 *            文件byte数组
	 * @param fileName
	 *            文件名称
	 * @param isRename
	 *            是否重命名
	 * @param folder
	 * @throws IOException
	 */
	private String copyFile(InputStream inputStream, String fileName, String folder) throws IOException {
		String filepath = abstractPath + File.separator + "upload" + File.separator;
		;
		if (folder != null && !"".equals(folder) && !folder.equals("null")) {
			filepath += folder + File.separator;
		}
		File pfile = new File(filepath);
		if (!pfile.exists()) { // 文件夹不存在则创建
			pfile.mkdirs();
		}
		String suff = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		fileName = System.currentTimeMillis() + suff;
		File newFile = new File(filepath + fileName);
		FileUtils.copyInputStreamToFile(inputStream, newFile);
		return fileName;
	}

	/**
	 * 复制文件
	 * <ul>
	 * <li>xhl 2016年9月8日 新建</li>
	 * </ul>
	 * 
	 * @param bs
	 *            文件byte数组
	 * @param fileName
	 *            文件名称
	 * @param isRename
	 *            是否重命名
	 * @param folder
	 * @throws IOException
	 */
	private void copyFile(byte[] bs, String fileName, Boolean isRename, String folder) throws IOException {
		String filepath = abstractPath + File.separator + "upload" + File.separator;
		;
		if (folder != null && !"".equals(folder) && !folder.equals("null")) {
			filepath += folder + File.separator;
		}
		File file = new File(filepath);
		if (!file.exists()) { // 文件夹不存在则创建
			file.mkdirs();
		}
		if (null == isRename || isRename == true) {// 默认修改文件名
			String suff = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			fileName = System.currentTimeMillis() + suff;
		}
		FileOutputStream out = new FileOutputStream(filepath + fileName);
		out.write(bs);
		out.close();
	}

	/**
	 * 文件下载
	 * <ul>
	 * <li>xhl 2016年9月7日 新建</li>
	 * </ul>
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "download.htm")
	public void download(String filePath) throws IOException {
		filePath = abstractPath + URLDecoder.decode(filePath, "UTF-8");
		FileUtil.downloadLocal(response, filePath);
	}

}
