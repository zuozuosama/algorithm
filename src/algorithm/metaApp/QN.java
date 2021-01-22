package algorithm.metaApp;


import org.junit.Test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QN {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread t = new Thread() {
                public void run() {
                    cnn();
                }
            };
            t.run();
            System.out.print("FakeNews ");
            System.out.print("; ");
            t.start();
            System.out.print("FakeNews ");

            Thread.sleep(10);
            System.out.println();
        }

    }

    static void cnn() {
        System.out.print("CNN ");
    }

    @Test
    public void qn5() {
        String s = new String(new char[]{'没', '人', '比', '我', '更', '懂', 'j', 'a', 'v', 'a'});
        String si = "没人比我更懂java";
        String s2 = "没人比我更懂java";
        System.out.println(si == s2);
        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println(s == si.intern());
    }

    public int calc(int n) {
        try {
            n += 1;
            if (n / 0 > 0) {
                n += 1;
            } else {
                n -= 10;
            }
            return n;
        } catch (Exception e) {
            n++;
        }
        n++;
        return n++;
    }

    @Test
    public void qn3() {
        System.out.println(calc(10));
    }

    private static volatile int s = 0;
    private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
            0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS, new SynchronousQueue<>());


    @Test
    public void qn1() throws InterruptedException {
        for (;;){
            for (int i = 0; i < 10000; i++) {
                async.execute(() -> s++);
            }
            Thread.sleep(5000L);
            System.out.println(s);
            s = 0;
        }

    }
}
