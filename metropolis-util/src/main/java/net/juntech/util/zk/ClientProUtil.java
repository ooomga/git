package net.juntech.util.zk;

import com.odianyun.soa.client.SoaClientFactoryBean;
import com.odianyun.soa.common.dto.ClientProfile;

/**
 * <ul>
 * <li>xhl 2016年12月23日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class ClientProUtil {

	private static ClientProfile profile;

	/**
	 * 创建接口
	 * 
	 * @param time
	 *            请求时间
	 * @param t
	 *            需要请求的接口
	 * @param projectName
	 *            项目名
	 * @param service
	 *            需要请求的接口文件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createInterface(long time, Class<T> t, String projectName, String service) {
		profile = new ClientProfile();
		profile.setDomainName("juntech");
		profile.setServiceAppName(projectName);
		profile.setClientAppName("test");
		profile.setServiceName(service);
		profile.setServiceVersion("0.1");
		profile.setTimeout(time);
		profile.setReadTimeout(time);
		SoaClientFactoryBean factory = new SoaClientFactoryBean(t, profile);
		System.err.println(factory.getObject().getClass());
		return (T) factory.getObject();
	}

	/**
	 * 创建请求接口
	 * <ul>
	 * <li>xhl 2016年12月24日 新建</li>
	 * </ul>
	 * 
	 * 
	 * @param t
	 *            需要请求的接口
	 * @param service
	 *            接口
	 * @param projectName
	 *            项目名
	 * @return
	 */
	public static <T> T createInterface(Class<T> t, String projectName, String service) {
		return createInterface(10000L, t, projectName, service);
	}

	// 默认是用需要的接口的名称去掉I首字母小写
	public static <T> T createInterface(Class<T> t, String projectName) {
		String serviceName = t.getSimpleName();
		String service = serviceName.toLowerCase().substring(1, 2) + serviceName.substring(2);
		return createInterface(10000L, t, projectName, service);
	}

}
