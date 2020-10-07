package algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 剑指Offer
 * 面试题14：剪绳子
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class MaxCutingSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(maxCutting(n));
        System.out.println(maxCutting1(n));
    }

    /**
     * 动态规划解法
     *
     * @param n
     * @return
     */
    public static int maxCutting(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        //子问题的最优解存储在f数组中，数组中的第i个元素表示把长度为
        ///i的绳子剪成若干段后各段长度乘积的最大值。
        int[] f = new int[n + 1];
        //这些情况下，不剪的时候长度比剪的时候长，所以作为初始条件
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int num = f[j] * f[i - j];
                if (max < num)
                    max = num;
            }
            f[i] = max;
        }
        result = f[n];
        return result;
    }

    /**
     * 贪心算法
     */
    public static int maxCutting1(int n) {
        if (n < 2) return 0;
        else if (n == 2) return 1;
        else if (n == 3) return 2;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
