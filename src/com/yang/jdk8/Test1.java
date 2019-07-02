package com.yang.jdk8;

public class Test1 implements Demo1Face {

    @Override
    public void f1() {

    }

    // 抽象类是不可以被创建，只能去继承。
    public static void main(String[] args) {
        Demo1Face test1 = new Test1();
        test1.f2();
    }
}

interface Demo1Face {
    public void f1();

    public default void f2() {
        System.out.println("接口可以写方法了。");
    }
}