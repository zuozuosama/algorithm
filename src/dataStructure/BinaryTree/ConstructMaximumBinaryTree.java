package dataStructure.BinaryTree;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if (l >= r) return null;
        int maxIndex = maxIndex(nums, l, r);
        int max = nums[maxIndex];
        TreeNode root = new TreeNode(max);
        TreeNode left = construct(nums, l, maxIndex);
        TreeNode right = construct(nums, maxIndex + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }

    private int maxIndex(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = l; i < r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
