package cn.year2019.basic.test5;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/8/30 0030
 */
public class TestCL {
    public static void main(String[] args) {
        ClassLoader loader = TestCL.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
