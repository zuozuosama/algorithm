package oldAlgorithm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynDemo {
    public static void main(String[] args) {
//        Runnable t1 = new MyThread();
//        new Thread(t1,"t1").start();
//        new Thread(t1,"t2").start();
//
//        Runnable t2 = new MyThread2();
//        new Thread(t2,"t3").start();
//        new Thread(t2,"t4").start();

        Runnable t3 = new MyThread3();
        new Thread(t3,"t5").start();
        new Thread(t3,"t6").start();
    }
}

class MyThread implements Runnable {
    private int j = 0;
    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                j++;
                System.out.println("j:" + j);
            }
        }
    }
}

class MyThread2 implements Runnable{
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }finally {
            lock.unlock();
        }
    }
}

class MyThread3 implements Runnable{
    private int j = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            j++;
            System.out.println("j:" + j);
        }
    }
}