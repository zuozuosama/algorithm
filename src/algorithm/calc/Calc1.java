package algorithm.calc;

import java.util.Stack;

/**
 * 现在进一步，如果输入的这个算式只包含加减法，而且不存在空格，你怎么计算结果？我们拿字符串算式1-12+3为例，
 * 来说一个很简单的思路
 * 处理加减法
 * 1-12+3
 */
public class Calc1 {
    public static int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if (c >= 48 && c <= 57)
                num = 10 * num + (c - '0');
            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if ((c < 48 || c > 57) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }
        // 将栈中所有结果求和就是答案
        int res = 0;
        while (!stk.empty()) {
            res += stk.peek();
            stk.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate("1-12+3");
        System.out.println(calculate);
    }
}
