package solution.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

/**
 * DFS(Deep First Search)，深度优先搜索算法，包含剪枝定界法 + 回溯算法
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    private void generate(String item, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(item);
            return;
        } else if (left > 0) {
            generate(item + "(", left - 1, right, res);
        } else if (left < right) {
            generate(item + ")", left, right - 1, res);
        }
    }

}
