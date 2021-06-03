package cn.year2021.thread.cas;/**
 * @author chy
 * @date 2021/1/25 0025 下午 17:55
 * Description：
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/25 0025
 */
public class SimulatedCAS implements Runnable {

    private volatile int value;

    public synchronized int cas(int expectedValue, int newValue) {

        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;

    }

    public static void main(String[] args) throws InterruptedException {
        SimulatedCAS simulatedCAS = new SimulatedCAS();
        Thread t1 = new Thread(simulatedCAS);
        Thread t2 = new Thread(simulatedCAS);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(simulatedCAS.value);

        new AtomicInteger();
    }

    @Override
    public void run() {
        cas(0, 1);

    }
}
