package leetcode;

/**
 * 中心扩散法（双指针法的变形）
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
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

    private static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}
