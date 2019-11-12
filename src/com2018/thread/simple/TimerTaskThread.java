package com2018.thread.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//	笨死了，打印个名字都不会，麻痹的直接getname
public class TimerTaskThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + "	123");
        super.run();
    }

    public static void main(String[] args) {
        TimerTaskThread timerTaskThread = new TimerTaskThread();
        timerTaskThread.setName("线程1");
        new Thread(timerTaskThread).start();
        System.out.println(f1());
        System.out.println(f2());

        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        list.forEach(a -> System.out.println(a));
        list.forEach(System.out::print);
    }

    // 不要在final中写return语句，毕竟return应该属于逻辑代码。
    public static int f1() {
        int a;
        try {
            a = 2;
            return a;
        } finally {
            return 3;
        }
    }

    // npe我去，就是nullpointerexception问题，对于返回值为int，当其包装类为null是会报npe
    public static int f2() {
        Integer a = 1;
        // 也不知道这个optional类有什么用处
        Optional<Integer> empty = Optional.of(a);
        // Integer a = null;
        return a;
    }
}
