package cn.year2020.se;/**
 * @author lql
 * @date 2020/11/19 0019 下午 17:46
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/11/19 0019
 */
public class TestAssert {

    public static void main(String[] args) {
//        test1(-1);
        test2(-2);
    }

    private static void test1(int a) {
        assert a > 0;
        System.out.println(a);
    }

    private static void test2(int a) {
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }

}
