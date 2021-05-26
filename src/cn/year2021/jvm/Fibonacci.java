package cn.year2021.jvm;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        System.out.println(a + 1);
        System.out.println(a + a + 1);
        System.out.println(a + a + 3);
        System.out.println();
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));

        System.out.println(">>>>>>>>");
        System.out.println(fibonacci(1000000));
    }
}
