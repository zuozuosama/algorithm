package algorithm.fiveEight;

import oldAlgorithm.BinaryTree.BinaryTree;

import java.util.ArrayList;

public class Case2 {

    int[] input;
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();

    /**
     * 对给定的二叉树依次完成前序，中序，后序遍历，并输出遍历结果
     *
     * @param input int整型一维数组 -1表示Nil节点
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> binaryTreeScan(int[] input) {
        this.input=input;
        preorder(0);
        inorder(0);
        postorder(0);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        arrayLists.add(pre);
        arrayLists.add(in);
        arrayLists.add(post);
        return arrayLists;
    }


    public void preorder(int index) {
        if (index >= input.length)
            return;
        System.out.println(input[index]);
        pre.add(input[index]);
        preorder(index * 2 + 1);
        preorder(index * 2 + 2);
    }

    public void inorder(int index) {
        if (index >= input.length)
            return;
        inorder(index * 2 + 1);
        in.add(input[index]);
        inorder(index * 2 + 2);
    }

    public void postorder(int index) {
        if (index >= input.length)
            return;

        postorder(index * 2 + 1);
        postorder(index * 2 + 2);
        post.add(input[index]);
    }
}