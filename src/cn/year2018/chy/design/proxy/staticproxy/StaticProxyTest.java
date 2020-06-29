package cn.year2018.chy.design.proxy.staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        //被代理的学生张三，他的班费上交有代理对象monitor（班长）完成
        Person0219 zhangsan = new Student0219("张三");

        //生成代理对象，并将张三传给代理对象
        Person0219 monitor = new StudentsProxy0219(zhangsan);

        //班长代理上交班费
        monitor.giveMoney();
    }
}
