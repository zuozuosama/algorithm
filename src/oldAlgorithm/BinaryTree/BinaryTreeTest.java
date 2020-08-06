package oldAlgorithm.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTest {

    TreeNode root;

    public void add(int val){
        TreeNode newNode = new TreeNode(val);
        if (root == null){
            root = newNode;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.size() != 0){
            TreeNode node = queue.poll();
            if (node.lchild == null){
                node.lchild = newNode;
                return;
            }else {
                queue.offer(node.lchild);
            }

            if (node.rchild == null){
                node.rchild = newNode;
                return;
            }else {
                queue.offer(node.rchild);
            }
        }
    }

    public void breadth_travel(){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.size() != 0){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.lchild != null){
                queue.offer(node.lchild);
            }
            if (node.rchild != null){
                queue.offer(node.rchild);
            }
        }
    }

    public void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.val + " ");
        preOrder(node.lchild);
        preOrder(node.rchild);
    }

    public void midOrder(TreeNode node){
        if (node == null){
            return;
        }
        midOrder(node.lchild);
        System.out.println(node.val + " ");
        midOrder(node.rchild);
    }

    public void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.lchild);
        postOrder(node.rchild);
        System.out.println(node.val + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTest binaryTree = new BinaryTreeTest();
        TreeNode[] treeNode = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            treeNode[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i*2+1 < 10){
                treeNode[i].lchild = treeNode[i*2+1];
            }
            if (i*2+2 < 10){
                treeNode[i].rchild = treeNode[i*2+2];
            }
        }
        binaryTree.root = treeNode[0];
        binaryTree.breadth_travel();

        System.out.println("============================================================");
        BinaryTreeTest binaryTree1 = new BinaryTreeTest();
        //广度优先遍历生成二叉树并遍历
        binaryTree1.add(0);
        binaryTree1.add(1);
        binaryTree1.add(2);
        binaryTree1.add(3);
        binaryTree1.add(4);
        binaryTree1.add(5);
        binaryTree1.add(6);
        binaryTree1.add(7);
        binaryTree1.add(8);
        binaryTree1.add(9);
        binaryTree1.breadth_travel();
        System.out.println("前序遍历:");
        binaryTree1.preOrder(binaryTree1.root);
        System.out.println();
        System.out.println("中序遍历:");
        binaryTree1.midOrder(binaryTree1.root);
        System.out.println();
        System.out.println("后序遍历:");
        binaryTree1.postOrder(binaryTree1.root);
    }
}
