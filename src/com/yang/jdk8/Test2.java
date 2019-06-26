package com.yang.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("lambda");
    }

    List<String> list = Arrays.asList("aaa", "ccc", "bbb");

    @Test
    public void test1() {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

    @Test
    public void test2() {
        Collections.sort(list, (Comparator<? super String>) (String a, String b) -> {
            return a.compareTo(b);
        });
        System.out.println(list);
    }

    @Test
    public void test3() {
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println(list);
        list.forEach((p) -> System.out.println(p));
    }
}