package leetcode.changkaoti;

import dataStructure.linkedNode.ListNode;

/**
 * 反转链表
 * 1->2->3->4
 * 反转为4->3->2->1
 */
public class JianZhiOffer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode reverse = reverseList(next);
        next.next = head;
        head.next = null;
        return reverse;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, cur, next;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
