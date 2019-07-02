package newcom.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    public static AtomicInteger i2 = new AtomicInteger(0);

    static int i = 0;

    public synchronized static void increment() {
//        System.out.println(Thread.currentThread().getName()+"---"+ ++i);
        System.out.println(Thread.currentThread().getName() + "---" + i2.incrementAndGet());
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 100; j++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    increment();
                }
            });
        }


//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int j = 0; j < 50; j++) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(50l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    increment();
//                    System.out.println(i);
//                }
//            }
//        };
//        new Thread(runnable).start();
//        new Thread(runnable).start();

    }


}
