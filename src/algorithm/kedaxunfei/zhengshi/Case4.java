package algorithm.kedaxunfei.zhengshi;

import java.util.Scanner;

public class Case4 {

    private static String moveToLeft(String str, int p) {
        String str1 = str.substring(p);
        String str2 = str.substring(0, p);
        return str1 + str2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String left = input.nextLine();
        int m = input.nextInt();
        while (m > left.length()) {
            m = m % left.length();
        }
        System.out.println(moveToLeft(left, m));

    }

}
