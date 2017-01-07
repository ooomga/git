package net.juntech.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Description 唯一主键获取{uuid}
 * @author schoff xhlim@outlook.com
 * @date 2016年1月14日
 * @version v1.0
 */
public class UuidUtil {

	private static Log log = LogFactory.getLog(UuidUtil.class);

	/**
	 * @Description 生成uuid不包含短横线[-]
	 * @date 2016年1月14日
	 * @author schoff xhlim@outlook.com
	 * @return
	 */
	public synchronized static String generateUuid() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		if (log.isDebugEnabled()) {
			log.debug("UUID：" + uuid);
		}
		return uuid;
	}

	/**
	 * @Description 产生服务器集群可以安全使用的uuid,集群使用,生成模式：{主机标识}-{进程标识}-{java.util.UUID}
	 * @date 2016年1月14日
	 * @author schoff xhlim@outlook.com
	 * @return
	 * @throws UnknownHostException
	 */
	public synchronized static String generateClusterUUID() throws UnknownHostException {
		InetAddress localhost;
		StringBuffer sb = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			log.error("地址未找到");
			throw e;
		}
		byte[] bts = localhost.getAddress();
		for (byte bt : bts) {
			int num = bt + 128;
			sb.append(Integer.toHexString(num));
		}
		sb.append('-');
		sb.append(obtainPid());
		sb.append('-');
		sb.append(uuid);
		if (log.isDebugEnabled()) {
			log.debug("ClusterUUID：" + sb);
		}
		return sb.toString();
	}

	/**
	 * @Description 获取当前JVM的进程ID
	 * @date 2016年1月14日
	 * @author schoff xhlim@outlook.com
	 * @return
	 */
	private synchronized static int obtainPid() {
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
		String name = runtime.getName(); // format: "pid@hostname"
		int result = -1;

		if (name.contains("@")) {
			if (log.isDebugEnabled()) {
				log.debug("JVM : " + name);
			}
			result = Integer.parseInt(name.substring(0, name.indexOf('@')));
		} else {
			log.error("JVM进程未启动");
		}
		return result;
	}

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(generateUuid());
		System.out.println(generateUuid());
		System.out.println(generateUuid());
		System.out.println(generateUuid());
		System.out.println(generateUuid());
	}

}
