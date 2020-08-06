package oldAlgorithm.LinkedListDemo;

/**
 * 单向不循环链表
 */
public class DoubleLinklist {

    /**
     * 链表中的节点，data代表节点的值，next是后继节点,pre前驱节点
     *
     * @author zjn
     *
     */
    class Node {
        Node next;
        Node pre;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null; // 头节点

    /**
     * 向链表尾部添加元素,尾插法
     *
     * @param data
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
        newNode.pre = tmp;
    }

    /**
     * 向链表头部添加元素,头插法
     *
     * @param data
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head.pre = newNode;
        this.head = newNode;

    }

    /**
     * 在指定位置添加节点
     * @param pos
     * @param val
     */
    public void insert(int pos, int val){
        if (pos <= 0){
            addFirst(val);
        }else if (pos > length()-1){
            addNode(val);
        }else {
            Node cur = this.head;
            int count = 0;
            while (count < pos){
                count++;
                cur = cur.next;
            }
            Node newNode = new Node(val);
            newNode.next = cur;
            newNode.pre = cur.pre;
            cur.pre.next = newNode;
            cur.pre = newNode;
        }
    }

    /**
     *
     * @return 返回节点长度
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public boolean is_empty(){
        return this.head == null;
    }

    /**
     * 遍历链表
     */
    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * 查询某个节点是否在链表中
     * @param val
     * @return
     */
    public boolean search(int val){
        Node cur = this.head;
        while (cur != null){
            if (cur.data == val){
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }

    /**
     * @param index:删除第index个节点
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 0){
            return false;
        }
        int count = 0;
        Node pre = this.head;
        if (index == 0){
            this.head = pre.next;
            return true;
        }
        while (count < index-1){
            count++;
            pre = pre.next;
        }
        Node cur = pre.next;
        pre.next = cur.next;
        return true;
    }

    /**
     * 删除指定节点
     * @param item
     * @return
     */
    public boolean remove(int item) {
        Node cur = this.head;
        while (cur != null){
            if (cur.data == item){
                if (cur == this.head){
                    this.head = cur.next;
                    if (cur.next != null){
                        cur.next.pre = null;
                    }
                }else {
                    cur.pre.next = cur.next;
                    cur.next.pre = cur.pre;
                }
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DoubleLinklist list = new DoubleLinklist();
        list.addNode(0);
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        list.addFirst(7);

        list.insert(2,8);

        System.out.println("linkLength:" + list.length());
        list.printList(); //7 0 8 1 2 3 4 5
        list.remove(4);
        System.out.println("After remove(item: 4):");
        list.printList(); //7 0 8 1 2 3 5
        list.deleteNode(3);
        System.out.println("After deleteNode(index: 3):");
        list.printList();

        System.out.println("删除头结点:");
        list.deleteNode(0);
        list.printList();

        System.out.println("删除小于0的序数");
        list.deleteNode(-1);
        list.printList();
    }
}