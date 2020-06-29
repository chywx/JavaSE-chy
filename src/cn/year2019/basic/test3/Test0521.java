package cn.year2019.basic.test3;

public class Test0521 {

    public static void main(String[] args) {
        System.out.println(testTry());
    }

    /**
     * 即使在finally里面进行了++操作，那调用testTry已经return了。所以输出1
     *
     * @return
     */
    public static int testTry() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }


}
