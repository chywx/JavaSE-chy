package cn.year2022.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestJavap {

    public static Integer sum = 0;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            service.submit(() -> print());
        }

    }

    public static synchronized void print() {
        sum++;
        System.out.println(sum);
    }

}
