package cn.year2021.thread.threadlocal;

/**
 * @author: Dylan
 * @date: 2022/3/21 10:50
 */
public class InheritableTest {

    public static void main(String[] args) {
        Thread parentParent = new Thread(() -> {
            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            threadLocal.set(1);
            InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();
            inheritableThreadLocal.set(2);

            new Thread(() -> {
                System.out.println("threadLocal=" + threadLocal.get());
                System.out.println("inheritableThreadLocal=" + inheritableThreadLocal.get());
            }).start();
        }, "父线程");
        parentParent.start();
    }
}
