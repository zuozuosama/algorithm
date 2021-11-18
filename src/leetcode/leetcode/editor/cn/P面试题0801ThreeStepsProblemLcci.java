package leetcode.leetcode.editor.cn;
//三步问题
////三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 记忆化搜索 数学 动态规划

public class P面试题0801ThreeStepsProblemLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题0801ThreeStepsProblemLcci().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToStep(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (n == 3) return 4;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i < n + 1; i++) {
                //int类型大数相加时可能会出现溢出问题，处理方法是两数相加的时候取一次模
                //dp[i - 2] + dp[i - 1]相加可能会溢出，所以模一次
                //(dp[i - 2] + dp[i - 1]) % 1000000007和dp[i - 3]相加又可能溢出，模一次
                dp[i] = dp[i - 3] + (dp[i - 2] + dp[i - 1]) % 1000000007;
                dp[i] %= 1000000007;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}