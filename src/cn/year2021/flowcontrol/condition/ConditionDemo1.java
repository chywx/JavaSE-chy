package cn.year2021.flowcontrol.condition;/**
 * @author chy
 * @date 2021/2/8 0008 上午 11:30
 * Description：
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示condition的基本用法
 *
 * @author chy
 * @date 2021/2/8 0008
 */
public class ConditionDemo1 {


    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    void f1() throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程沉睡，await 中。。。");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "线程已被唤醒。。。");
        } finally {
            lock.unlock();
        }
    }


    void f2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "去唤醒");
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ConditionDemo1 demo = new ConditionDemo1();
        new Thread(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.f2();
        }).start();
        demo.f1();

    }

}
