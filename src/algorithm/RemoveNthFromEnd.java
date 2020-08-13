package algorithm;

/**
 * 快慢指针
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        int n = 5;
        ListNode dump = new ListNode(0);
        ListNode head = new ListNode(1);
        dump.next = head;
        ListNode cur = head;
        for (int i = 2; i <= n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        while (dump.next != null) {
            System.out.print(dump.next.val + "->");
            dump = dump.next;
        }
        System.out.println();
        RemoveNthFromEnd remove = new RemoveNthFromEnd();
        ListNode node = remove.removeNthFromEnd(head, 2);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针一次遍历删除节点（快慢指针）
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 两次遍历删除节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

}