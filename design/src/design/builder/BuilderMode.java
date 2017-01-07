package design.builder;

/**
 * 
 * 建造者模式
 * 
 * 意图：
 * 
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 
 * 适用性：
 * 
 * 当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 * 
 * 当构造过程必须允许被构造的对象有不同的表示时。
 * 
 * <span style='color:red'>个人理解：每次操作均返回当前对象，便于后续继续操作</span>
 * <ul>
 * <li>{@link #BuilderMode()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月30日
 * 
 */
public class BuilderMode {

	public void build() {
		Builder builder = new Builder.BuilderBuild("张三").sex("男").address("北京市").build();
		System.out.println("姓名：" + builder.getName());
		System.out.println("年龄：" + builder.getAge());
		System.out.println("性别：" + builder.getSex());
		System.out.println("住址：" + builder.getAddress());
	}

	public static void main(String[] args) {
		BuilderMode builderMode = new BuilderMode();
		builderMode.build();
	}

}
