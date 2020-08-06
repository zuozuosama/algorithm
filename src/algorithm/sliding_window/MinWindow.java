package algorithm.sliding_window;

import java.util.Scanner;

/**
 * 滑动窗口法
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，
 * 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        int[] mp = new int[256];
        for (char c : t.toCharArray()) mp[c] += 1;
        int left = 0, right = 0;
        int n = s.length(), m = t.length();
        int valid = 0; //valid变量表示窗口中满足条件的字符个数
        int res = -1; //记录子串长度
        String ans = ""; //记录子串
        while (right < n) {
            char c = s.charAt(right);
            mp[c] -= 1;
            if (mp[c] >= 0) valid += 1;
            while (valid == m) {
                if (res == -1 || res > right - left + 1) {
                    ans = s.substring(left, right + 1);
                    res = right - left + 1;
                }
                c = s.charAt(left);  //左移窗口字符
                mp[c] += 1;
                if (mp[c] >= 1) valid -= 1;
                left += 1; //左移窗口
            }

            right += 1; //右移窗口
        }
        return ans;
    }

    public static void main(String[] args) {
        MinWindow mw = new MinWindow();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // ADOBECODEBANC
        String t = sc.nextLine(); // ABC
        System.out.println(mw.minWindow(s,t));
    }
}
