package leetcode.leetcode.editor.cn;
//括号生成
////数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯

import java.util.LinkedList;
import java.util.List;

public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> res = new LinkedList<>();

        public List<String> generateParenthesis(int n) {
            generate("", n, n);
            return res;
        }

        private void generate(String item, int l, int r) {
            if (l == 0 && r == 0) {
                res.add(item);
                return;
            }

            if (l > 0) {
                generate(item + "(", l - 1, r);
            }

            if (l < r) {
                generate(item + ")", l, r - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}