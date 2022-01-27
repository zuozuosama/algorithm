package leetcode.leetcode.editor.cn;
//寻找两个正序数组的中位数
////给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治

public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] merge = merge(nums1, nums2);
            int length = merge.length;
            double res;
            int mid = length >> 1;
            if (length % 2 == 0) {
                res = (merge[mid] + merge[mid - 1]) / 2.0;
            } else {
                res = merge[mid];
            }
            return res;
        }

        private int[] merge(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            if (n == 0) {
                return nums2;
            }
            if (m == 0) {
                return nums1;
            }
            int[] merge = new int[n + m];
            int i = 0, j = 0, index = 0;
            while (i < n && j < m) {
                if (nums1[i] < nums2[j]) {
                    merge[index++] = nums1[i++];
                } else {
                    merge[index++] = nums2[j++];
                }
            }
            while (i < n) {
                merge[index++] = nums1[i++];
            }
            while (j < m) {
                merge[index++] = nums2[j++];
            }
            return merge;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}