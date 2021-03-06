package oldAlgorithm.Algorithms;

import java.util.LinkedList;

/*
    中心扩散法求字符串中最长的回文子字符串
 */
public class Palindrome {
    public String longestPalindrome(String s) {
        LinkedList<Integer> integers = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }

    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        String str = "babad";
        String s = new Palindrome().longestPalindrome(str);
        System.out.println(s);
    }
}
