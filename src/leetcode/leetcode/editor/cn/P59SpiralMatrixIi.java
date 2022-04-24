package leetcode.leetcode.editor.cn;
//螺旋矩阵 II
////给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟

public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int count = 1;
            int startX = 0;
            int startY = 0;
            int loop = n / 2;
            int offset = 1;
            int mid = n / 2;

            while (loop > 0) {
                int i = startX;
                int j = startY;
                //从左到右
                for (; j < n - offset; j++) {
                    matrix[i][j] = count++;
                }
                //从上到下
                for (; i < n - offset; i++) {
                    matrix[i][j] = count++;
                }
                //从右到左
                for (; j > startY; j--) {
                    matrix[i][j] = count++;
                }
                //从下到上
                for (; i > startX; i--) {
                    matrix[i][j] = count++;
                }
                startX++;
                startY++;
                loop--;
                offset++;
            }

            if (n % 2 == 1) {
                matrix[mid][mid] = count;
            }

            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}