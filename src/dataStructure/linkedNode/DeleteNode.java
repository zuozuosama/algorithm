package dataStructure.linkedNode;

/**
 * O(1)时间复杂度
 * 删除链表中的节点
 */
public class DeleteNode {
    public void delete_node(ListNode head, ListNode p) {
        if (head == null || p == null) return;
        //待删除节点不是最后一个
        if (p.next != null) {
            p.val = p.next.val;
            p.next = p.next.next;
        } else if (head == p) {
            head = null;
        } else {
            ListNode dump = head;
            while (dump.next != null) {
                if (dump.next == p) {
                    dump.next = null;
                    break;
                }
                dump = dump.next;
            }
        }
    }

    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        ListNode head = new ListNode(2, new ListNode(3, new ListNode(5, null)));
        dn.delete_node(head,head.next.next);
    }
}
