package cn.year2019.basic.nan;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/11/25 0025
 */
public class TestDouble {

    public static void main(String[] args) {
//        Infinite表示无限大，即分母为0
        Double d1 = 1/0.0;
        System.out.println(d1.isNaN());
        System.out.println(d1.isInfinite());

//        NaN表示分母跟分子都是0
        Double d2 = 0/0.0;
        System.out.println(d2.isNaN());
        System.out.println(d2.isInfinite());
    }

}
