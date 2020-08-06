package dataStructure.stack;

import java.util.Stack;

public class PrintListFromTailToHead {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void solution(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, new ListNode(8, new ListNode(9, new ListNode(19, null))));
        PrintListFromTailToHead pl = new PrintListFromTailToHead();
        pl.solution(listNode);
    }
}
