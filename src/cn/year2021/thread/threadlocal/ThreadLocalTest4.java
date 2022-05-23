package cn.year2021.thread.threadlocal;/**
 * @author chy
 * @date 2021/1/12 0012 下午 18:10
 * Description：
 */

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/12 0012
 */
public class ThreadLocalTest4 {

    public static void main(String[] args) {
        RejectedExecutionHandler aaa = (Runnable r, ThreadPoolExecutor executor) -> {
            System.out.println(executor.getQueue().size() + "消息队列已满");
            System.out.println("拒绝服务" + Thread.currentThread().getName());
        };

        AtomicInteger poolNumber = new AtomicInteger(1);

        ThreadFactory tb = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("aaa>>>>" + poolNumber.incrementAndGet() + "" + ">>>>");

                return thread;
            }
        };

        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 100L, TimeUnit.SECONDS, queue, tb, aaa);

        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(runnable);
        }

    }

}
