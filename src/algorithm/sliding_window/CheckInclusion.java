package algorithm.sliding_window;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int[] need = new int[26];
        int[] window = new int[26];
        int size = 0; //记录子串长度
        for(char c : s1.toCharArray()) {
            if(need[c - 'a'] == 0) size++;
            need[c - 'a']++;
        }
        int match = 0;
        int left = 0, right = 0;
        while(right < n) {
            char rc = s2.charAt(right);
            window[rc - 'a']++;
            if(window[rc - 'a'] == need[rc - 'a']) match++;
            while(size == match) {
                if(right - left + 1 == s1.length()) return true;
                char lc = s2.charAt(left);
                window[lc - 'a']--;
                if(window[lc - 'a'] < need[lc - 'a']) match--;
                left++;
            }
            right++;
        }
        return false;
    }
}
