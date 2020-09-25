package algorithm.calc;

import java.util.Stack;

/**
 * 处理乘除法和空格
 */
public class Calc2 {
    private static int i = 0;

    public static int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        int pre;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            // 如果是数字，连续读取到 num
            if (Character.isDigit(c))
                num = 10 * num + (c - '0');

            if (c == '(') {
                i++;
                num = calculate(s);
            }

            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    // 只要拿出前一个数字做对应运算即可
                    case '*':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }

            if (c == ')')
                break;
        }
        int res = 0;
        // 将栈中所有结果求和就是答案
        while (!stk.empty()) {
            res += stk.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate("1 -(12-2) +3");
        System.out.println(calculate);
    }
}
