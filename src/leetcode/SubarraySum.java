package leetcode;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class SubarraySum {


    /**
     * 哈希表+前缀和优化
     * 时间复杂度o(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // hash
        // 记录合适的连续子数组数量
        int count = 0;
        // 记录前面数字相加之和
        int pre = 0;
        // map记录前几个数字之和为K出现相同和的次数为V
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 如果前面数字之和加上这个数字正好等于K（存在一个数字加上nums[i]结果为K
            // 说明找到了
            if (map.containsKey(pre - k)) {
                // 累计
                count += map.get(pre - k);
            }
            // 计算新的和放入map
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /**
     * 前缀和，时间复杂度o(n^2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums={1,1,1};
        int k =2;
        System.out.println(subarraySum.subarraySum(nums,k));
    }
}
