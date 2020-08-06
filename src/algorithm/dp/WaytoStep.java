package algorithm.dp;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 * 示例1:
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * 输入：n = 5
 * 输出：13
 */
public class WaytoStep {
    public int waysToStep(int n) {
        if (n < 3) return n;
        if (n == 3) return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }
}
