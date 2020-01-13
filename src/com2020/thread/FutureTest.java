package com2020.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/1/13 0013
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(123);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(() -> {
            System.out.println("子线程在计算");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("子线程计算完毕");
            return 100;
        });
        System.out.println(456);
        Integer integer = submit.get();
        System.out.println(integer);
        executorService.shutdown();
        System.out.println(789);
    }

}
