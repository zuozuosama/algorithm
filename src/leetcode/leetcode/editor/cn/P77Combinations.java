package leetcode.leetcode.editor.cn;
//组合
////给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯

import java.util.LinkedList;
import java.util.List;

public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();
        private LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            backTrace(n, 1, k);
            return res;
        }

        private void backTrace(int n, int startIndex, int k) {
            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = startIndex; i <= n; i++) {
                path.add(i);
                backTrace(n, i + 1, k);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}