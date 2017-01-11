package net.juntech.test;

import org.junit.Before;
import org.junit.Test;

import net.juntech.service.test.ITestService;
import net.juntech.service.wages.IWagesService;
import net.juntech.util.zk.ClientProUtil;

/**
 * <ul>
 * <li>xhl 2016年12月23日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class SoaClientTest {

	@Before
	public void setUp() throws Exception {
		System.getProperties().setProperty("global.config.path", "F:\\Repository\\com\\env");
	}

	@Test
	public void testAddUserService() {
		IWagesService wages = ClientProUtil.createInterface(IWagesService.class, "metropolis-user");
		wages.selectWagesAll();
//		ITestService test = ClientProUtil.createInterface(ITestService.class, "station");
//		test.delTestSerivce("1111");
	}

}
