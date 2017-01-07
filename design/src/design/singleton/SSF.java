package design.singleton;

/**
 * <ul>
 * <li>{@link #SSF()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月2日
 * 
 */
public class SSF {

	public static void main(String[] args) {
		SSS aaaa = SSS.AAAA;
		SSS bbbb = SSS.BBBB;
		
		aaaa.setValue("事实上");
		System.err.println(aaaa.getValue());
		System.err.println(aaaa);
		System.err.println(bbbb.getValue());
	}

}
