package cn.year2019.datastructure;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/8/27 0027
 */
public class ZhiShu {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) { // 质数
            for (int k = 2; k <= i; k++) { // 除数
                // 排除所有在 i=k 之前 能被k整除(余数为0)的数
                if (i % k == 0 && i != k) {
                    break;
                }
                // 输出所有在 i=k 且 i%k=0的数
                if (i % k == 0 && i == k) {
                    System.out.println(i);
                }
            }
        }
    }
}
