package cn.year2018.jdk18.lambda;

import java.util.function.Function;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/29 0029
 */
public class CurryingAndPartials {

    // 未柯里化:
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 柯里化的函数:
        Function<String, Function<String, String>> sum =
            a -> b -> a + b; // [1]

        System.out.println(uncurried("Hi ", "Ho"));

        Function<String, String>
            hi = sum.apply("Hi "); // [2]
        System.out.println(hi.apply("Ho"));

        // 部分应用:
        Function<String, String> sumHi =
            sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
