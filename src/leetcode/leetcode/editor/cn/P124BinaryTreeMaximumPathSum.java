package leetcode.leetcode.editor.cn;
//二叉树中的最大路径和
////路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树

import leetcode.TreeNode;

public class P124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(-3);
        root.left = new TreeNode(-1);
        int res = solution.maxPathSum(root);
        System.out.println(res);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        // private int res = Integer.MIN_VALUE;
        //
        // public int maxPathSum(TreeNode root) {
        //     int ret = maxPath(root);
        //     return Math.max(ret, res);
        // }
        //
        // public int maxPath(TreeNode root) {
        //     if (root == null) return Integer.MIN_VALUE;
        //     int left = maxPath(root.left);
        //     int right = maxPath(root.right);
        //     int cur = Math.max(Math.max(left, right), left + right + root.val);
        //     res = Math.max(res, cur);
        //     return Math.max(Math.max(left + root.val, right + root.val), root.val);
        // }

        private int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPath(root);
            return res;
        }

        public int maxPath(TreeNode root) {
            if (root == null) return 0;
            int left = Math.max(0, maxPath(root.left));
            int right = Math.max(0, maxPath(root.right));
            res = Math.max(res, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}