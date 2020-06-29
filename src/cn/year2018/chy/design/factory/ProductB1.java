package cn.year2018.chy.design.factory;

public class ProductB1 implements ProductB {
    // 等级为2的产品A
    @Override
    public void method1() {
        System.out.println("等级为2的产品A的实现方法");
    }

    @Override
    public void method2() {
        // 业务逻辑处理代码
    }
    // 更多产品逻辑.....
}
