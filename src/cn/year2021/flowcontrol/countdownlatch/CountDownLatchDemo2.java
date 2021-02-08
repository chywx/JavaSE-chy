package cn.year2021.flowcontrol.countdownlatch;/**
 * @author chy
 * @date 2021/2/7 0007 下午 14:20
 * Description：
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个线程等待多个线程执行完毕CountDownLatchDemo1
 *
 * @author chy
 * @date 2021/2/7 0007
 */
public class CountDownLatchDemo2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + finalI + "准备完毕，等待发抢");
                    try {
                        begin.await();
                        System.out.println("No." + finalI + "开始跑步了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.submit(runnable);
        }
        Thread.sleep(5000L);
        begin.countDown();
        System.out.println("发令枪响了");
    }

}
