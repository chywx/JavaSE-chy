package cn.year2021.thread.sleepwait;

public class YieldDemo {

    public static void main(String[] args) {
        Runnable yield = ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                if(i == 5){
                    Thread.yield();
                }
            }
        };
        Thread a = new Thread(yield, "A");
        Thread b = new Thread(yield, "B");
        a.start();
        b.start();
    }
}
