package cn.year2018.jdk18.lambda;

import java.util.function.Function;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/29 0029
 */
public class Curry3Args {

    public static void main(String[] args) {
        Function<String,
            Function<String,
                Function<String, String>>> sum =
            a -> b -> c -> a + b + c;
        Function<String,
            Function<String, String>> hi =
            sum.apply("Hi ");
        Function<String, String> ho =
            hi.apply("Ho ");
        System.out.println(ho.apply("Hup"));
    }
}
