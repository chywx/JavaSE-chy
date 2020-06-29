package cn.year2019.thread.deadlock;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/9/23 0023
 */
public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        //o1 o2 代表资源
        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println("go go go!");
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (o1) {   //线程t1获取o1的锁才能继续执行
                    try {
                        Thread.sleep(3000);      //睡3秒，确保线程t2把o2锁拿走
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1获得了哦O1");
                    synchronized (o2) {                 //线程t1获取o2的锁才能继续执行
                        System.out.println("t1获得了哦O2");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (o2) {  //线程t2获取o2的锁才能继续执行
                    try {
                        Thread.sleep(3000);     //睡3秒，确保线程t1把o1锁拿走
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2获得了哦O2");
                    synchronized (o1) {             //线程t2获取o1的锁才能继续执行
                        System.out.println("t2获得了哦O1");
                    }
                }
            }
        });
        t1.start();
//        Thread.sleep(5000);// 注释了就会发生死锁
        t2.start();       //启动线程
    }
}
