package leetcode;

/**
 * 动态规划算法 一次买入卖出股票
 */
public class MaxProfitI {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int curMin = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(prices[i], curMin);
            res = Math.max(prices[i] - curMin, res);
        }
        return res;
    }
}
