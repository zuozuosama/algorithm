package algorithm.oukeyunlian;

import java.util.Scanner;
import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack, maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || maxStack.peek() <= x) {
            maxStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty() || maxStack.isEmpty()) return;
        if (maxStack.peek().equals(stack.pop())) {
            maxStack.pop();
        }
    }

    public int max() {
        System.out.println(maxStack.peek());
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaxStack ms = new MaxStack();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] s = line.split(" ");
        for (String s1 : s) {
            ms.push(Integer.parseInt(s1));
        }
        ms.max();
    }
}