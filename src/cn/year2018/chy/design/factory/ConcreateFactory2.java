package cn.year2018.chy.design.factory;

public class ConcreateFactory2 implements AbstractFactory {
    // 建造者
    @Override
    public ProductA factoryA() {
        // 生产等级为1的产品A,即A1
        return new ProductA1();
    }

    @Override
    public ProductB factoryB() {
        // 生产等级为1的产品B,即B1
        return new ProductB1();
    }
    // 更多代码逻辑......

}
