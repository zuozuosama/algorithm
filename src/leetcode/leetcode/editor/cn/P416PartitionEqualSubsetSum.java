package leetcode.leetcode.editor.cn;
//分割等和子集
////给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划

public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 与494. 目标和 类似，属于01背包问题，可以把问题抽象为“给定一个数组和一个容量为x的背包，求有多少种方式让背包装满（有多少种子集能让子集之和等于背包容量）?"
        // 递推公式：dp[i] = dp[i] + dp[i-num] ，对于当前的第i个物品，有拿和不拿两种情况，dp[i]表示不拿的情况，dp[i-num]表示拿的情况，因此要将两者相加。

        /*这里大家发现和二维dp的写法中，遍历背包的顺序是不一样的！

       二维dp遍历的时候，背包容量是从小到大，而一维dp遍历的时候，背包是从大到小。

       为什么呢？

       倒叙遍历是为了保证物品i只被放入一次！。但如果一旦正序遍历了，那么物品0就会被重复加入多次！

       举一个例子：物品0的重量weight[0] = 1，价值value[0] = 15

       如果正序遍历

       dp[1] = dp[1 - weight[0]] + value[0] = 15

       dp[2] = dp[2 - weight[0]] + value[0] = 30

       此时dp[2]就已经是30了，意味着物品0，被放入了两次，所以不能正序遍历。

       为什么倒叙遍历，就可以保证物品只放入一次呢？

       倒叙就是先算dp[2]

       dp[2] = dp[2 - weight[0]] + value[0] = 15 （dp数组已经都初始化为0）

       dp[1] = dp[1 - weight[0]] + value[0] = 15

       所以从后往前循环，每次取得状态不会和之前取得状态重合，这样每种物品就只取一次了。*/
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            int m = sum >> 1;
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = m; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[m] != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}