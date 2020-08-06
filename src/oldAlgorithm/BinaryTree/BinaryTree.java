package oldAlgorithm.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历：广度遍历和深度遍历（前中后序遍历）
 */
public class BinaryTree {

    static class Node{
        int val;
        Node lchid;
        Node rchid;
        public Node(int val){
            this.val = val;
        }
    }

    //根节点，初始值为null
    private static Node root;

    public static void main(String[] args) {
        System.out.println("===================================类似广度遍历添加节点===================================");
        //类似广度遍历添加节点
        Node[] node = new Node[10];
        int length = node.length;
        for (int i = 0; i < length; i++) {
            node[i] = new Node(i);
        }
        for (int i = 0; i < length; i++) {
            if (i*2+1 < length){
                node[i].lchid = node[i*2+1];
            }
            if (i*2+2 < length){
                node[i].rchid = node[i*2+2];
            }
        }
        System.out.print("前序遍历:");
        preOrder(node[0]);
        System.out.println();
        System.out.print("中序遍历:");
        midOrder(node[0]);
        System.out.println();
        System.out.print("后序遍历:");
        postOrder(node[0]);

        System.out.println();
        System.out.println("广度优先遍历");
        breadth_search();
        System.out.println("===========================广度优先遍历生成二叉树并遍历===================================");

        //广度优先遍历生成二叉树并遍历
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        breadth_search();
        System.out.print("前序遍历:");
        preOrder(root);
        System.out.println();
        System.out.print("中序遍历:");
        midOrder(root);
        System.out.println();
        System.out.print("后序遍历:");
        postOrder(root);
    }

    /**
     * 广度优先遍历生成二叉树
     * @param val
     */
    public static void add(int val){
        Node node = new Node(val);
        if (root == null){
            root = node;
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        //一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝
        //这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，
        // 而只是得到由 offer() 返回的 false。

        //添加头结点
        queue.offer(root);
        while (queue.size() != 0){
            //remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，
            // 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
            Node pollNode = queue.poll();
            if (pollNode.lchid == null){
                pollNode.lchid = node;
                return;
            }else {
                queue.offer(pollNode.lchid);
            }

            if (pollNode.rchid == null){
                pollNode.rchid = node;
                return;
            }else {
                queue.offer(pollNode.rchid);
            }
        }

    }

    public static void breadth_search(){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (queue.size() != 0){
            Node pollNode = queue.poll();
            System.out.println(pollNode.val);
            if (pollNode.lchid != null){
                queue.offer(pollNode.lchid);
            }
            if (pollNode.rchid != null){
                queue.offer(pollNode.rchid);
            }
        }
    }


    /**
     * 前序遍历: 根 左 右
     * @param node
     */
    private static void preOrder(Node node) {
        if (node == null){
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.lchid);
        preOrder(node.rchid);
    }

    /**
     * 中序遍历: 左 根 右
     * @param node
     */
    private static void midOrder(Node node) {
        if (node == null){
            return;
        }
        midOrder(node.lchid);
        System.out.print(node.val + " ");
        midOrder(node.rchid);
    }

    /**
     * 后序遍历: 左 右 根
     * @param node
     */
    private static void postOrder(Node node) {
        if (node == null){
            return;
        }
        postOrder(node.lchid);
        postOrder(node.rchid);
        System.out.print(node.val + " ");
    }
}
