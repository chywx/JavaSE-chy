package cn.year2020.io;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/9/3 0003
 */
public class TestTryWithSource {

    /*
    try with source
    会在执行完代码块后率先执行finally的代码
     */
    public static void main(String[] args) throws Exception {

        try (ChyConnect chyConnect = new ChyConnect()) {
            System.out.println(123);
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println(">>>exception");
            e.printStackTrace();
        }


    }

}

class ChyConnect implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("chy close");
    }
}