package cn.year2022.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Dylan
 * @date: 2022/7/25 16:29
 */
public class TestLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            System.out.println("aaa" + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        }).start();
        new Thread(() -> {
            lock.lock();
            System.out.println("bbb" + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        }).start();
        System.out.println("end");
    }

    public void aaa() {

    }

}
