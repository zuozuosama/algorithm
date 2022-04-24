package leetcode.leetcode.editor.cn;
//两数相加 II
////给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学

import dataStructure.linkedNode.ListNode;

import java.util.Stack;

public class P445AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            ListNode a = reverse(l1);
            ListNode b = reverse(l2);
            ListNode dummy = new ListNode(0);
            ListNode curNode = dummy;
            int add = 0, cur;
            while (a != null || b != null || add != 0) {
                int m = a != null ? a.val : 0;
                int n = b != null ? b.val : 0;
                cur = m + n + add;
                int c = cur % 10;
                add = cur / 10;
                curNode.next = new ListNode(c);
                if (a != null) {
                    a = a.next;
                }
                if (b != null) {
                    b = b.next;
                }
                curNode = curNode.next;
            }
            return reverse(dummy.next);
        }

        private ListNode reverse(ListNode l1) {
            ListNode pre = null;
            ListNode cur = l1;
            ListNode next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            while (l1 != null) {
                stack1.push(l1);
                l1 = l1.next;
            }

            while (l2 != null) {
                stack2.push(l2);
                l2 = l2.next;
            }

            int add = 0;
            ListNode head = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || add > 0) {
                int a = !stack1.isEmpty() ? stack1.pop().val : 0;
                int b = !stack2.isEmpty() ? stack2.pop().val : 0;
                int c = a + b + add;
                int cur = c % 10;
                add = c / 10;
                ListNode listNode = new ListNode(cur);
                listNode.next = head;
                head = listNode;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
