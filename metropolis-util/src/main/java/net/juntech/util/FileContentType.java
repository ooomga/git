package net.juntech.util;

/**
 * <ul>
 * <li>xhl 2016年11月29日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public enum FileContentType {

	bmp("application/x-bmp"), // 图片
	gif("image/gif"), // 图片
	xls("application/vnd.ms-excel"), // excel文档
	xlsx("application/vnd.ms-excel"), // excel文档
	;

	private String contentType;

	private FileContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}
}
