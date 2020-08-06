package algorithm.simple;

import java.util.Arrays;
import java.util.Scanner;

public class simpleIO {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a + b);
//        }

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String[] s = sc.nextLine().split(" ");
//            int sum = 0;
//            for (int i = 0; i < s.length; i++) {
//                sum = sum + Integer.parseInt(s[i]);
//            }
//
//            System.out.println(sum);
//        }

//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        String blank = cin.nextLine(); // 处理第一行留下的回车分隔符
//        String str = cin.nextLine();
//        String[] strData = str.split(" ");
//        Arrays.sort(strData);
//        String res = String.join(" ", strData);
//        System.out.println(res);

//        Scanner sc = new Scanner(System.in);
//        int c = sc.nextInt();
//        while (c != 0) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a + b);
//            c--;
//        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = sc.nextLine(); // 处理第一行留下的回车分隔符
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            System.out.println(Arrays.asList(s));
        }
    }
}
