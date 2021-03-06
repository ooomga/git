package net.juntech.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SMSUtil {
	private static Log log = LogFactory.getLog(SMSUtil.class);
	/**
	 * 短信发送请求地址
	 */
	public static final String MSG_URL = "http://binfen.semcenter.cn/interface/message/sms.ashx";

	/**
	 * 发送短信
	 * <ul>
	 * <li>ZX 2016年10月30日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 * @throws IOException 
	 */
	public static void sendSMS(List<BasicNameValuePair> formparams) throws IOException {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(MSG_URL);
		// 创建参数队列
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			log.debug("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					log.debug("--------------------------------------");
					log.debug("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					log.debug("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 发送短信返回验证码
	public static String sendSMS(Object mobile) throws IOException {
		if (mobile == null || "".equals(mobile)) {
			throw new NullPointerException("手机号码不能为空");
		}
		String code = createRandomCode();
		sendSMS(getparams(mobile.toString(), code));
		return code;
	}

	/**
	 * 随机生成6位随机验证码
	 * <ul>
	 * <li>ZX 2016年10月30日 新建</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String createRandomCode() {
		// 验证码
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

	/**
	 * 添加发送验证短信的参数
	 * <ul>
	 * <li>ZX 2016年10月31日 新建</li>
	 * </ul>
	 * 
	 * @param mobile
	 * @param RandomCode
	 * @return
	 */
	public static List<BasicNameValuePair> getparams(String mobile, String RandomCode) {
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		formparams.add(new BasicNameValuePair("mobile", mobile));// "15821301357"));//"15921546860"));//"13764749177"));
		formparams.add(new BasicNameValuePair("msgcode", "SMS_APPVERIFYCODE"));
		formparams.add(new BasicNameValuePair("params", "<params><param><name>VERIFYCODE</name><value>" + RandomCode + "</value></param></params>"));
		formparams.add(new BasicNameValuePair("domain", "localhost"));// 发送服务器的域名地址，短信平台会限制发送地址，暂时未做处理
		return formparams;
	}
}
