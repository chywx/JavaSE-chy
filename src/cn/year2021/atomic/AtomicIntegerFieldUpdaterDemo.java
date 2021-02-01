package cn.year2021.atomic;/**
 * @author chy
 * @date 2021/1/25 0025 上午 11:43
 * Description：
 */

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/25 0025
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {

    static Candidate tom;

    static Candidate peter;

    public static AtomicIntegerFieldUpdater scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");


    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            peter.score++;
            scoreUpdater.getAndIncrement(tom);
        }

    }

    public static class Candidate {

        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdaterDemo r = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通变量：" + peter.score);
        System.out.println("升级后的结果：" + tom.score);
    }
}
