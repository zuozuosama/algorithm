package algorithm;

import java.util.PriorityQueue;

/**
 * leetcode 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            integers.add(Integer.MIN_VALUE);
        }
        for (int num : nums) {
            Integer peek = integers.peek();
            if (peek < num) {
                integers.poll();
                integers.add(num);
            }
        }

        return integers.peek();
    }

    public static void main(String[] args) {
        int[] a = {-1, -1};
        findKthLargest(a, 2);
    }
}
