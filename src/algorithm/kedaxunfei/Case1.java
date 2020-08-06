package algorithm.kedaxunfei;

import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int sum = 0;
        int[] money = {1, 5, 10, 50, 100};
        for (int i = 4; i >= 0; i--) {
            int curNum = array[i];
            int curMoney = money[i];
            while (k >= curMoney && curNum > 0) {
                k = k - curMoney;
                sum++;
                curNum--;
            }
        }
        if (k > 0) sum = -1;
        System.out.println(sum);
    }
}
