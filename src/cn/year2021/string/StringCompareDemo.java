package cn.year2021.string;/**
 * @author chy
 * @date 2021/2/1 0001 下午 16:28
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/1 0001
 */
public class StringCompareDemo {

    public static void main(String[] args) {
        String a = "wukong2";
        final String b = "wukong";
        String d = "wukong";
        String c = b + 2;
        String e = d + 2;
        System.out.println(a == c);// b用final修饰了，c直接建立出wukong2，所以为true
        System.out.println(a == e);
    }

}
