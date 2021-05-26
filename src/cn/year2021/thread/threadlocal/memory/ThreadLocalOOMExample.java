package cn.year2021.thread.threadlocal.memory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chy
 * @date 2021年05月26日 上午 11:03
 * threadlocal调用remove方法，是个好的习惯
 * ThreadLocalMap使用的是线性探测法
 * 但是，如果线程执行完毕归还线程池或者销毁，ThreadLocal的get和set方法都有很高的概率会顺便清理掉无效对象，断开value强引用，从而大对象被收集器回收
 */
public class ThreadLocalOOMExample {

    /**
     * 定义一个 10m 大的类
     */
    static class MyTask {

        // 创建一个 10m 的数组（单位转换是 1M -> 1024KB -> 1024*1024B）
        private byte[] bytes = new byte[10 * 1024 * 1024];
    }

    // 定义 ThreadLocal
    private static ThreadLocal<MyTask> taskThreadLocal = new ThreadLocal<>();

    // 主测试代码
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(3, 3, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
        // 执行 10 次调用
        for (int i = 0; i < 10; i++) {
            // 执行任务
            executeTask(threadPoolExecutor);
            Thread.sleep(1000);
        }
    }

    /**
     * 线程池执行任务
     *
     * @param threadPoolExecutor 线程池
     */
    private static void executeTask(ThreadPoolExecutor threadPoolExecutor) {
        // 执行任务
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建对象");
                // 创建对象（10M）
                MyTask myTask = new MyTask();
                // 存储 ThreadLocal
                taskThreadLocal.set(myTask);
                // 将对象设置为 null，表示此对象不在使用了
                myTask = null;
            }
        });
    }
}
