package dataStructure;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CharLength {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String a = "的";
//        System.out.println("UTF-8编码长度:"+a.getBytes("UTF-8").length);
//        byte[] gbks = a.getBytes();
//
//        System.out.println("GBK编码长度:"+a.getBytes("GBK").length);
//        System.out.println("GB2312编码长度:"+a.getBytes("GB2312").length);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
//        ExecutorService executorService2 = Executors.newCachedThreadPool();

        Integer integer = new Integer(129);
        Integer integer1 = new Integer(129);
        System.out.println(integer==integer1);
        System.out.println(integer.equals(integer1));

        String abc = new String("abc");
        String abc1 = "abc";
        System.out.println(abc==abc1);
        System.out.println(abc.equals(abc1));
    }
}
