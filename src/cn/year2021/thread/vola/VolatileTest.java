package cn.year2021.thread.vola;/**
 * @author chy
 * @date 2021/2/22 0022 下午 14:43
 * Description：
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并不能每次都到1w
 * volatile只能保证可见性，并不能保证原子性
 * i++操作是不具备原子性的
 * 它包括读取变量的原始值、进行加1操作、写入工作内存。
 *
 * @author chy
 * @date 2021/2/22 0022
 */
public class VolatileTest {

//    public static int count = 0;

    public static volatile int count = 0;


    public static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    count++;//每个线程执行加100
                    System.out.println(count);
//                    add();
                }
            });
        }
    }

    public static synchronized void add() {
        count++;//保证count加一的操作是原子的
        System.out.println(count);
    }

}
