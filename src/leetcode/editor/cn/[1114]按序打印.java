package leetcode.editor.cn;//给你一个类：
//
//
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//}
//
// 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
//
//
// 线程 A 将会调用 first() 方法
// 线程 B 将会调用 second() 方法
// 线程 C 将会调用 third() 方法
//
//
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
//
// 提示：
//
//
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
// 你看到的输入格式主要是为了确保测试的全面性。
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出："firstsecondthird"
//解释：
//有三个线程会被异步启动。输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用
//third() 方法。正确的输出是 "firstsecondthird"。
//
//
// 示例 2：
//
//
//输入：nums = [1,3,2]
//输出："firstsecondthird"
//解释：
//输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。正
//确的输出是 "firstsecondthird"。
//
//
//
//
//
//提示：
//
//
// nums 是 [1, 2, 3] 的一组排列
//
// Related Topics 多线程 👍 407 👎 0


import java.util.concurrent.CountDownLatch;

//leetcode submit region begin(Prohibit modification and deletion)
class Foo {

    public Foo() {

    }

    public CountDownLatch countDownLatch = new CountDownLatch(3);

    public void first(Runnable printFirst) throws InterruptedException {

        while (true) {
            long count = countDownLatch.getCount();
            if (count == 3) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                countDownLatch.countDown();
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {

            long count = countDownLatch.getCount();
            if (count == 2) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                countDownLatch.countDown();
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            long count = countDownLatch.getCount();
            if (count == 1) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                countDownLatch.countDown();
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
