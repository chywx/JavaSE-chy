package cn.year2022.memory;

/**
 * @author: Dylan
 * @date: 2022/8/26 11:06
 */
public class TestMemory {

    static int i = 0;


    public static void main(String[] args) {
        aaa();
    }

    public static void aaa() {
        System.out.println("aaa");
        System.out.println(i++);
        aaa();
    }

}
