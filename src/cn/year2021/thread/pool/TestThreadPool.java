package cn.year2021.thread.pool;/**
 * @author chy
 * @date 2021/4/19 0019 下午 14:57
 * Description：
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/4/19 0019
 */
public class TestThreadPool {

    private static ExecutorService freebetExecutorService = Executors.newFixedThreadPool(10);


    private static ScheduledExecutorService globalExecutorService = Executors.newScheduledThreadPool(20);


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            globalExecutorService.schedule(() -> {
                System.out.println("global:" + Thread.currentThread().getName() + "---" + finalI);
                freebetExecutorService.execute(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println("free bet:" + Thread.currentThread().getName() + "---" + finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }, 0, TimeUnit.SECONDS);
        }
    }


}
