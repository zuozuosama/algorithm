package leetcode;

public class MaxProfit {
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
