package leetcode.leetcode.editor.cn;
//数组中的第K个最大元素
////给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）

import java.util.PriorityQueue;
import java.util.Random;

public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //优先队列，小根堆
        public int findKthLargest1(int[] nums, int k) {
            if (nums.length == 0 || k > nums.length) return 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                queue.offer(Integer.MIN_VALUE);
            }
            for (int num : nums) {
                if (!queue.isEmpty() && num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
            return queue.peek();
        }

        //快速排序改动版
        public int findKthLargest(int[] nums, int k) {
            return partition(nums, 0, nums.length - 1, k);
        }

        private int partition(int[] nums, int left, int right, int k) {
            if (left < right) {
                int i = left, j = right;

                //随机快排加快效率
                //们知道快速排序的性能和「划分」出的子数组的长度密切相关。直观地理解如果每次规模为 n 的问题我们都划分成 1和 n - 1，
                // 每次递归的时候又向 n−1 的集合中递归，这种情况是最坏的，时间代价是 O(n ^ 2)
                //我们可以引入随机化来加速这个过程，它的时间代价的期望是 O(n)，证明过程可以参考「《算法导论》9.2：期望为线性的选择算法」。
                Random random = new Random();
                int randomIndex = random.nextInt(j - i + 1) + i;
                swap(nums, i, randomIndex);

                int pivot = nums[i];
                while (i < j) {
                    while (i < j && nums[j] <= pivot) {
                        j--;
                    }
                    if (i < j) {
                        nums[i] = nums[j];
                    }
                    while (i < j && nums[i] >= pivot) {
                        i++;
                    }
                    if (i < j) {
                        nums[j] = nums[i];
                    }
                }
                nums[i] = pivot;
                if (k - 1 == i) {
                    return nums[i];
                } else if (k - 1 > i) {
                    return partition(nums, i + 1, right, k);
                } else if (k - 1 < i) {
                    return partition(nums, left, i - 1, k);
                }
            }
            return nums[left];
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}