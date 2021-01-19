package leetcode;

import java.util.Arrays;

public class Maxenvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (arr1, arr2) ->
            arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr2[0]-arr1[0]
        );
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = envelopes[i][1];
        }
        return lis(m);
    }

    private int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = dp[0];
        for (int x = 1; x < n; x++) {
            res = Math.max(res, dp[x]);
        }
        return res;
    }
}
