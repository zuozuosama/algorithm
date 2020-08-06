package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 回溯算法
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
public class GenerateParenthesis {
    public List<String> generateParenthesis1(int n) {
        Set<String> set = new TreeSet<>();
        set.add("()");
        if (n == 1) {
            return new ArrayList<>(set);
        } else {
            for (int i = 1; i < n; i++) {
                Set<String> newSet = new TreeSet<>();
                for (String s : set) {
                    newSet.add("()" + s);
                    newSet.add("(" + s + ")");
                    newSet.add(s + "()");
                }
                set = newSet;
            }
            return new ArrayList<>(set);
        }
    }

    private void generate(String item, int left, int right, List res) {
        //左括号和右括号满足上述条件的前提下都为n个，添加这个答案
        if (left == 0 && right == 0) {
            res.add(item);
            return;
        }
        //左括号的个数小于n 才能继续放左括号
        if (left > 0) {
            generate(item + "(", left - 1, right, res);
        }
        //左括号个数必须大于右括号的放置个数 才能继续放右括号
        if (left < right) {
            generate(item + ")", left, right - 1, res);
        }
    }


    public List<String> generateParenthesis(int n) {
        /**
         *左括号个数必须大于右括号的放置个数 才能继续放右括号
         *左括号的个数小于n 才能继续放左括号
         *左括号和右括号满足上述条件的前提下都为n个，添加这个答案
         */
        List<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(strings);
    }
}
