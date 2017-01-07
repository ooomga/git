package design.abstractfactory.impl;

import design.abstractfactory.IFactoryMode;

/**
 * 
 * 家具工厂，生产家具
 * <ul>
 * <li>{@link #FactoryModeOneImpl()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月30日
 * 
 */
public class FactoryFurnitureImpl implements IFactoryMode {

	@Override
	public void produce() {
		System.err.println("家具工厂，现在正在生产家具");
	}

}
