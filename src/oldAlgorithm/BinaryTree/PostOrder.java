package oldAlgorithm.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的使用迭代方式的后序遍历
 */
public class PostOrder {
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if ((cur.lchild==null && cur.rchild==null)||(pre!=null&&(pre==cur.lchild||pre==cur.rchild))){
                list.add(cur.val);
                stack.pop();
                pre = cur;
            }else {
                if (cur.rchild!=null){
                    stack.push(cur.rchild);
                }
                if (cur.lchild!=null){
                    stack.push(cur.lchild);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null),
                new TreeNode(3, null, null));
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }
}
