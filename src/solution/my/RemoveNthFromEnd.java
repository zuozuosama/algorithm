package solution.my;

public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针一次遍历删除节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode first = dump;
        ListNode second = dump;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first !=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dump.next;
    }
}
