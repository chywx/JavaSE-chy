package com.chy.design.singleton;

// 恶汉式
public class Singleton3 {
	private static Singleton3 singleton3 = new Singleton3();
	private Singleton3() {
		
	}
	public static Singleton3 getInstance() {
		return singleton3;
	}
}
