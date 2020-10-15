package algorithm.siteqi;

import java.util.Random;

public class Test {
    /**
     * 生成指定位数的随机数字
     *
     * @param length
     * @return
     */
    public static String createRandomNumber(int length) {
        StringBuffer number = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int randomNumber = new Random().nextInt(10);
            number.append(randomNumber);
        }
        return number.toString();
    }

    //final可以重载
    public static final String createRandomNumber(int length,int a) {
        StringBuffer number = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int randomNumber = new Random().nextInt(10);
            number.append(randomNumber);
        }
        return number.toString();
    }

    //private 可以修饰类 double不可以在switch语句中
    private class inner{
        public  void main(String[] args) {
            switch ('1'){
                case '1':
                    System.out.println(1);
            }
        }
    }

    public static void main(String[] args) {
        String a="a";
        String b = new String("a");
        System.out.println(a=="a"); //true
        System.out.println(a==b); //false


        //foobar
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        Thread thread = new Thread(runnable);
        thread.run();
        System.out.println("bar");


        //bar
        //foo

        //foobar 都有可能
//        while (true){
//            Thread thread = new Thread(runnable);
//            thread.start();
//            System.out.println("bar");
//        }
    }
}
