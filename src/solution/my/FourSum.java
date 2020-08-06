package solution.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 双指针剪枝定界法
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        int length = nums.length;
        for (int k = 0; k < length - 3; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) continue;
            int min = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            int max = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (min > target) break;
            if (max < target) continue;
            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i - 1] == nums[i]) continue;
                min = nums[k] + nums[i] + nums[i + 1] + nums[i + 2];
                max = nums[k] + nums[i] + nums[length - 2] + nums[length - 1];
                if (min > target) break;
                if (max < target) continue;
                int j = i + 1;
                int h = length - 1;
                while (j < h) {
                    int cur = nums[k] + nums[i] + nums[j] + nums[h];
                    if (cur == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        while (j < h && nums[j] == nums[j + 1]) j++;
                        while (j < h && nums[h] == nums[h - 1]) h--;
                        j++;
                        h--;
                    } else if (cur > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum.fourSum(nums, 0);
        System.out.println(lists);
    }
}
