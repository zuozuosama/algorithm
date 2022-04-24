package leetcode.leetcode.editor.cn;
//目标和
////给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯

import java.util.Arrays;

public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        int[] a = {100};
        solution.findTargetSumWays(a, -200);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @Description 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
         * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3
         * 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
         * @param target 可能为负数
         * @Author lizq9
         * @Date 2021/11/19 12:28
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            if ((target + sum) % 2 != 0 || sum < target) return 0;
            int m = Math.abs((target + sum) / 2);
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = m; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }
            return dp[m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}