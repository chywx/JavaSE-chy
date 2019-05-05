package com.chy.design.proxy.cglib;

import org.junit.Test;

/**
 * 被代理对象与其说必须要有无参构造，不如说只需要无参构造
 */
public class CglibProxyTest {
    @Test
    public void test1() {
        MyMethodInterceptor interceptor = new MyMethodInterceptor();
        Person0505 instance = (Person0505)interceptor.getInstance(new Person0505());
        instance.setName("陈海洋");
        instance.giveMoney();
    }

    @Test
    public void test2() {
        MyMethodInterceptor2 interceptor = new MyMethodInterceptor2();
        Person0505 instance = interceptor.getInstance(new Person0505());
        instance.setName("大海");
        instance.giveMoney();
    }
}
