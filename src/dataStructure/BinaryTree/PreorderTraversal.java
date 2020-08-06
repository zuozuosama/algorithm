package dataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历：迭代法
 */
public class PreorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) return integers;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode temp = treeNodes.pop();
            integers.add(temp.val);
            if (temp.right != null) {
                treeNodes.push(temp.right);
            }
            if (temp.left != null) {
                treeNodes.push(temp.left);
            }

        }
        return integers;
    }
}
