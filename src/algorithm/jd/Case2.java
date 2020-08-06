package algorithm.jd;

import java.util.Scanner;

public class Case2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(hws(n, m));
    }

    private static int hws(int n, int m) {
        if (n >= 10 && m < 100) return m - n + 1;
        else return 0;
    }
}
