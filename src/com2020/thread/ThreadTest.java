package com2020.thread;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/1/13 0013
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(123);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(456);
        }).start();
        System.out.println(789);
    }

}
