package leetcode;

import dataStructure.linkedNode.ListNode;

/**
 * 反转链表
 */
public class JianZhiOffer24 {
    public ListNode reverseList(ListNode head) {
        if(head == null||head.next==null) return head;
        ListNode next =head.next;
        ListNode reverse =reverseList(next);
        next.next=head;
        head.next=null;
        return reverse;
    }
}
