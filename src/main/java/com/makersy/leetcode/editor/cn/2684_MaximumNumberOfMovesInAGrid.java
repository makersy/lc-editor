/**
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 * <p>
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 * <p>
 * <p>
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个 单元格中任一满足值 严格 大于当前单元格的单元格。
 * <p>
 * <p>
 * 返回你在矩阵中能够 移动 的 最大 次数。
 * <p>
 * <p>
 * <p>
 * 示例 1： 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]] 输出：3 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动： - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2). - (1, 2) -> (2, 3). 可以证明这是能够移动的最大次数。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]] 输出：0 解释：从第一列的任一单元格开始都无法移动。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length n == grid[i].length 2 <= m, n <= 1000 4 <= m * n <= 10⁵ 1 <= grid[i][j] <= 10⁶
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 41 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class MaximumNumberOfMovesInAGrid {

    public static void main(String[] args) {
        //Solution solution = new MaximumNumberOfMovesInAGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxMoves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            Set<Integer> q = new HashSet<>();
            for (int i = 0; i < m; i++) {
                q.add(i);
            }
            for (int j = 1; j < n; j++) {
                Set<Integer> q2 = new HashSet<>();
                for (int i : q) {
                    for (int i2 = i - 1; i2 <= i + 1; i2++) {
                        if (0 <= i2 && i2 < m && grid[i][j - 1] < grid[i2][j]) {
                            q2.add(i2);
                        }
                    }
                }
                q = q2;
                if (q.isEmpty()) {
                    return j - 1;
                }
            }
            return n - 1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}