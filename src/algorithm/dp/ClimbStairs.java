package algorithm.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {
    /**
     * 滚动数组法，优化方案
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 3) return n;
        int p = 1, q = 2;
        for (int i = 3; i <= n; i++) {
            int temp = p + q;
            p = q;
            q = temp;
        }
        return q;
    }

    /**
     * 斐波那契数列就是滑动数组法的雏形
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * 数组存储，动态规划法求解（可优化）
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n < 4) return n;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
