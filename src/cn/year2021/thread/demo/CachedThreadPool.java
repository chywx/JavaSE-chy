package cn.year2021.thread.demo;/**
 * @author chy
 * @date 2021/1/11 0011 下午 16:32
 * Description：
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/11 0011
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });

        }
    }

}
