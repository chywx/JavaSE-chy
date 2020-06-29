package cn.year2018.yang.jdk8.imoccstudy;

import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;

public class MethodRefrenceDemo {
    public static void main(String[] args) {
        // 静态方法的方法引用
        IntUnaryOperator methodRefrence1 = DemoClass::staticMethod;

        System.out.println(methodRefrence1.applyAsInt(111));

        DemoClass demo = new DemoClass();

        // 实例方法的方法引用
        IntUnaryOperator methodRefrence2 = demo::normalMethod;
        System.out.println(methodRefrence2.applyAsInt(222));

        BiFunction<DemoClass, Integer, Integer> normalMethod = DemoClass::normalMethod;
        System.out.println(normalMethod.apply(demo, 333));

    }

}

class DemoClass {

    /**
     * 这里是一个静态方法
     */
    public static int staticMethod(int i) {
        System.out.println("staticMethod");
        return i * 2;
    }

    /**
     * 这里是一个实例方法
     */
    public int normalMethod(int i) {
        System.out.println("实例方法可以访问this:" + this);
        return i * 3;
    }

}