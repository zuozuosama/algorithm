package leetcode.leetcode.editor.cn;
//乘积最大子数组
////给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
        int[] nums = {2, 3, -2, 4};
        int i = solution.maxProduct(nums);
        System.out.println(i);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int max = nums[0];
            int temp = 1;
            for (int num : nums) {
                temp *= num;
                max = Math.max(max, temp);
                if (num == 0) {
                    temp = 1;
                }
            }
            temp = 1;
            for (int i = n - 1; i >= 0; i--) {
                temp *= nums[i];
                max = Math.max(max, temp);
                if (nums[i] == 0) {
                    temp = 1;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}