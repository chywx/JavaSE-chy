package com2018.jdk18.lambda;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Test2 {
    public static void main(String[] args) {
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        // 1.2使用 lambda expression
        new Thread(() -> System.out.println("Hello world !")).start();

        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");

        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }

    private List<Integer> list = null;

    @Before
    public void init() {
        Integer[] arr = {1, 2, 3, 4};
        list = Arrays.asList(arr);
    }

    //刚开始觉得foreach既然有泛型指定，就感觉foreach挺多余，现在好多了，一行就OK
    //当只是一行代码，类似于if，直接不需要加{}
    @Test
    public void test1() {
        list.forEach((l) -> System.out.println(l));
    }

    //当foreach里面有多行代码，使用{}
    @Test
    public void test2() {
        list.forEach((l) -> {
            System.out.println(l);
            System.out.println(l + 1);
        });
    }

    //真不知道这个双冒号有什么用处，感觉就只是简单输出一下
    @Test
    public void test3() {
        list.forEach(System.out::println);
    }
}
