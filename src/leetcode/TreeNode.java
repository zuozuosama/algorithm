package leetcode;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author lizq9
 * @Date 2021/11/15 16:43
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}