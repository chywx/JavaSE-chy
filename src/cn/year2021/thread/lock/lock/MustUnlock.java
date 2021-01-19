package cn.year2021.thread.lock.lock;/**
 * @author chy
 * @date 2021/1/15 0015 下午 14:36
 * Description：
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述
 * look不像synchronized一样，异常自动释放锁
 *
 * @author chy
 * @date 2021/1/15 0015
 */
public class MustUnlock {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：开始执行任务");
        } finally {
            lock.unlock();
        }

        ArrayList<String> strings = new ArrayList<>();
        strings.add(null);
        System.out.println(strings);
    }
}
