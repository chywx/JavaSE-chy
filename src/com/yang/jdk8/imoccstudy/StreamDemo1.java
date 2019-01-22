package com.yang.jdk8.imoccstudy;

import java.util.stream.IntStream;

/**
 * https://www.imooc.com/article/27181，写的挺好
 * 操作类型有几个维度
 * 首先分为 中间操作 和 最终操作，在最终操作没有调用的情况下，所有的中级操作都不会执行
 *  中间操作又分为 有状态操作 和 无状态操作
 *  最终操作里面分为短路操作和非短路操作
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        // 外部迭代
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println("结果为：" + sum);

        // 使用stream的内部迭代
        // map就是中间操作（返回stream的操作）
        // sum就是终止操作
        int sum2 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
        System.out.println("结果为：" + sum2);

        System.out.println("惰性求值就是终止没有调用的情况下，中间操作不会执行");
        IntStream.of(nums).map(StreamDemo1::doubleNum);//这一步就没有执行
    }

    public static int doubleNum(int i) {
        System.out.println("执行了乘以2");
        return i * 2;
    }
}
