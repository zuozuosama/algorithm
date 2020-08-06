package algorithm.kedaxunfei;

import java.util.Scanner;

public class Case3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[4];
        int[] y = new int[4];
        int flag = 0;
        for (int i = 0; i < 8; i++) {
            int index = i / 2;
            if (i % 2 == 0) {
                x[index] = sc.nextInt();
            } else {
                y[index] = sc.nextInt();
            }
        }
        for (int i = 2; i <= 3; i++) {
            if (x[i] > x[i - 2] && x[i] < x[i - 1]) {
                flag++;
                break;
            }
            if (y[i] > y[i - 2] && y[i] < y[i - 1]) {
                flag++;
                break;
            }
        }
        System.out.println(flag);
    }
}
