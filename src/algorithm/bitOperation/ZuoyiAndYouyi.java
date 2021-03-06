package algorithm.bitOperation;

import org.junit.Test;

import java.util.Scanner;

/**
 * 算数左移 右移 和逻辑右移
 */
public class ZuoyiAndYouyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a <<= 2;
        int b = sc.nextInt();
        b >>= 2;
        int c = sc.nextInt();
        c >>>= 3;
        System.out.println("a << 2 == " + a);
        System.out.println("b >> 2 == " + b);
        System.out.println("c >>> 2 == " + c);
    }

    @Test
    public void xx(){
        int a =2;
        System.out.println(a++ >= 3);
        System.out.println(a);
    }
}
