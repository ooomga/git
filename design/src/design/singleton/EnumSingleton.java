package design.singleton;

/**
 * <ul>
 * <li>{@link #EnumSingleton()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月2日
 * 
 */
public enum EnumSingleton {

	INSTANCE, INSTANCEB;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static EnumSingleton getInstance() {
		return EnumSingleton.INSTANCE;
	}

}
