package com.yang.jdk8;

@FunctionalInterface
public interface Test3 {
    public void test1(String y);

}

class Demo3 {
    public static void main(String[] args) {
        Test3 m = p -> System.out.println("hello:" + p);
        m.test1("chy");
    }

}
