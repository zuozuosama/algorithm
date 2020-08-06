package dataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历：递归法
 */
public class PreorderTraversal1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        return preorder(root, integers);
    }

    private List<Integer> preorder(TreeNode root, List<Integer> integers) {
        if (root == null) return integers;
        integers.add(root.val);
        preorder(root.left, integers);
        preorder(root.right, integers);
        return integers;
    }
}
