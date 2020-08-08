package algorithm.meituan;

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int w = 0;
        for (int i = 1; i <= 5; i++) {
            int a = sc.nextInt();
            w += a;
            sum += a * i;
        }
        double res = sum * 1.0 / w;
        String result = process(res);
        System.out.println(result);
    }

    private static String process(double res) {
        String s = String.valueOf(res);
        return s.substring(0, s.indexOf(".") + 2);
    }
}
