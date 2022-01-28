package leetcode.leetcode.editor.cn;
//最小覆盖子串
////给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口

public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] hash = new int[128];
            for (char c : t.toCharArray()) {
                hash[c] += 1;
            }
            int n = s.length();
            int m = t.length();
            int left = 0, right = 0, valid = 0;
            int min = -1;
            String res = "";
            while (right < n) {
                char c = s.charAt(right);
                hash[c] -= 1;
                if (hash[c] >= 0) valid++;
                while (valid == m) {
                    if (min == -1 || min > right - left + 1) {
                        min = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                    char leftChar = s.charAt(left);
                    hash[leftChar] += 1;
                    if (hash[leftChar] >= 1) valid--;
                    left++;
                }
                right++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}