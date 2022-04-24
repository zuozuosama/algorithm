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
            List<Integer> res = new LinkedList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
            int rows = matrix.length;
            int columns = matrix[0].length;
            int row = 0, column = 0;
            int total = rows * columns;
            boolean[][] visit = new boolean[rows][columns];
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int direction = 0;
            for (int i = 0; i < total; i++) {
                res.add(matrix[row][column]);
                visit[row][column] = true;
                int nextRow = row + directions[direction][0];
                int nextColumn = column + directions[direction][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visit[nextRow][nextColumn]) {
                    direction = (direction + 1) % 4;
                }
                row = row + directions[direction][0];
                column = column + directions[direction][1];

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}