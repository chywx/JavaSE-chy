package com.chy.design.singleton;

// 静态内部类持有
public class Singleton5 {
	private Singleton5() {
		
	}
	private static class SingletonHolder{
		private static Singleton5 singleton5 = new Singleton5();
	}
	public static Singleton5 getInstance() {
		return SingletonHolder.singleton5;
	}
	public static void main(String[] args) {
		main(null);
	}
}
