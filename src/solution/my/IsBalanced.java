package solution.my;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回 true 。
 */
public class IsBalanced {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class ReturnNode {
        int depth;
        boolean isb;

        public ReturnNode(int depth, boolean isb) {
            this.depth = depth;
            this.isb = isb;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBST(root).isb;
    }

    private ReturnNode isBST(TreeNode root) {
        if (root == null) return new ReturnNode(0, true);
        ReturnNode left = isBST(root.left);
        ReturnNode right = isBST(root.right);
        int c = Math.abs(left.depth - right.depth);
        if (!left.isb || !right.isb) {
            return new ReturnNode(0, false);
        }
        if (c > 1) return new ReturnNode(0, false);
        return new ReturnNode(Math.max(left.depth, right.depth) + 1, true);
    }
}
