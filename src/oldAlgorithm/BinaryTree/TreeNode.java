package oldAlgorithm.BinaryTree;

public class TreeNode {
    int val;
    TreeNode lchild;
    TreeNode rchild;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val,TreeNode lchild,TreeNode rchild){
        this.val = val;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}
