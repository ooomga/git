package net.juntech.util.verify;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.juntech.util.ObjectUtil;
import net.sf.json.JSONObject;

/**
 * <ul>
 * <li>xhl 2016年7月7日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class IntegrityVerify {

	private static Log log = LogFactory.getLog(IntegrityVerify.class);

	protected static final String KEY = "0123456789111213";

	/**
	 * 数据完整性验证
	 * <ul>
	 * <li>xhl 2016年7月7日 新建</li>
	 * </ul>
	 * 
	 * @param param
	 * @param isEncrypt
	 *            是否解密
	 * @return
	 */
	public static JSONObject verify(String param, boolean isEncrypt) {
		JSONObject json = new JSONObject();
		if (param == null) {
			return new JSONObject();
		}
		if (isEncrypt) {
			param = param.replaceAll(" ", "+");
			try {
				String decrypt = AESUtil.Decrypt(param, KEY);
				json = JSONObject.fromObject(decrypt);
				if (log.isDebugEnabled()) {
					log.debug("param:" + json);
				}
				String md5 = json.getString("md5");
				json.remove("md5");
				String newMd5 = MD5Utils.encode(json.toString().replace("\\\\", "\\"));
				if (!md5.equals(newMd5)) {
					json.put("lose", "1");
					log.error("数据库流丢失");
					throw new Exception("数据库流可能丢失");
				}
			} catch (Exception e) {
				log.error("解密失败");
			}
		} else {
			json = JSONObject.fromObject(param);
		}
		return json;
	}

	/**
	 * 返回数据加密
	 * <ul>
	 * <li>xhl 2016年7月8日 新建</li>
	 * </ul>
	 * 
	 * @param map
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static TreeMap<String, Object> encrypt(TreeMap<String, Object> map) throws IOException {
		TreeMap<String, Object> result = new TreeMap<>();
		String json = ObjectUtil.objToJsonTrim(map);
		map.put("md5", MD5Utils.encode(json.replace("\\\\", "\\")));
		try {
			json = ObjectUtil.objToJsonTrim(map);
			result.put("result", AESUtil.Encrypt(json, KEY));
			log.info(json);
		} catch (Exception e) {
			log.error("加密失败" + e);
		}
		return result;
	}

}
