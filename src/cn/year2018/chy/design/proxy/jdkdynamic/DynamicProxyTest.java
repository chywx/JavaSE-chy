package cn.year2018.chy.design.proxy.jdkdynamic;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Person0219 zhangsan = new Student0219("李四");

        MyInvocationHandler handler = new MyInvocationHandler(zhangsan);
        Person0219 stuProxy = (Person0219) handler.getProxy();

        stuProxy.giveMoney();

    }


    @Test
    public void test2() {
        //创建一个实例对象，这个对象是被代理的对象
        Person0219 zhangsan = new Student0219("李四");

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        MyInvocationHandler handler = new MyInvocationHandler(zhangsan);
        Person0219 stuProxy = (Person0219) handler.getProxy();

        //代理执行上交班费的方法
        stuProxy.giveMoney();

    }

    @Test
    public void test1() {
        //创建一个实例对象，这个对象是被代理的对象
        Person0219 zhangsan = new Student0219("张三");

        //创建一个与代理对象相关联的InvocationHandler
        MyInvocationHandler2 stuHandler = new MyInvocationHandler2<Person0219>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person0219 stuProxy = (Person0219) Proxy.newProxyInstance(Person0219.class.getClassLoader(), new Class<?>[]{Person0219.class}, stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveMoney();
    }

}
