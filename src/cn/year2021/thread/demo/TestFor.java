package cn.year2021.thread.demo;/**
 * @author chy
 * @date 2021/1/11 0011 下午 14:41
 * Description：
 */

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示newFixedThreadPool
 *
 * @author chy
 * @date 2021/1/11 0011
 */
public class TestFor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });

        }
    }
}
