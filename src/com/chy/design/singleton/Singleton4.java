package com.chy.design.singleton;

// 双重检验
public class Singleton4 {
    private static Singleton4 singleton4 = null;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (singleton4) {
                if (singleton4 == null) {
                    return new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
