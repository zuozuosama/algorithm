package algorithm.qianxin;

import java.util.LinkedList;
import java.util.List;

/**
 * 区间重叠数 区间调度之区间交集问题
 */
public class IntervalIntersection {
    public List<int[]> intervalIntersection(List<int[]> A, List<int[]> B) {
        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i <= A.size() && j <= B.size()) {
            int a1 = A.get(i)[0], a2 = A.get(i)[1];
            int b1 = B.get(i)[0], b2 = B.get(i)[1];
            if (b2 >= a1 && a2 >= b1) {
                int[] arr = new int[2];
                arr[0] = Math.max(a1, b1);
                arr[1] = Math.min(a2, b2);
                res.add(arr);
            }
            if (b2 < a2) j++;
            else i++;
        }
        return res;
    }
}
