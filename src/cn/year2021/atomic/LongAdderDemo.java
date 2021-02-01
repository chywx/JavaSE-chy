package cn.year2021.atomic;/**
 * @author chy
 * @date 2021/2/1 0001 下午 15:59
 * Description：
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/1 0001
 */
public class LongAdderDemo {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Task(longAdder));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println(longAdder.sum());
        System.out.println("执行了：" + (System.currentTimeMillis() - l) + "ms");

    }

    private static class Task implements Runnable {

        private LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }

        }
    }

}
