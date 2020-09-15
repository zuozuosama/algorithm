package algorithm.kedaxunfei.zhengshi;

import java.util.Scanner;

public class Case3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int normal = normal(sc.nextInt());
        System.out.println(normal);
    }


    public static int normal(int x) {
        int c = 0;
        for (; x > 0; x >>>= 1) {
            c += x & 1; // 如果当前位是 1，计数器加 1
        }
        return c;
    }
}