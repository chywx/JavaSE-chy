package cn.year2021.thread.lock.lock;/**
 * @author chy
 * @date 2021/1/21 0021 下午 16:52
 * Description：
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/21 0021
 */
public class TestHello {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        Runnable runnable = () -> {
            boolean b = false;
            try {
                b = reentrantLock.tryLock(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (b) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "未获取到锁");
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
