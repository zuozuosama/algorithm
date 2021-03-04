package algorithm.xingyeshujin;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Scanner;

public class A {
    public static void decimalToBinary1(int n) {
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r = 0;  //用来存储余数
        while (n != 0) {
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10, t);
            t++;
        }
        System.out.println(bin);
    }

    public static String decimalToBinary(String n) {
        int m = Integer.parseInt(n);
        StringBuilder sb = new StringBuilder();
        while (m != 0) {
            sb.insert(0, m % 2);
            m = m / 2;
        }
        while (sb.length() < 16) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    private static String decimalToHex(String n) {
        int m = Integer.parseInt(n);
        StringBuilder sb = new StringBuilder();
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (m != 0) {
            sb.insert(0, b[m % 16]);
            m = m / 16;
        }
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    public static String changeFormatNumber(String number) {
        double max = Math.pow(2, 15) - 1;
        double min = -1 * Math.pow(2, 15);
        int n;
        try {
            n = Integer.parseInt(number);
        } catch (Exception e) {
            return "INPUTERROR";
        }

        if (n > max || n < min) return "NODATA";
        // write code here
        return decimalToBinary(number) + "," + decimalToHex(number);
    }


    public static void main(String[] args) {
        System.out.println(changeFormatNumber("A"));

        System.out.println(changeFormatNumber("A"));
        System.out.println(decimalToBinary("15"));
        System.out.println(decimalToHex("15"));

    }

    @Test
    public void d() {
        int var = -1;
        String hex = Integer.toHexString(var);
        System.out.println(hex);

    }

    @Test
    public void x(){
        int num = -1;
        String string = Integer.toBinaryString(num);
        System.out.println(string);
    }


}
