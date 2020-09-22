package algorithm.wenjingkeji;

import java.util.concurrent.TimeUnit;

/**
 * 多线程对共享变量的读取
 * 主线程更改了stop的值并没有将其刷新到主内存中，只在工作内存中更改
 * 此时线程thread没有读取到最新的值，即发生了脏读
 *
 *
 * 在线程thread的while循环中进行线程休眠其实作用是将线程进行上下文切换
 * 线程上下文切换会从主内存中读取一遍最新的变量值
 *
 * System.out.println()底层是加了synchronized关键字的，加了同步关键字也会从主内存中读一遍最新值
 *
 *
 * 最后一种方式是对共享变量加volatile关键字
 */
public class ThreadTest {
    private static boolean stop = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop) {
                    pause(1);
                    System.out.println(stop);
                    int a = 1;
                }
            }
        });
        thread.start();
        pause(100);
        stop = true;
    }

    public static void pause(long time)  {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
