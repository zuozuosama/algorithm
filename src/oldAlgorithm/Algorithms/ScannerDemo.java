package oldAlgorithm.Algorithms;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
//        nextLineTest();
//        nextTest();
        nextIntTest();
    }

    /**
     * 使用nextInt()方法时，与next()方法类似，只是它的返回值是int类型的，依旧将空格看作是两个输入的数据的间隔
     */
    private static void nextIntTest() {
        Scanner sc=new Scanner(System.in);
        System.out.println("使用nextInt()方法，将空格作为间隔符。输入为：");
        while(sc.hasNext()){
            System.out.print("输出为：");
            int n=sc.nextInt();
            System.out.print(n);
        }
    }

    /**
     * 使用next()方法时，将空格看作是两个字符串的间隔
     */
    private static void nextTest() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("使用next()方法，将空格作为间隔符。输入为：");
        while (sc2.hasNext()){
            System.out.print("输出为：");
            String n = sc2.next();
            System.out.print(n);
            //使用next()方法，将空格作为间隔符。输入为：
            //12 23 34
            //输出为：12输出为：23输出为：34
        }
    }


    /**
     * 使用nextLine()方法时，不将空格看做是两个字符串的间隔，而是看作字符串的一部分，返回时，它作为String类型一并返回
     */
    private static void nextLineTest() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("使用nextLine()方法，并且输入为：");
        String n= sc1.nextLine();
        System.out.println("输出为：");
        System.out.println(n);
        //使用nextLine()方法，并且输入为：
        //12 23 34
        //输出为：
        //12 23 34
    }


}
