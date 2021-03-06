package leetcode;

import dataStructure.linkedNode.ListNode;

public class DetectCycle {

    /**
     * 环形链表 判断是否是环形链表以及入环点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //判断是否是环形链表
        ListNode fast = head, low = head;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                isCycle = true;
                break;
            }
        }

        //寻找入环点
        if (isCycle) {
            ListNode p = head;
            while (p != low) {
                p = p.next;
                low = low.next;
            }
            return p;
        } else {
            return null;
        }
    }

    /**
     * 判断是否是环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, null))));
        ListNode test = head;
        while (test.next != null) {
            test = test.next;
            if (test.next == null) {
                test.next = head.next;
                break;
            }
        }
        DetectCycle detectCycle = new DetectCycle();
        detectCycle.detectCycle(head);
    }
}
