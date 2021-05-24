package cn.year2021.thread.sleepwait;

public class WaitSleepDemo3 {
    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        new Thread(()->{
            System.out.println("thread A is waiting to get lock");
            synchronized (obj){
                try {
                    System.out.println("thread A get lock");
                    Thread.sleep(20);
                    System.out.println("thread A do wait method");
                    obj.wait();
                    System.out.println("thread A is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            System.out.println("thread C is waiting to get lock");
            synchronized (obj){
                try {
                    System.out.println("thread C get lock");
                    Thread.sleep(20);
                    System.out.println("thread C do wait method");
                    obj.wait();
                    System.out.println("thread C is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);

        new Thread(()->{
            System.out.println("thread B is waiting to get lock");
            synchronized (obj){
                try {
                    System.out.println("thread B get lock");
                    System.out.println("thread B is sleeping 10 ms");
                    Thread.sleep(10);
                    System.out.println("thread B is done");
                    obj.notifyAll();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
