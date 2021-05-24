package cn.year2021.thread.sleepwait;

public class WaitSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        new Thread(()->{
            System.out.println("thread A is waiting to get lock");
            synchronized (obj){
                try {
                    System.out.println("thread A get lock");
                    Thread.sleep(20);
                    System.out.println("thread A do wait method");
                    obj.wait(1000);
                    System.out.println("thread A is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(10);

        new Thread(()->{
            System.out.println("thread B is waiting to get lock");
            synchronized (obj){
                try {
                    System.out.println("thread B get lock");
                    System.out.println("thread B is sleeping 10 ms");
                    Thread.sleep(10);
                    System.out.println("thread B is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
