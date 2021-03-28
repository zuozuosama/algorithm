package leetcode.changkaoti;

import dataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102. 二叉树的层序遍历
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
