package leetcode.leetcode.editor.cn;
//三数之和
////给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (nums[i] != nums[i - 1])) {
                    int l = i + 1, r = nums.length - 1;
                    int sum = -nums[i];
                    while (l < r) {
                        if (sum == nums[l] + nums[r]) {
                            res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        } else if (sum > nums[l] + nums[r]) {
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                        } else if (sum < nums[l] + nums[r]) {
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}