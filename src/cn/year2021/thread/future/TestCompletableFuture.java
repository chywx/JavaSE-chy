package cn.year2021.thread.future;/**
 * @author chy
 * @date 2021/4/28 0028 下午 16:53
 * Description：
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/4/28 0028
 */
public class TestCompletableFuture {

    public static void main(String[] args) throws Exception {

        runAsync();
        supplyAsync();

    }

    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });

        future.get();
    }

    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = " + time);
    }

}
