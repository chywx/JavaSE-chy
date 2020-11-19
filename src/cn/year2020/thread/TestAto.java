package cn.year2020.thread;/**
 * @author lql
 * @date 2020/9/16 0016 上午 10:31
 * Description：
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/9/16 0016
 */
public class TestAto {

    public static AtomicInteger onlineNum = new AtomicInteger();
    public static int num = 0;

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int incr = onlineNum.incrementAndGet();
                num++;
                System.out.println(Thread.currentThread().getName() + ">>>" + num + ">>>" + incr);
            }

        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
