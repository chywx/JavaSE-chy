package cn.year2021.number;

import java.text.DecimalFormat;

/**
 * decimal工具类
 *
 * @author chy
 * @date 2019/11/1 0001
 */
public class DecimalUtils {
    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static String getTwoDecimal(Double balance){
        return decimalFormat.format(balance);
    }
}
