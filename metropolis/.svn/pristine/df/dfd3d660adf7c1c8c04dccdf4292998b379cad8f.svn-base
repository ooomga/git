package net.juntech.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 与远程服务器建立连接
 */

/**
 * @author xhl
 *
 */
public class HttpInvoker {

	private Log logger = LogFactory.getLog(HttpInvoker.class);

	private static HttpInvoker httpInvoker = new HttpInvoker();
	private HttpClient client = null;
	private String charset = "UTF-8";// 编码格式
	private int timeout = 10000; // 连接超时
	private boolean useProxy = false; // 是否使用代理服务器
	private String proxyHost = null; // 代理服务器地址
	private int proxyPort; // 代理服务器端口
	private String proxyUsername = null; // 代理服务器用户名
	private String proxyPassword = null; // 代理服务器密码
	private boolean initialized = false; // 是否初始化

	public static HttpInvoker newInstance() {
		return httpInvoker;
	}

	private HttpInvoker() {
		client = new HttpClient(new MultiThreadedHttpConnectionManager());
		client.getParams().setParameter("http.protocol.content-charset", "UTF-8");
		client.getParams().setContentCharset(charset);
		client.getParams().setSoTimeout(timeout);
	}

	/**
	 * @param charset
	 *            编码格式
	 * @param timeout
	 *            连接超时 默认10000ms,大于0为重新设置
	 * @param useProxy
	 *            是否使用代理
	 * @param proxyHost
	 *            代理地址
	 * @param proxyPort
	 *            代理端口
	 * @param proxyUsername
	 *            代理用户名
	 * @param proxyPassword
	 *            代理密码
	 */
	public HttpInvoker(String charset, int timeout, boolean useProxy, String proxyHost, int proxyPort, String proxyUsername, String proxyPassword) {
		client = new HttpClient(new MultiThreadedHttpConnectionManager());
		if (charset != null && !charset.trim().equals("")) {
			this.charset = charset;
		}
		if (timeout > 0) {
			this.timeout = timeout;
		}
		client.getParams().setParameter("http.protocol.content-charset", charset);
		client.getParams().setContentCharset(charset);
		client.getParams().setSoTimeout(timeout);
		if (useProxy && proxyHost != null && !"".equals(proxyHost.trim()) && proxyPort > 0) {
			HostConfiguration hc = new HostConfiguration();
			hc.setProxy(proxyHost, proxyPort);
			client.setHostConfiguration(hc);
			if (proxyUsername != null && !"".equals(proxyUsername.trim()) && proxyPassword != null && !"".equals(proxyPassword.trim())) {
				client.getState().setProxyCredentials(AuthScope.ANY, new UsernamePasswordCredentials(proxyUsername, proxyPassword));
			}
		}
		initialized = true;
		if (logger.isDebugEnabled()) {
			logger.debug("HttpInvoker初始化完成");
		}
	}

	/**
	 * 参数设置后初始化
	 * <ul>
	 * <li>xhl 2016年7月27日 新建</li>
	 * </ul>
	 * 
	 */
	public synchronized void init() {
		if (charset != null && !"".equals(charset.trim())) {
			client.getParams().setParameter("http.protocol.content-charset", charset);
			client.getParams().setContentCharset(charset);
		}
		if (timeout > 0) {
			client.getParams().setSoTimeout(timeout);
		}
		if (useProxy && proxyHost != null && !"".equals(proxyHost.trim()) && proxyPort > 0) {
			HostConfiguration hc = new HostConfiguration();
			hc.setProxy(proxyHost, proxyPort);
			client.setHostConfiguration(hc);
			if (proxyUsername != null && !"".equals(proxyUsername.trim()) && proxyPassword != null && !"".equals(proxyPassword.trim())) {
				client.getState().setProxyCredentials(AuthScope.ANY, new UsernamePasswordCredentials(proxyUsername, proxyPassword));
			}
		}
		initialized = true;
		if (logger.isDebugEnabled()) {
			logger.debug("HttpInvoker初始化完成");
		}
	}

