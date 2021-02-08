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
public class CountDownLatchDemo1 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + finalI + "完成检查");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            };
            service.submit(runnable);
        }
        System.out.println("等待5个人检查完。。。");
        latch.await();
        System.out.println("所有人都完成了工作，进入下一个环节");
    }

}
