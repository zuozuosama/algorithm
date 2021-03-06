package leetcode;

/**
 * 贪心算法 多次买入卖出股票
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