	/**
	 * 模拟get请求
	 * <ul>
	 * <li>xhl 2016年7月27日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public String invoke(String url) throws Exception {
		return invoke(url, null, false);
	}

	/**
	 * 支持get，post请求
	 * <ul>
	 * <li>xhl 2016年7月27日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数,get、post均可传入自动拼接
	 * @param isPost
	 *            是否是post请求
	 * @return
	 * @throws Exception
	 */
	public String invoke(String url, Map<String, Object> params, boolean isPost) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("HTTP调用[" + (isPost ? "POST" : "GET") + "][" + url + "][" + params + "]");
		}
		HttpMethod httpMethod = null;
		String result = "";
		try {
			if (isPost) {
				httpMethod = postMethod(url, params);
			} else {
				httpMethod = getMethod(url, params);
			}
			client.executeMethod(httpMethod);
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpMethod.getResponseBodyAsStream(), "ISO-8859-1"));
			String line = null;
			String html = null;
			while ((line = reader.readLine()) != null) {
				if (html == null) {
					html = "";
				} else {
					html += "\r\n";
				}
				html += line;
			}
			if (html != null) {
				result = new String(html.getBytes("ISO-8859-1"), charset);
			}
		} catch (SocketTimeoutException e) {
			logger.error("连接超时[" + url + "]");
			throw e;
		} catch (java.net.ConnectException e) {
			logger.error("连接失败[" + url + "]");
			throw e;
		} catch (Exception e) {
			logger.error("连接时出现异常[" + url + "]");
			throw e;
		} finally {
			if (httpMethod != null) {
				try {
					httpMethod.releaseConnection();
				} catch (Exception e) {
					logger.error("释放网络连接失败[" + url + "]");
					throw e;
				}
			}
		}

		return result;
	}

	/**
	 * 创建post请求的method
	 * <ul>
	 * <li>xhl 2016年7月27日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private HttpMethod postMethod(String url, Map<String, Object> paramMap) throws IOException {
		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		NameValuePair[] param = {};
		List<NameValuePair> list = new ArrayList<>();
		Iterator<Entry<String, Object>> iterator = paramMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> next = iterator.next();
			String key = next.getKey();
			Object value = next.getValue();
			if (value instanceof String) {
				list.add(new NameValuePair(key, value.toString()));
			} else if (value instanceof String[]) {
				String[] temp = (String[]) value;
				for (String v : temp) {
					list.add(new NameValuePair(key, v));
				}
			}
		}
		param = list.toArray(param);
		post.setRequestBody(param);
		post.releaseConnection();
		return post;
	}

	/**
	 * 创建get请求的method
	 * <ul>
	 * <li>xhl 2016年7月28日 新建</li>
	 * </ul>
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private HttpMethod getMethod(String url, Map<String, Object> paramMap) throws UnsupportedEncodingException {
		GetMethod get;
		if (null == paramMap || paramMap.size() == 0) {
			get = new GetMethod(url.trim());
		} else {
			StringBuffer getUrl = new StringBuffer(url.trim());
			Iterator<Entry<String, Object>> iterator = paramMap.entrySet().iterator();
			if (url.trim().indexOf("?") > -1) {
				if (url.trim().indexOf("?") < url.trim().length() - 1 && url.trim().indexOf("&") < url.trim().length() - 1) {
					getUrl.append("&");
				}
			} else {
				getUrl.append("?");
			}
			while (iterator.hasNext()) {
				Entry<String, Object> next = iterator.next();
				String key = next.getKey();
				Object value = next.getValue();
				if (value instanceof String) {
					// 进行汉字转码
					value = URLEncoder.encode(value.toString(), this.charset);
					getUrl.append(key).append("=").append(value).append("&");
				} else if (value instanceof String[]) {
					String[] temp = (String[]) value;
					for (String v : temp) {
						// 汉字转码
						v = URLEncoder.encode(v, this.charset);
						getUrl.append(key).append("=").append(v).append("&");
					}
				}
			}

			if (getUrl.lastIndexOf("&") == getUrl.length() - 1) {
				get = new GetMethod(getUrl.substring(0, getUrl.length() - 1));
			} else {
				get = new GetMethod(getUrl.toString());
			}
		}
		return get;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	public synchronized boolean isInitialized() {
		return initialized;
	}

}
