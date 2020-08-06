package algorithm.jd;

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = String.format("%.4f", sumN(n));
        System.out.println(result);
    }

    private static double sumN(int n) {
        if (n <= 1) return 0.1000;
        double res = sumN(n - 1) + 1.0 / (5 * (2 * n - 1)) - 1.0 / (5 * 2 * n);
        return res;
    }
}
