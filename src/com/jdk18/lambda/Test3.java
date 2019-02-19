package com.jdk18.lambda;

public class Test3 {
	public static void main(String[] args) {
		//不加tostring方法，默认打印全路径名，就是类型是带@加数字
		//一直在写thread，实现runable接口，自己写了一个简单的，不过如此
		//打脸了，他妈的传一个参数就不会了，还是先注释了吧。
		A a = new A(new B() {
			@Override
			public String f(String p1) {
				return "hello world";
			}
//			@Override
//			public void f() {
//				System.out.println("f");
//			}
//			@Override
//			public void f(String a) {
//				System.out.println(a+",hello");
//			}
//			@Override
//			public void f2() {
//				System.out.println("f2");
//			}
		});
		System.out.println(a.f1());
		//The target type of this expression must be a functional interface
		//这个时候就出错了，原因是必须只能有一个函数
//		new A(()->System.out.println("hello world")).f1();
//		new A((String aaa) -> System.out.print(aaa+",haha"));
		String f1 = new A((String aaa) -> (aaa)).f1();
		System.out.println(f1);
		
	}
}
class A{
	B b;
	// 
	public A(B b) {
		String f = b.f("abcd");
		System.out.println(f);
//		b.f();
		this.b = b;
	}
	String f1(){
		return "A返回的数据";
	}
	@Override
	public String toString() {
		return "A [b=" + b + "]";
	}
	
}
interface B{
	String f(String p1);
//	void f(String p1);
//	void f();
	//void f2();
}
