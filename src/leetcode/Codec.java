package leetcode;

import dataStructure.BinaryTree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 层序遍历BFS
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                res.add(null);
                continue;
            }
            res.add(cur.val);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String a = data.substring(1, data.length() - 1);
        String[] nodes = a.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        for (int i = 1; i < nodes.length; ) {
            TreeNode parent = q.poll();
            String left = nodes[i++];
            if (!left.equals("null")) {
                TreeNode l = new TreeNode(Integer.parseInt(left));
                parent.left = l;
                q.offer(l);
            } else {
                parent.left = null;
            }

            String right = nodes[i++];
            if (!right.equals("null")) {
                TreeNode r = new TreeNode(Integer.parseInt(right));
                parent.right = r;
                q.offer(r);
            } else {
                parent.right = null;
            }
        }
        return root;
    }

    @Test
    public void ts(){
        String a  ="[1,2,3,null,null,4,5]";
        Codec codec = new Codec();
        codec.deserialize(a);
    }
}
