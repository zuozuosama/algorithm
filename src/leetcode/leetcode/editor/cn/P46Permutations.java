package leetcode.leetcode.editor.cn;
//全排列
////给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯

import java.util.LinkedList;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        int[] nums = {1, 2, 3};
        solution.permute(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> list = new LinkedList<>();
            dfs(nums, list);
            return res;
        }

        private void dfs(int[] nums, LinkedList<Integer> list) {
            if (list.size() == nums.length) {
                //java引用问题，一定要在创建个对象，不然复用一个对象list，之后对其操作回退时候，res里面的list数据都会被清除
                res.add(new LinkedList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                dfs(nums, list);
                list.removeLast();
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}