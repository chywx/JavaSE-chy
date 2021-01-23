package cn.year2021.atomic;/**
 * @author chy
 * @date 2021/1/23 0023 下午 15:05
 * Description：
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/23 0023
 */
public class AtomicIntegerDemo implements Runnable {

    public AtomicInteger atomicInteger = new AtomicInteger();

    public void operaAtomic() {
        atomicInteger.getAndIncrement();
    }

    public volatile Integer integer = 0;

    public void operaInteger() {
        integer++;
    }

    public static void main(String[] args) {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        new Thread(demo).start();
        new Thread(demo).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo.atomicInteger.get());
        System.out.println(demo.integer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            operaAtomic();
            operaInteger();
        }
    }
}
