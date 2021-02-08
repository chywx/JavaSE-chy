package cn.year2021.flowcontrol.condition;/**
 * @author chy
 * @date 2021/2/8 0008 上午 11:30
 * Description：
 */

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition实现生产车消费者模式
 *
 * @author chy
 * @date 2021/2/8 0008
 */
public class ConditionDemo2 {

    private int queueSize = 10;

    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);


    private ReentrantLock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo2 demo = new ConditionDemo2();
        Producer producer = demo.new Producer();
        Consumer consumer = demo.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列空，等待数据");
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    notFull.signalAll();
                    System.out.println("从队列获取走了一个数据" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        System.out.println("队列满，等待有空余");
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    notEmpty.signalAll();
                    System.out.println("向队列获取插入了一个数据，队列剩余空间" + (queueSize - queue.size()) + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}