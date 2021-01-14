package cn.year2021.thread.demo;/**
 * @author chy
 * @date 2021/1/12 0012 下午 14:08
 * Description：
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *功能描述 
 * @author chy
 * @date 2021/1/12 0012
 */
public class PauseableThreadPool extends ThreadPoolExecutor {

    public PauseableThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}
