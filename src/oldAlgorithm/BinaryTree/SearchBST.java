package oldAlgorithm.BinaryTree;


/**
 * 二叉搜索树查找关键字为key的节点，成功时返回该节点位置，否则返回null
 */
public class SearchBST {
    public static TreeNode searchBST(TreeNode root, int key){
        if (root==null){
            return null;
        }
        if (root.val > key){
            return searchBST(root.lchild,key);
        }else if (root.val < key){
            return searchBST(root.rchild,key);
        }else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(4)));
        TreeNode treeNode = searchBST(root, 5);
        if (treeNode!=null) System.out.println(treeNode.val);
        else System.out.println("没有此值");
    }
}
