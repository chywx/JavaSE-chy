package cn.year2021.collection.map;/**
 * @author chy
 * @date 2021/2/2 0002 下午 18:59
 * Description：
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/2 0002
 */
public class TestCurrent {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Object, Integer> map = new ConcurrentHashMap<>();
        map.put("hello", 0);

//        Runnable runnable = () -> {
//            for (int i = 0; i < 10000; i++) {
//                synchronized (TestCurrent.class) {
//                    Integer hello = map.get("hello");
//                    Integer newHello = hello + 1;
//                    map.put("hello", newHello);
//                }
//            }
//        };

        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                while (true) {
                    Integer hello = map.get("hello");
                    Integer newHello = hello + 1;
                    boolean b = map.replace("hello", hello, newHello);
                    if (b) {
                        break;
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.get("hello"));
    }

}
