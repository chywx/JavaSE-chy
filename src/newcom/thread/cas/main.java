package newcom.thread.cas;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/7/24 0024
 */
public class main {
    public static void main(String[] args) {
        System.out.println("START -- ");
        calc();
        calcSynchro();
        calcAtomic();

        testThreadsSync();
        testThreadsAtomic();

        testThreadsSync2();
        testThreadsAtomic2();
        System.out.println("-- FINISHED ");
    }

    private static void calc() {
        stopwatch sw = new stopwatch();
        sw.start();
        long val = 0;
        while (val < 10000000L) {
            val++;
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" calc() elapsed (ms): " + milSecds);
    }

    private static void calcSynchro() {
        stopwatch sw = new stopwatch();
        sw.start();
        long val = 0;
        while (val < 10000000L) {
            synchronized (main.class) {
                val++;
            }
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" calcSynchro() elapsed (ms): " + milSecds);
    }

    private static void calcAtomic() {
        stopwatch sw = new stopwatch();
        sw.start();
        AtomicLong val = new AtomicLong(0);
        while (val.incrementAndGet() < 10000000L) {
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" calcAtomic() elapsed (ms): " + milSecds);
    }

    private static void testThreadsSync() {
        stopwatch sw = new stopwatch();
        sw.start();
        Thread t1 = new Thread(new LoopSync());
        t1.start();
        Thread t2 = new Thread(new LoopSync());
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" testThreadsSync() 1 thread elapsed (ms): " + milSecds);
    }

    private static void testThreadsAtomic() {
        stopwatch sw = new stopwatch();
        sw.start();
        Thread t1 = new Thread(new LoopAtomic());
        t1.start();
        Thread t2 = new Thread(new LoopAtomic());
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" testThreadsAtomic() 1 thread elapsed (ms): " + milSecds);
    }

    private static void testThreadsSync2() {
        stopwatch sw = new stopwatch();
        sw.start();
        Thread t1 = new Thread(new LoopSync());
        t1.start();
        Thread t2 = new Thread(new LoopSync());
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" testThreadsSync() 2 threads elapsed (ms): " + milSecds);
    }

    private static void testThreadsAtomic2() {
        stopwatch sw = new stopwatch();
        sw.start();
        Thread t1 = new Thread(new LoopAtomic());
        t1.start();
        Thread t2 = new Thread(new LoopAtomic());
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        sw.stop();
        long milSecds = sw.getElapsedTime();
        System.out.println(" testThreadsAtomic() 2 threads elapsed (ms): " + milSecds);
    }

    private static class LoopAtomic implements Runnable {
        @Override
        public void run() {
            AtomicLong val = new AtomicLong(0);
            while (val.incrementAndGet() < 10000000L) {
            }
        }
    }

    private static class LoopSync implements Runnable {
        @Override
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                synchronized (main.class) {
                    val++;
                }
            }
        }
    }
}

class stopwatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }
    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }
    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }
}
