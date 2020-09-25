package algorithm.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 回溯算法 奇安信
 */
public class PermuteQuestion {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(nums, track);
        return res;
    }

    private void backtrace(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(track);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrace(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteQuestion permuteQuestion = new PermuteQuestion();
        int[] a = {1,2,3};
        permuteQuestion.permute(a);
    }
}
