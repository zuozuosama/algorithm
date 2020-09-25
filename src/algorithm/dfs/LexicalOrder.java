package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 */
public class LexicalOrder {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return res;
    }

    public void dfs(int cur, int n) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            dfs(cur * 10 + i, n);
        }
    }
}
