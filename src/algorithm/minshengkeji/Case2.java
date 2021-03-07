package algorithm.minshengkeji;

import java.util.Scanner;

public class Case2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int[] c = new int[2];
            c[0] = a;
            c[1] = b;
            arr[i] = c;
        }

        for (int[] d : arr) {
            System.out.println(calcNum(calc(d)));
        }

    }

    public static int calc(int[] d) {
        int a = d[0];
        int b = d[1];
        int sum = a;
        while (--b > 0) {
            sum = sum * (a - 1);
            a--;
        }
        return sum;
    }

    public static int calcNum(int sum) {
        if (sum < 4) return 1;
        int res = 0;
        while (sum % 2 == 0) {
            sum /= 2;
            res++;
        }
        while (sum % 3 == 0) {
            sum /= 3;
            res++;
        }
        if (sum != 0 && sum != 1) res++;
        return res;
    }
}
