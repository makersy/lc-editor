/**
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 * <p>
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵 maxLocal ，并满足：
 * <p>
 * <p>
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * <p>
 * <p>
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 * <p>
 * 返回生成的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 👍 67 👎 0
 */

package com.makersy.leetcode.editor.cn;

class LargestLocalValuesInAMatrix {
    public static void main(String[] args) {
        //Solution solution = new LargestLocalValuesInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int h = grid.length, w = grid[0].length;
            int[][] res = new int[h - 2][w - 2];
            for (int i = 0; i < h - 2; i++) {
                for (int j = 0; j < w - 2; j++) {
                    res[i][j] = max(grid, i, j);
                }
            }
            return res;
        }

        private int max(int[][] arr, int i, int j) {
            int max = arr[i][j];
            for (int a = i; a < i + 3; a++) {
                for (int b = j; b < j + 3; b++) {
                    max = Math.max(max, arr[a][b]);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}