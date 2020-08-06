package dataStructure.linkedNode;


public class MaxMethod {
    /**
     * 链表求最大
     */
    public int findMax(ListNode root) {
        if (root == null) return -1;
        int comp1 = root.val;
        int comp2 = findMax(root.next);
        return Math.max(comp1, comp2);
    }

    /**
     * 数组求最大
     * @param nums
     * @return
     */
    public int maxIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;

            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3,new ListNode(2,new ListNode(7)));
        int max = new MaxMethod().findMax(root);
        System.out.println(max);
    }
}
