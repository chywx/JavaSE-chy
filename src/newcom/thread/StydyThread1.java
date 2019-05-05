package newcom.thread;

import java.util.concurrent.TimeUnit;

public class StydyThread1 extends Thread{

    private int i = 100;

    @Override
    public void run() {
        for (int j = 0; j < 50; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + --i);
        }
    }

    public static void main(String[] args) {
        StydyThread1 stydyThread = new StydyThread1();
        new Thread(stydyThread).start();
        new Thread(stydyThread).start();
    }

}
