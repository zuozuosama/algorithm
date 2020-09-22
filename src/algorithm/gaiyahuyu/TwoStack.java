package algorithm.gaiyahuyu;

import java.util.Stack;

/**
 * 实时获取栈的最小值
 * 利用辅助栈的方式获取栈中的最小值
 */
public class TwoStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public TwoStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void pPush(int newNum) {
        stackData.push(newNum);
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (stackMin.peek() > newNum) {
            stackMin.push(newNum);
        } else {
            stackMin.push(stackMin.peek());
        }
    }

    public int pPop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stackData元素为空");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stackMin为空");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack();
        twoStack.pPush(3);
        twoStack.pPush(4);
        twoStack.pPush(2);
        System.out.println(twoStack.getMin());
        twoStack.pPop();
        System.out.println(twoStack.getMin());
    }
}
