package com.test.abstrac;

public class Zi extends Fu {

    // f方法必须重写
    @Override
    void f() {

    }

    // f2方法可以选择实现
    @Override
    void f2() {
        super.f2();
    }

    // f3方法不能实现，因为使用了final修饰
}
