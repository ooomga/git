package design.singleton;

/**
 * 饿汉模式
 * 
 * 只要加载就创建一个实例
 * 
 * <ul>
 * <li>{@link #HungrySingleton()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class HungrySingleton {

	private static final HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton() {
	}

	public HungrySingleton getInstance() {
		return hungrySingleton;
	}

}
