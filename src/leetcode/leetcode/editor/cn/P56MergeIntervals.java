package leetcode.leetcode.editor.cn;
//合并区间
////以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return intervals;
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> merged = new LinkedList<>();
            for (int i = 0; i < intervals.length; i++) {
                int L = intervals[i][0], R = intervals[i][1];
                if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(intervals[i]);
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}