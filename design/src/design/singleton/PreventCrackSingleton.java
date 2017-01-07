package design.singleton;

import java.io.Serializable;

/**
 * 能防止破解的单例模式（支持拦截反射破解，反序列化破解）
 * 
 * <ul>
 * <li>{@link #PreventCrackSingleton()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class PreventCrackSingleton implements Serializable {

	private static final long serialVersionUID = -5663645927120472837L;

	private static class PreventCrackSingletonInstance {
		private static final PreventCrackSingleton INSTANCE = new PreventCrackSingleton();
	}

	private PreventCrackSingleton() {
		// 防止通过反射方式进行破解
		if (PreventCrackSingletonInstance.INSTANCE != null) {
			throw new RuntimeException();
		}
	}

	public static PreventCrackSingleton getInstance() {
		return PreventCrackSingletonInstance.INSTANCE;
	}

	// 在反序列时，如果定义了readResolve(),直接返回此方法指定的对象，而不需要把反序列化那个新对象返回。
	private Object readResolve() {
		return PreventCrackSingletonInstance.INSTANCE;
	}

}
