package design.singleton;

import java.io.Serializable;

/**
 * 最优模式
 * 
 * 
 * <ul>
 * <li>{@link #Singleton()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class Singleton implements Serializable {

	private static final long serialVersionUID = -2282108286683123482L;

	private static class SingletonInitInstance {
		private static final Singleton INSTANCE = new Singleton();
	}

	private Singleton() {
	}

	public static Singleton getInstance() {
		return SingletonInitInstance.INSTANCE;
	}

}
