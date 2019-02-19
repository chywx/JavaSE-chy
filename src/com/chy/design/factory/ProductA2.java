package com.chy.design.factory;

public class ProductA2 implements ProductA{
	// 等级为2的产品A
	@Override
	public void method1() {
		System.out.println("等级为2的产品B的实现方法");
	}

	@Override
	public void method2() {
		// 业务逻辑处理代码
	}
	// 更多产品逻辑.....

}
