package com.jdk18.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

import org.junit.Test;

public class Test1 {
    @Test
    public void testLambad() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);
        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println();
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        System.out.println();
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        String[] a = new String[2];
        a = list.toArray(a);
        System.out.println(a);
        for (String object : a) {
            System.out.println(object);
        }
    }

    // 这个时候就出错了，并发修改异常 concurrentmodificationexception,我去，只是最后一个才出错，也不是了，可能出错吧。
    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (String string : list) {
            if (string.equals("1"))
                list.remove(string);
        }
    }

    // 当你想循环遍历来进行删除操作的时候需要使用iterator来删除
    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.equals("2")) {
                iterator.remove();
            }
        }
    }

    // foreach方法是不是第一次使用，肯定啦，何况还是第一次听说，挺好的，都是
    @Test
    public void test4() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        Set<Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet);
        BiConsumer<? super String, ? super String> action = new BiConsumer<String, String>() {
            @Override
            public void accept(String t, String u) {
                System.out.println(t + u);
            }
        };
        map.forEach(action);
    }

    // hashtable是线程安全的，当然了也仅仅知道是线程安全，也不知道为什么，点开源码一看每个方法都有synchronized关键字
    @Test
    public void test5() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("1", "a");
        hashtable.put("2", "b");
        hashtable.put("3", "c");
        System.out.println(hashtable);
    }

    @Test
    public void test6() {

    }

    @Test
    public void test7() {

    }

    @Test
    public void test8() {

    }

    @Test
    public void test9() {

    }

    @Test
    public void test10() {

    }
}
