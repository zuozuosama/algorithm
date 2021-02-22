package algorithm.executorPoolTest;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式-使用reentrantlock的condition进行等待唤醒
 * 注意：生产者加入时要考虑队列到达边界时候的情况
 * 消费者消费时要考虑队列为空的情况 防止取空，加满溢出
 *
 */
public class Buffer {
    private ArrayList<String> string;
    private int size;
    private Lock lock = new ReentrantLock();
    private Condition produceTh = lock.newCondition();
    private Condition consumerTh = lock.newCondition();

    public Buffer(int size) {
        this.size = size;
        string = new ArrayList<>();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Produce produce = new Produce(buffer);
        Consumer consumer = new Consumer(buffer);
        for (int i = 0; i < 5; i++) {
            new Thread(produce).start();
        }
        for (int i = 0; i < 1; i++) {
            new Thread(consumer).start();
        }

    }

    public void put() throws InterruptedException {
        //产品生产入队列
        try {
            lock.lock();
            while (string.size() >= size) {
                System.out.println(Thread.currentThread().getName() + " await");
                produceTh.await();
            }
            Thread.sleep(300);
            string.add("产品");
            System.out.println(Thread.currentThread().getName() + " put:" + string.size());
            consumerTh.signal();
        } finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        //拿走产品
        try {
            lock.lock();
            while (string.size() <= 0) {
                consumerTh.await();
            }
            Thread.sleep(300);
            string.remove(string.size() - 1);
            System.out.println(Thread.currentThread().getName() + " take:" + string.size());
            produceTh.signal();
        } finally {
            lock.unlock();
        }

    }
}

class Produce implements Runnable {
    Buffer buffer;

    public Produce(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                buffer.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                buffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}