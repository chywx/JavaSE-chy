package cn.year2021.thread.look.look;/**
 * @author chy
 * @date 2021/1/15 0015 下午 14:40
 * Description：
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述
 * 用tryLock来避免死锁
 *
 * @author chy
 * @date 2021/1/15 0015
 */
public class TryLockDeadlock implements Runnable {

    int flag = 1;
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (flag == 1) {
                try {
                    if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("线程1获取到了锁1");
                            Thread.sleep(new Random().nextInt(1000));

                            if (lock2.tryLock(200, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("线程2获取到了锁2");
                                    System.out.println("线程1成功获取到了两把锁");
                                } finally {
                                    lock2.unlock();
                                }
                            } else {
                                System.out.println("线程2获取锁2失败，已重试");
                            }

                        } finally {
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程1获取锁1失败，已重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
