package cn.year2021.recursion;/**
 * @author chy
 * @date 2021/3/18 0018 下午 17:16
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/3/18 0018
 */
public class SumFun {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5};

        SumFun sumFun = new SumFun();
        sumFun.forFun(arr);

        sumFun.recursionFun(arr);

        int i = 10;
        sumFun.f(i++);
    }

    void f(int i) {
        System.out.println(i);
    }


    void forFun(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

    }

    void recursionFun(int[] arr) {
        int add = add(arr, 0);
        System.out.println(add);
    }

    int add(int[] arr, int i) {
        System.out.println(arr.length + "---" + i);
        if (i == arr.length) {
            return 0;
        }
        return arr[i] + add(arr, ++i);
    }


}
