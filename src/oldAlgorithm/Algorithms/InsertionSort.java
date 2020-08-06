package oldAlgorithm.Algorithms;
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }

    public ListNode(ListNode node,int val){
        this.val = val;
        this.next = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while(p!=null) {
            sb.append(p.val+"->");
            p=p.next;
        }
        String string = sb.toString();
        return string.substring(0,string.length()-2);
    }
}

public class InsertionSort {
    /**
     * help记录排序好的节点(最终)
     * pre记录已经排序好的节点
     * cur记录当前要插入的节点
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if(head == null||head.next ==null)
            return head;
        ListNode help=new ListNode(0);//辅助结点；
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode next=cur.next;//记录下一个结点；
            ListNode pre=help;//每次都遍历一次新链表，找到 cur结点所要插入的位置；
            while(pre.next!=null&&pre.next.val<cur.val)
            {
                pre=pre.next;
            }
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        return help.next;
    }

    private static void test2() {
        ListNode head = new ListNode(new ListNode(new ListNode(new ListNode(null,3), 1), 2), 4);
        //4->2->1->3
        System.out.println(head);
        ListNode sorted = insertionSortList(head);
        System.out.println(sorted.val);
        System.out.println(sorted);
        //1->2->3->4
    }

    public static void main(String[] args) {
        test2();
    }
}
