package cn.year2020.se.precision;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/28 0028
 */
public class DoublePrecisionTest {

    public static void main(String[] args) {
        System.out.println(1f);
        System.out.println(1f == 1);
        System.out.println(1f == 1.0);
        System.out.println(1f == 1f);
        System.out.println(1f == 0.99999999f);
        System.out.println(1f == 0.999999999f);

        // 打印：false
        System.out.println(1f == 0.9999999f);


    }

}
