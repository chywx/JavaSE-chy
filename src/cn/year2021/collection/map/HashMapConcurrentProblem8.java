package cn.year2021.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chy
 * @date 2021年06月04日 下午 15:35
 */
public class HashMapConcurrentProblem8 extends Thread {

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private static AtomicInteger at = new AtomicInteger(0);


    @Override
    public void run() {
        while (at.get() < 1000000) {
            map.put(at.get(), at.get());
            at.incrementAndGet();
            System.out.println(at.get());
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size:" + map.size());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new HashMapConcurrentProblem8();
            thread.start();
        }
    }

}
