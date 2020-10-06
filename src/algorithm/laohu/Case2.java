package algorithm.laohu;


import dataStructure.linkedNode.ListNode;

//leetcode 328
public class Case2 {
    /**
     * 排队
     *
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode dump = cur;
        while (pre.next != null && cur.next != null) {
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            cur = cur.next;
        }
        pre.next = dump;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        Case2 case2 = new Case2();
        case2.oddEvenList(listNode);
    }
}
