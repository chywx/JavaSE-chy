package cn.year2021.jvm;

/**
 * javac ByteCodeSample.java
 * javap -verbose ByteCodeSample.class
 */
public class ByteCodeSample {

    public static int add(int a, int b) {
        int c = 0;
        c = a + b;
        return c;
    }

}
