package leetcode.leetcode.editor.cn;
//螺旋矩阵
////给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟

import java.util.LinkedList;
import java.util.List;

public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // // TO TEST
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{7}, {9}, {6}};
        solution.spiralOrder(matrix);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            List<Integer> res = new LinkedList<>();

            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    res.add(matrix[i][0]);
                }
                return res;
            }

            int startX = 0;
            int startY = 0;
            int mid = n / 2;
            int loop = n / 2;
            int offset = 1;
            while (loop > 0) {
                int i = startX;
                int j = startY;
                for (; j < m - offset; j++) {
                    res.add(matrix[i][j]);
                }
                for (; i < n - offset; i++) {
                    res.add(matrix[i][j]);
                }
                for (; j > startY; j--) {
                    res.add(matrix[i][j]);
                }
                for (; i > startX; i--) {
                    res.add(matrix[i][j]);
                }
                startX++;
                startY++;
                loop--;
                offset++;
            }

            if (n % 2 == 1) {
                if (n != m) {
                    int j = startY;
                    for (; j < m - offset; j++) {
                        res.add(matrix[startX][j]);
                    }
                    res.add(matrix[startX][j]);
                } else {
                    res.add(matrix[mid][mid]);
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}