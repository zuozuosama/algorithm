package algorithm.laohu;

import oldAlgorithm.LinkedListDemo.ListNode;

//leetcode 328
public class Case2 {
    /**
     * 排队
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode lineUp(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode dump = head.next;
        ListNode p = dump;
        while (cur.next != null && p.next != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        cur.next = dump;
        return head;
    }
}
