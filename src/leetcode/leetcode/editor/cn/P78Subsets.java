package leetcode.leetcode.editor.cn;
//子集
////给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯

import java.util.LinkedList;
import java.util.List;

public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
        solution.subsets(new int[]{1, 2, 3});
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();
        private LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backTrace(nums, 0);
            return res;
        }

        private void backTrace(int[] nums, int startIndex) {
            res.add(new LinkedList<>(path)); // res.add(path) 不正确，因为path会引用一个地址
            if (startIndex >= nums.length) return;
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backTrace(nums, i + 1);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}