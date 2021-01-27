package leetcode;

import dataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;

/**
 * 序列化与反序列化二叉树
 * 前序遍历序列化
 */
public class CodecII {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        serialize(root, res);
        return res.toString();
    }

    public void serialize(TreeNode root, LinkedList<Integer> res) {
        if (root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        serialize(root.left, res);
        serialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String a = data.substring(1, data.length() - 1);
        if (a.isEmpty()) return null;
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : a.split(",")) {
            nodes.addLast(node);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String cur = nodes.removeFirst().trim();
        if (cur.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
