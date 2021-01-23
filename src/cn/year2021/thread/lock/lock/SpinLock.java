package cn.year2021.thread.lock.lock;/**
 * @author chy
 * @date 2021/1/22 0022 下午 18:10
 * Description：
 */

import java.util.concurrent.atomic.AtomicReference;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/22 0022
 */
public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();


    public void lock() {
        Thread thread = Thread.currentThread();
        while (!sign.compareAndSet(null, thread)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ":重试中。。。。。。");
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        sign.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + ":开始尝试获取自旋锁");
            spinLock.lock();
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                spinLock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + ":获取到了自旋锁");
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
