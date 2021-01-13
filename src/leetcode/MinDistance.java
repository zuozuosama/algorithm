package leetcode;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        return dp(m - 1, n - 1, word1, word2);
    }

    private int dp(int i, int j, String word1, String word2) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(i - 1, j - 1, word1, word2);
        } else {
            return Math.min(
                    dp(i - 1, j, word1, word2),
                    Math.min(dp(i, j - 1, word1, word2), dp(i - 1, j - 1, word1, word2))
            ) + 1;
        }
    }
}
