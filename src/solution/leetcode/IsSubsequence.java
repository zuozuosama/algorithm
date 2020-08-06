package solution.leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int fromIndex = -1;
        for (char c : s.toCharArray()) {
            fromIndex = t.indexOf(c, fromIndex + 1);
            if (fromIndex == -1) {
                return false;
            }
        }
        return true;
    }
}
