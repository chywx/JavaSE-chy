package cn.year2021.thread.demo;/**
 * @author chy
 * @date 2021/1/11 0011 下午 14:47
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
public class FixThreadPoolOOM {

    /*
    Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(i);
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000000000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
