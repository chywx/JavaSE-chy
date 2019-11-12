package com2018.test.abstrac;

public abstract class Fu {
    abstract void f();

    void f2() {
        System.out.println("f2");
    }

    final void f3() {
        System.out.println("f3");
    }
}
