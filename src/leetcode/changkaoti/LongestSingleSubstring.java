package leetcode.changkaoti;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，最长非重复子字符串为”acfr”，长度为4。
 *
 *
 * 滑动窗口算法题目：
 * 3. 无重复字符的最长子串
 *
 * 30. 串联所有单词的子串
 *
 * 76. 最小覆盖子串
 *
 * 159. 至多包含两个不同字符的最长子串
 *
 * 209. 长度最小的子数组
 *
 * 239. 滑动窗口最大值
 *
 * 567. 字符串的排列
 *
 * 632. 最小区间
 *
 * 727. 最小窗口子序列
 *
 */
public class LongestSingleSubstring {
    public static void main(String[] args) {
        int num = lengthOfLongestSubstring("arabcacfr");
        System.out.println("最长的子字符串长度为：" + num);
    }


    /**
     * 最长不含重复字符的子字符串
     * 滑动窗口算法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < n; r++) {
            char ch = s.charAt(r);
            //此处循环删减重复字符可以优化
            while (set.contains(ch)) {
                //abba此时情况是l=2
                //aba此时情况是l=1
                //循环移动窗口左指针
                set.remove(s.charAt(l++));
            }
            set.add(ch);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    /**
     * hashmap优化算法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //假如 窗口左边界只是这样更新 left =  map.get(s.charAt(i)) + 1;
                //abba这种情况有错误
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


}
