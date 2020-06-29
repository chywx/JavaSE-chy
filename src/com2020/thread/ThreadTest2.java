package com2020.thread;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/29 0029
 */
public class ThreadTest2 implements Runnable {

    @Override
    public synchronized void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(" " + i);

        }

    }

    public static void main(String[] args) {

        // 不会有影响，因为不相干
//        ThreadTest2 r1 = new ThreadTest2();
//        ThreadTest2 r2 = new ThreadTest2();
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        t1.start();
//        t2.start();

        // 会有并发问题，run需要加synchronized
        ThreadTest2 r = new ThreadTest2();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

    }
}
