package com.chy.design.factory;

public interface AbstractFactory {
	// 创建产品A
	public ProductA factoryA();

	// 创建产品B
	public ProductB factoryB();
	// 更多创建产品.....

}
