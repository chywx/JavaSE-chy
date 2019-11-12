package com2018.yang.jdk8.csdnxiaoliu;


import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * https://blog.csdn.net/javaYouCome/article/details/86480588
 * Function<T, R>：接受一个参数T，返回结果R
 * Predicate<T>：接受一个参数T，返回boolean
 * Supplier<T>：不接受任何参数，返回结果T
 * Consumer<T>：接受一个参数T，不返回结果
 */
public class TestFunction {


    @Test
    public void test1() {
        Function<String, String> function = s -> s + " 你好!";
        String apply = function.apply("hello world");
        System.out.println(apply);
    }

    @Test
    public void test2() {
        Predicate<Integer> predicate = integer -> integer % 2 == 0;
        boolean test = predicate.test(4);
        System.out.println(test);
    }

    @Test
    public void test3() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello world");
    }

    @Test
    public void test4() {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());
    }

}
