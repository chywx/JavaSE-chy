package cn.year2020.jvm;

/**
 * String == 测试
 *
 * @author chy
 * @date 2020/2/1 0001
 */
public class StringCompareTest2 {

    public static void main(String[] args) {
        String s = new String("a");
        s.intern();
        String s2 = "a";
        System.out.println(s == s2);

        String s3 = new String("a") + new String("b");
        s3.intern();
        String s4 = "ab";
        System.out.println(s3 == s4);

    }

}

