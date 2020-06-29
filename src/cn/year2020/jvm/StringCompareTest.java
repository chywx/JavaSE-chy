package cn.year2020.jvm;

/**
 * String == 测试
 *
 * @author chy
 * @date 2020/2/1 0001
 */
public class StringCompareTest {

    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.println((hello == "Hello"));
        System.out.println((Other.hello == hello));
        System.out.println((hello == ("Hel" + "lo")));
        System.out.println((hello == ("Hel" + lo)));
        System.out.println(hello == ("Hel" + lo).intern());
    }


    public static class Other {

        public static String hello = "Hello";
    }

}

