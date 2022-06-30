package cn.year2021.thread.lock.sync;

/**
 * @author: Dylan
 * @date: 2022/6/29 12:14
 */
public class SynchronizedTest {

    static double year;

    public static void main(String[] args) {
        SynchronizedTest sync = new SynchronizedTest();
        sync.execute();
    }

    public void execute() {
        //线程A，练习唱跳rap
        Thread threadA = new Thread(() -> {
            System.out.println("a");
            synchronized (this) {
                for (year = 0.5; year <= 5; year += 0.5) {
                    try {
                        System.out.println("开始练习唱跳rap：已练习" + year + "年");
                        Thread.sleep(288);
                        if (year == 2.5) {
                            System.out.println("===========================>练习时长两年半，出道！！！");
                            //唤醒等待中的threadB，但threadB不会立马执行，而是等待threadA执行完，因为notify不会释放锁
                            notify();
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //线程B，练习打篮球
        Thread threadB = new Thread(() -> {
            synchronized (this) {
                try {
                    wait();
                    System.out.println("开始练习打篮球");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //注意，一定要先启动B，不然会导致B永远阻塞
        threadB.start();
        threadA.start();
    }
}

