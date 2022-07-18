package cn.year2022.list;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: Dylan
 * @date: 2022/7/14 12:23
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3, true);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        System.out.println(queue);

        new Thread(() -> {
            try {
                queue.put("aa");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("bb");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        String take = queue.take();
        System.out.println(take);
        System.out.println(queue);

        String take2 = queue.take();
        System.out.println(take2);
        System.out.println("end");

    }

}
