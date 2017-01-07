package design.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <ul>
 * <li>{@link #SingletonMode()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class SingletonMode {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// 多线程测试
		Thread thread = new Thread(new SingletonRunnable());
		Thread thread2 = new Thread(new SingletonRunnable());
		thread.start();
		thread2.start();

		// 枚举 推荐使用此方法
		enumSingleton();

		// 随机获取连接池中的连接
		multitonSingleton();

		// 不能防止破解
		testSingleton();

		// 防止破解
		testPreventCrackSingleton();

	}

	public static void multitonSingleton() {
		for (int i = 0; i < 10; i++) {
			MultitonSingleton instance = MultitonSingleton.getInstance();
			System.err.println("第" + i + "个用户：");
			instance.connection();
		}
	}

	/**
	 * 枚举 实现单例（多例）模式（推荐）
	 * 
	 * 默认防止破解（序列化反序列化，反射）
	 * 
	 * @author xhl 2016年9月2日
	 */
	public static void enumSingleton() {
		EnumSingleton instance3 = EnumSingleton.getInstance();

		EnumSingleton instance = EnumSingleton.INSTANCE;
		System.err.println("设置第一种第一个实例：张三");
		instance.setName("张三");
		System.err.println("第一种第一个实例：" + instance.getName());
		EnumSingleton instance2 = EnumSingleton.INSTANCE;
		System.err.println("第一种第二个实例：" + instance2.getName());

		EnumSingleton instanceb = EnumSingleton.INSTANCEB;
		System.err.println("第二种第一个实例：" + instanceb.getName());
		System.err.println("设置第二种第一个实例：李四");
		instanceb.setName("李四");
		System.err.println("第二种第一个实例：" + instanceb.getName());
		EnumSingleton instanceb2 = EnumSingleton.INSTANCEB;
		System.err.println("设置第二种第二个实例：王五");
		instanceb2.setName("王五");
		System.err.println("第二种第二个实例：" + instanceb2.getName());
		System.err.println("第二种第一个实例：" + instanceb.getName());

	}

	/**
	 * 不能防止破解
	 * 
	 * @author xhl 2016年9月1日
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static void testSingleton() throws ClassNotFoundException, IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton instance = Singleton.getInstance();
		Singleton instance1 = Singleton.getInstance();
		System.err.println("----------------------对象相同单例完成");
		System.err.println(instance);
		System.err.println(instance1);
		System.err.println("----------------------反序列化方式破解");
		Singleton instance3 = Singleton.getInstance();
		/** 获取当前项目所在目录 */
		String path = System.getProperty("user.dir");
		path += "/src/singleton.txt";
		FileOutputStream outputStream = new FileOutputStream(path);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		/** 以文件的形式保存序列化对象 */
		objectOutputStream.writeObject(instance3);
		outputStream.close();
		objectOutputStream.close();
		/** 读取文件 */
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
		/** 反序列化 */
		Singleton singleton = (Singleton) objectInputStream.readObject();
		objectInputStream.close();
		System.err.println(instance3);
		System.err.println(singleton);
		System.err.println("----------------------反射方式破解");
		Class<Singleton> clazz1 = (Class<Singleton>) Class.forName(instance.getClass().getName());
		Constructor<Singleton> constructor = clazz1.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		Singleton newInstance = constructor.newInstance();
		Singleton newInstance1 = constructor.newInstance();
		System.err.println(newInstance);
		System.err.println(newInstance1);
	}

	/**
	 * 能防止破解（包括反射，反序列化）
	 * 
	 * 反射会出现异常
	 * 
	 * 反序列化与原来的一致
	 * 
	 * @author xhl 2016年9月1日
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static void testPreventCrackSingleton() throws ClassNotFoundException, IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PreventCrackSingleton instance = PreventCrackSingleton.getInstance();
		PreventCrackSingleton instance1 = PreventCrackSingleton.getInstance();
		System.err.println("----------------------对象相同单例完成");
		System.err.println(instance);
		System.err.println(instance1);
		System.err.println("----------------------反序列化方式破解");
		PreventCrackSingleton instance2 = PreventCrackSingleton.getInstance();
		/** 获取当前项目所在目录 */
		String path = System.getProperty("user.dir");
		path += "/src/singleton.txt";
		FileOutputStream outputStream = new FileOutputStream(path);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		/** 以文件的形式保存序列化对象 */
		objectOutputStream.writeObject(instance2);
		outputStream.close();
		objectOutputStream.close();
		/** 读取文件 */
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
		/** 反序列化 */
		PreventCrackSingleton singleton = (PreventCrackSingleton) objectInputStream.readObject();
		objectInputStream.close();
		System.err.println(instance2);
		System.err.println(singleton);
		System.err.println("----------------------反射方式破解");
		Class<PreventCrackSingleton> clazz1 = (Class<PreventCrackSingleton>) Class.forName(instance.getClass().getName());
		Constructor<PreventCrackSingleton> constructor = clazz1.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		PreventCrackSingleton newInstance = constructor.newInstance();
		PreventCrackSingleton newInstance1 = constructor.newInstance();
		System.err.println(newInstance);
		System.err.println(newInstance1);
	}
}
