package oldAlgorithm.writeAndreadByThread;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadAndWriteTest {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        //Runnable
        ReadFiles readFiles = new ReadFiles(millis);
        //线程池的工厂类Executors，newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
        //ExecutorService线程池接口，用来从线程池中获取线程，调用start
        ExecutorService service = Executors.newFixedThreadPool(3);
        //submit(Runnable tast) 提交一个Runnable任务用于执行
        for (int i = 0; i < 100; i++) {
            service.submit(readFiles);
        }
    }
}
