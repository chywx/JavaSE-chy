package com2018.thread.volatiles;

public class TestVolatile {
    static volatile boolean stop;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop) {
                    System.out.println("工作使我快乐");
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
            stop = true;
            System.out.println("下班了，该休息了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
