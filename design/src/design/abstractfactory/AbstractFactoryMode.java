package design.abstractfactory;

import design.abstractfactory.impl.FactoryFoodImpl;
import design.abstractfactory.impl.FactoryFurnitureImpl;

/**
 * 抽象工厂模式
 * 
 * 意图：
 * 
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 
 * 适用性：
 * 
 * 一个系统要独立于它的产品的创建、组合和表示时。
 * 
 * 一个系统要由多个产品系列中的一个来配置时。
 * 
 * 当你要强调一系列相关的产品对象的设计以便进行联合使用时。
 * 
 * 当你提供一个产品类库，而只想显示它们的接口而不是实现时。
 * <ul>
 * <li>{@link #FactoryMode()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月30日
 * 
 */
public class AbstractFactoryMode {

	private IFactoryMode factoryFood = new FactoryFoodImpl();

	private IFactoryMode factoryFurniture = new FactoryFurnitureImpl();

	public void produce() {
		factoryFood.produce();
		factoryFurniture.produce();
	}

	public static void main(String[] args) {
		AbstractFactoryMode factory = new AbstractFactoryMode();
		factory.produce();
	}

}
