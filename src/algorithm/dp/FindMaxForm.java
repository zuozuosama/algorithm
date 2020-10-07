package algorithm.dp;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) {
            return 0;
        }
        int[][] dp =new int[m+1][n+1];//多维费用问题的0-1背包问题。dp[i][j]表示使用i个0和j个1能表示的字符串的最大数量
        for(String s :strs) {
            //状态转移方程：dp[i][j] = Math.max(dp[i][j],1+dp[i-numZero][j-numOne])
            int zeros  = 0,ones = 0;//统计字符串中一和零的数量。
            for(char c:s.toCharArray()) {
                 if (c == '0') {
                 	zeros++;
                 }else {
                 	ones++;
                 }
            }
            //这种题做多了之后就知道就是这个套路。
            for (int i = m; i >=zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-zeros][j-ones]);
                }
            }
        }
        return dp[m][n];
    }
}
