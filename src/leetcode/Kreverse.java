package leetcode;

import dataStructure.linkedNode.ListNode;

/**
 * 25. K 个一组翻转链表
 */
public class Kreverse {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        head.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
