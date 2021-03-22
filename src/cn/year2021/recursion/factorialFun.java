package cn.year2021.recursion;/**
 * @author chy
 * @date 2021/3/19 0019 上午 11:36
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/3/19 0019
 */
public class factorialFun {

    public static void main(String[] args) {

        int number = 5;

        factorialFun factorialFun = new factorialFun();

        factorialFun.forFun(number);

        factorialFun.recursionFun(number);

    }


    void forFun(int number) {

        int value = 1;
        for (int i = number; i >= 1; i--) {
            value = value * i;
        }
        System.out.println(value);

    }

    void recursionFun(int number) {
        System.out.println(multiply(number));
    }

    int multiply(int number) {
        if (number == 1) {
            return 1;
        }
        return number * multiply(--number);
    }


}
