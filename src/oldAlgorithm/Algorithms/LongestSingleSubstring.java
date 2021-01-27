package oldAlgorithm.Algorithms;

import java.util.*;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，最长非重复子字符串为”acfr”，长度为4。
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
            while (set.contains(ch)) {
                set.remove(s.charAt(l++));
            }
            set.add(ch);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }


}
