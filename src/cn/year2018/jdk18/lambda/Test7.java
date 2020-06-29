package cn.year2018.jdk18.lambda;

public class Test7 {

    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        System.out.println(fact.call(5));
    }
}

interface IntCall {

    int call(int arg);
}
