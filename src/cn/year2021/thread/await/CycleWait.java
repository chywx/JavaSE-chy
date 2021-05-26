package cn.year2021.thread.await;

public class CycleWait implements Runnable {

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "hello world";

    }

    public static void main(String[] args) throws InterruptedException {

        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        t.start();
        t.join();
        System.out.println(cycleWait.value);
    }

    public static void main0(String[] args) throws InterruptedException {

        CycleWait cycleWait = new CycleWait();
        Thread t = new Thread(cycleWait);
        t.start();
        while (cycleWait.value == null){
                Thread.sleep(100);
        }
        System.out.println(cycleWait.value);
    }


}
