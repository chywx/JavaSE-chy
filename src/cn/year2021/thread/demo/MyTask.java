package cn.year2021.thread.demo;/**
 * @author chy
 * @date 2021/1/11 0011 下午 16:44
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/11 0011
 */
public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
