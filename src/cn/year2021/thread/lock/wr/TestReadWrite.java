package cn.year2021.thread.lock.wr;/**
 * @author chy
 * @date 2021/1/19 0019 下午 14:34
 * Description：
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/19 0019
 */
public class TestReadWrite {

    private static WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
    private static ReadLock readLock = new ReentrantReadWriteLock().readLock();

    public static void main(String[] args) {

        new Thread(() -> read(), "A").start();
        new Thread(() -> read(), "B").start();
        new Thread(() -> write(), "C").start();
        new Thread(() -> write(), "D").start();

    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":开始写入");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":写入完毕");
        } finally {
            writeLock.unlock();
        }
    }

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":开始读取");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":写入读取完毕");
        } finally {
            readLock.unlock();
        }

    }

}
