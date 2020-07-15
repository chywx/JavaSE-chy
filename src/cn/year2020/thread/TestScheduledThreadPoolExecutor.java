package cn.year2020.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/7/15 0015
 */
public class TestScheduledThreadPoolExecutor {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        System.out.println(new Date());
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ">>>" + new Date());
            // 延迟5秒后执行
            ScheduledFuture<Double> schedule = scheduledExecutorService.schedule(() -> {
                System.out.println(Thread.currentThread().getName() + ">>>" + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double random = Math.random();
                System.out.println("random>>>" + random);
                return random;
            }, 1, TimeUnit.SECONDS);

//            try {
//                // 调用get方法会变成同步
//                Double aDouble = schedule.get();
//                System.out.println("get>>>" + aDouble);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(new Date());

        scheduledExecutorService.shutdown();


    }

}
