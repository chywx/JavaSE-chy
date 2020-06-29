package cn.year2018.yang.jdk8.imoccstudy;

/**
 * 匿名内部类的this指的是内部类，而lambda指的是当前类
 */
public class ThisDemo {
    private String name = "ThisDemo";

    public void test() {
        // 匿名类实现
        new Thread(new Runnable() {

            private String name = "Runnable";

            @Override
            public void run() {
                System.out.println("这里的this指向匿名类:" + this.name);
            }
        }).start();

        // lambda实现
        new Thread(() -> {
            System.out.println("这里的this指向当前的ThisDemo类:" + this.name);
        }).start();
    }

    public static void main(String[] args) {
        ThisDemo demo = new ThisDemo();
        demo.test();
    }
}
