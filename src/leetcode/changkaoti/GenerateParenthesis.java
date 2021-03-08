package leetcode.changkaoti;

import java.util.LinkedList;
import java.util.List;

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
 * DFS(Deep First Search)回溯算法，深度优先搜索算法，包含剪枝定界法 + 回溯算法
 */
public class GenerateParenthesis {
    private List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return res;
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }

    private void generate(String item, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(item);
            return;
        }
        if (left > 0) {
            generate(item + "(", left - 1, right);
        }

        // 剪枝 排除这种情况(())  left=1 right=1  ---> (()) + )(
        if (left < right) {
            generate(item + ")", left, right - 1);
        }
    }

}
