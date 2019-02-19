package com.chy.design.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Person0219 zhangsan = new Student0219("张三");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person0219>(zhangsan);
//        InvocationHandler stuHandler = new StuInvocationHandler(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person0219 stuProxy = (Person0219) Proxy.newProxyInstance(Person0219.class.getClassLoader(), new Class<?>[]{Person0219.class}, stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveMoney();
    }
}
