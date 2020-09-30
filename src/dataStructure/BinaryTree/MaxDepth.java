package dataStructure.BinaryTree;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 队列实现
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int ans = 0;
        if (root != null) {
            q.offer(new Pair(root, 1));
        }
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> cur = q.poll();
            int curDepth = cur.getValue();
            TreeNode curNode = cur.getKey();
            ans = Math.max(ans, curDepth);
            if (curNode.left != null) {
                q.offer(new Pair(curNode.left, curDepth + 1));
            }
            if (curNode.right != null) {
                q.offer(new Pair(curNode.right, curDepth + 1));
            }
        }
        return ans;
    }
}
