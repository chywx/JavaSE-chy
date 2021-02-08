package cn.year2021.flowcontrol.countdownlatch;/**
 * @author chy
 * @date 2021/2/7 0007 下午 14:20
 * Description：
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 到终点100米后比赛结束
 *
 * @author chy
 * @date 2021/2/7 0007
 */
public class CountDownLatchDemoAnd2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
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
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + finalI + "跑到终点了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            service.submit(runnable);
        }
        Thread.sleep(5000L);
        System.out.println("发令枪响了，比赛开始！");
        begin.countDown();

        end.await();
        System.out.println("所有人到达终点，比赛结束");


    }

}
