package leetcode.changkaoti;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组和一个整数 target，可以保证数组中存在两个数的和为 target，请你返回这两个数的索引。
 * 比如输入 nums = [3,1,3,6], target = 6，算法应该返回数组 [0,2]，因为 3 + 3 = 6。
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();
        // 构造一个哈希表：元素映射到相应的索引
        for (int i = 0; i < n; i++)
            index.put(nums[i], i);

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            // 如果 other 存在且不是 nums[i] 本身
            if (index.containsKey(other) && index.get(other) != i)
                return new int[]{i, index.get(other)};
        }

        return new int[]{-1, -1};
    }


    // O(n) 哈希表（一次哈希） 改进算法
    public int[] twoSum1(int[] nums, int target) {
        if (nums != null) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (hashMap.containsKey(temp))
                    return new int[]{hashMap.get(temp), i};
                else
                    hashMap.put(nums[i], i);
            }
        }
        return null;
    }
}
