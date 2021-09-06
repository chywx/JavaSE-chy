package cn.year2021.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chy
 * @date 2021年09月06日 下午 13:32
 */
public class RrecursionTest {

    //题目：台阶共n层，每次只能走1步或2步，一共多少走法。

    //方案1-递归
    private static long d1(long n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return d1(n - 1) + d1(n - 2);
    }

    private static Map<Long, Long> map = new HashMap<>();

    private static long d2(long n) {
        Long aLong = map.get(n);
        if (aLong != null) {
            return aLong;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        Long value = d2(n - 1) + d2(n - 2);
        map.put(n, value);
        return value;
    }


    //方案2-循环
    private static long loop(long n) {
        if (n == 1 || n == 2) {
            return n;
        }

        long one = 2;
        long two = 1;
        long sum = 0;

        for (long i = 3; i < n + 1; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        long n = 50;
        long time1 = System.currentTimeMillis();
        System.out.println(d2(n));
        long time2 = System.currentTimeMillis();
        System.out.println("f time: " + (time2 - time1));
        System.out.println(loop(n));
        long time3 = System.currentTimeMillis();
        System.out.println("loop time: " + (time3 - time2));
    }
}
