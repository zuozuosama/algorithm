package algorithm.executorPoolTest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorPoolTest {
    @Test
    public void test1(){

        AtomicInteger a = new AtomicInteger(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(()->{
            for (;;){
                System.out.println(a.getAndIncrement());
                if (a.intValue() == 3) break;
            }
        });


    }
}
