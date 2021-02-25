package cn.year2021.test;/**
 * @author chy
 * @date 2021/2/24 0024 下午 17:46
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/24 0024
 */
public class TryCacheTest {

    public static void main(String[] args) {
        System.out.println(fff());
    }

    public static int fff() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
        return 1;
    }

}
