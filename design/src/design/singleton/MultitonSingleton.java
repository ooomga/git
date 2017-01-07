package design.singleton;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * 多例
 * <ul>
 * <li>{@link #MultitonSingleton()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月2日
 * 
 */
public class MultitonSingleton {

	private MultitonSingleton() {
	}

	private MultitonSingleton(String str) {
		connectionList.add(str);
	}

	/**
	 * 当前连接
	 */
	private static int currConnection = 0;
	/**
	 * 最大连接数
	 */
	private static int maxConnection = 5;

	/**
	 * 所有连接编号
	 */
	private static List<String> connectionList = new ArrayList<>();

	/**
	 * 所有连接
	 */
	private static List<MultitonSingleton> singletons = new ArrayList<>();

	static {
		for (int i = 0; i < maxConnection; i++) {
			singletons.add(new MultitonSingleton("第" + i + "个"));
		}
	}

	public static MultitonSingleton getInstance() {
		Random random = new Random();
		currConnection = random.nextInt(maxConnection);
		return singletons.get(currConnection);
	}

	public void connection() {
		System.err.println(connectionList.get(currConnection));
	}

}
