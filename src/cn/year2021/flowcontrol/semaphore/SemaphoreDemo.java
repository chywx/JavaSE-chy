package cn.year2021.flowcontrol.semaphore;/**
 * @author chy
 * @date 2021/2/7 0007 下午 16:42
 * Description：
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/7 0007
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(3, true);


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }


    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了许可证");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "释放了许可证");
            semaphore.release();

        }
    }
}
