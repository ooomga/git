package design.abstractfactory.impl;

import design.abstractfactory.IFactoryMode;

/**
 * 食物工厂，生产食物
 * <ul>
 * <li>{@link #FactoryModeOneImpl()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月30日
 * 
 */
public class FactoryFoodImpl implements IFactoryMode {

	@Override
	public void produce() {
		System.err.println("食物工厂，现在正在生产食物");
	}

}
