package algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i], m.getOrDefault(nums1[i], 0) + 1);
        }
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            int n = m.getOrDefault(nums2[i], 0);
            if (n > 0) {
                nums1[k++] = nums2[i];
                m.put(nums2[i], n - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
