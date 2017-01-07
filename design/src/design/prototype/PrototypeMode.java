package design.prototype;

/**
 * 原型模式
 * 
 * 意图：
 * 
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 
 * 适用性：
 * 
 * 当要实例化的类是在运行时刻指定时，例如，通过动态装载；
 * 
 * 或者为了避免创建一个与产品类层次平行的工厂类层次时；
 * 
 * 或者当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。
 * 
 * <span style='color:red'>个人理解：对象属性部分值改变，使用clone后只需要修改部分参数值即可完成新的对象的创建，不需要单独是用new后在赋值</span>
 * 
 * <ul>
 * <li>{@link #PrototypeMode()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class PrototypeMode {

	public static void main(String[] args) throws CloneNotSupportedException {
		Html html = new Html();
		Body body = new Body();
		Head head = new Head();
		html.setBody(body);
		html.setHead(head);
		body.setDiv("div");
		head.setMeta("meta");
		// 对html 进行克隆
		Html h = (Html) html.clone();
		// 修改克隆后的body中的div的值
		h.getBody().setDiv("DIV");
		// 修改克隆后的head中的meta的值
		h.getHead().setMeta("META");

		System.err.println(html);
		System.err.println(h);
		System.err.println("---地址不一样表示进行了深克隆");
		System.err.println(html.getBody());
		System.err.println(h.getBody());
		System.err.println(html.getBody().getDiv());
		System.err.println(h.getBody().getDiv());
		System.err.println("---html对象中的body未进行克隆，出现了修改克隆后的html中的body的属性div值后，克隆前的html中的body的div值跟着变化");
		System.err.println(html.getHead());
		System.err.println(h.getHead());
		System.err.println(html.getHead().getMeta());
		System.err.println(h.getHead().getMeta());
		System.err.println("---html对象中的head进行了克隆，修改克隆后的html中的head的属性meta值后，克隆前的html中的head的meta值未变化");

	}

}
