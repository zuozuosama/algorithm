package algorithm.kedaxunfei.zhengshi;

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String bk = sc.nextLine();
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
            String blank = sc.nextLine();
        }

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = data[i][j];
                for (int x = i+1; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        if (y==j) continue;
                        int b = data[x][y];
                        max = Math.max(max,a*b);
                    }
                }
            }
        }
        System.out.println(max);
    }


}
