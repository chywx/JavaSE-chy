package cn.year2021.bet;

import java.math.BigDecimal;

/**
 * @author chy
 * @date 2021年10月12日 下午 15:10
 */
public class CalcRewardAmount {

    public static void main(String[] args) {

        calcTax("186.04", "716.25");

    }

    private static void calcTax(String sAmount, String sWinAmount) {
        BigDecimal amount = new BigDecimal(sAmount);

        BigDecimal winAmount = new BigDecimal(sWinAmount);

        BigDecimal tax = new BigDecimal("0.2");
        BigDecimal rewardAmount = winAmount.subtract(amount).multiply(tax);
        System.out.println(rewardAmount);
    }

}
