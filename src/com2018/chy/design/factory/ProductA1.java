package com2018.chy.design.factory;

public class ProductA1 implements ProductA {
    // 等级为1的产品A
    @Override
    public void method1() {
        System.out.println("等级为1的产品A的实现方法");
    }

    @Override
    public void method2() {
        // 业务逻辑处理代码
    }
    // 更多产品逻辑.....

}
