package leetcode;

import dataStructure.linkedNode.ListNode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 快慢指针
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode low = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.val;

        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        return low.next.val;
    }
}
