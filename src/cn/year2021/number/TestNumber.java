package cn.year2021.number;/**
 * @author chy
 * @date 2021/1/21 0021 下午 17:39
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/21 0021
 */
public class TestNumber {

    public static void main(String[] args) {
        String twoDecimal = DecimalUtils.getTwoDecimal(.0d);
        if (twoDecimal.equals(".00")) {
            System.out.println("0.00");
        } else {
            System.out.println(twoDecimal);
        }
    }

}
