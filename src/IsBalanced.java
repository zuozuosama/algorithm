import dataStructure.BinaryTree.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(getHigh(root.left)-getHigh(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        return false;
    }

    private int getHigh(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHigh(root.left),getHigh(root.right))+1;
    }
}
