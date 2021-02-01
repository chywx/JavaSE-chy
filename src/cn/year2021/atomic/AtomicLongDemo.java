package cn.year2021.atomic;/**
 * @author chy
 * @date 2021/2/1 0001 下午 15:59
 * Description：
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/1 0001
 */
public class AtomicLongDemo {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0);

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Task(atomicLong));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println(atomicLong.get());
        System.out.println("执行了：" + (System.currentTimeMillis() - l) + "ms");

    }

    private static class Task implements Runnable {

        private AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }

        }
    }

}
