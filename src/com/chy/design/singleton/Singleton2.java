package com.chy.design.singleton;

// 懒汉线程安全
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {

    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
