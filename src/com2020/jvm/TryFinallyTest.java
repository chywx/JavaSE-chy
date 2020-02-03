package com2020.jvm;

/**
 *
 * @author chy
 * @date 2020/2/1 0001
 */
public class TryFinallyTest {

    public static void main(String[] args) {
        System.out.println(f1());
    }

    public static String f1() {
        String str = "hello";
        try {
//            int i = 1 / 0;
            return str;
        } finally {
            str = "world";
        }
    }

}
