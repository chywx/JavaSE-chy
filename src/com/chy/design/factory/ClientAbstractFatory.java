package com.chy.design.factory;

// 妈了个弊
public class ClientAbstractFatory {
	// 客户端--调用者
	public static void main(String[] args) {
		// 定义两个工厂，等级为1和等级为2
		ConcreateFactory1 factory1 = new ConcreateFactory1();
		ConcreateFactory2 factory2 = new ConcreateFactory2();
		// 定义A产品的不同系列产品
		ProductA a1 = factory1.factoryA();
		ProductA a2 = factory2.factoryA();
		// 定义A产品的不同系列产品
		ProductB b1 = factory1.factoryB();
		ProductB b2 = factory2.factoryB();
		// 业务逻辑
		a1.method1();
		b1.method1();
		a2.method1();
		b2.method1();
		// 更多业务逻辑....
	}

}
