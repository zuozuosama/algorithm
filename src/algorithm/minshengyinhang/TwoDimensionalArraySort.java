package algorithm.minshengyinhang;

import java.util.Arrays;

/**
 * 对二维数组排序，民生银行总行笔试题
 */
public class TwoDimensionalArraySort {
    public static void main(String[] args) {
        int[][] a = new int[][]{{10, 1}, {9, 3}, {9, 2}};
        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        for (int[] b : a) {
            String s = Arrays.toString(b);
            System.out.print(s + " ");
        }
    }
}
