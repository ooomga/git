package design.singleton;

/**
 * <ul>
 * <li>{@link #SingletonRunnable()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月2日
 * 
 */
public class SingletonRunnable implements Runnable {

	@Override
	public void run() {
		PreventCrackSingleton preventCrackSingleton = PreventCrackSingleton.getInstance();
		System.err.println("创建：" + preventCrackSingleton);
		System.err.println("Hash:" + preventCrackSingleton.hashCode());
	}

}
