package oldAlgorithm.Algorithms;

import java.util.Stack;

/**
 * 逆波兰表达式(后缀表达式)
 * ["2","1","+","3","*"]->((2+1)*3)->9
 * ["4","13","5","/","+"]->(4+(13/5))->6
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] token1 = {"2","1","+","3","*"};
        String[] token2 = {"4","13","5","/","+"};

        int ret1 = evalRPN(token1);
        int ret2 = evalRPN(token2);

        System.out.println("ret1: " + ret1);
        System.out.println("ret2: " + ret2);
    }

    private static int evalRPN(String[] token) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0;i < token.length;i++){
            try {
                int num = Integer.parseInt(token[i]);
                stack.add(num);
            }catch (Exception e){
                int b = stack.pop();
                System.out.println("b:" + b);
                int a = stack.pop();
                System.out.println("a:" + a);
                stack.add(get(a,b,token[i]));
            }
        }
        return stack.pop();
    }
    private static int get(int a,int b,String operator){
        switch (operator){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default:return 0;
        }
    }
}
