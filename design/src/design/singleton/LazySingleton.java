package design.singleton;

/**
 * 懒汉模式
 * 
 * 需要的时候在创建
 * 
 * <ul>
 * <li>{@link #LazySingleton()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class LazySingleton {

	private static LazySingleton lazySingleton;

	private LazySingleton() {
	}

	public LazySingleton getInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

}
