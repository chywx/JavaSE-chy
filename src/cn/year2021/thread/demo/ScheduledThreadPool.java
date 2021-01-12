package cn.year2021.thread.demo;/**
 * @author chy
 * @date 2021/1/11 0011 下午 16:42
 * Description：
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/11 0011
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.schedule(new MyTask(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new MyTask(), 1, 3, TimeUnit.SECONDS);
    }

}
