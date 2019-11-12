package com2018.chy.design.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler2<T> implements InvocationHandler {
    //invocationHandler持有的被代理对象
    T target;

    public MyInvocationHandler2(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        //代理过程中插入监测方法,计算该方法耗时
        Object result = method.invoke(target, args);
        return result;
    }
}
