/**
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 183 👎 0
 */

package com.makersy.leetcode.editor.cn;

class Largest1BorderedSquare {
    public static void main(String[] args) {
        //Solution solution = new Largest1BorderedSquare().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int h = grid.length, w = grid[0].length;
            // 0-左侧 1-上侧
            int[][][] dp = new int[h][w][2];
            int res = 0;

            for (int i = 0; i < w; i++) {
                if (i == 0) {
                    dp[0][i][0] = grid[0][i] == 1 ? 1 : 0;
                    dp[0][i][1] = dp[0][i][0];
                } else {
                    if (grid[0][i] == 1) {
                        dp[0][i][0] = dp[0][i - 1][0] + 1;
                        dp[0][i][1] = 1;
                    }
                }
                res = Math.max(res, dp[0][i][1]);
            }

            for (int i = 1; i < h; i++) {
                if (grid[i][0] == 1) {
                    dp[i][0][0] = 1;
                    dp[i][0][1] = dp[i-1][0][1] + 1;
                }
                res = Math.max(res, dp[i][0][0]);
            }

            for (int i = 1; i < h; i++) {
                for (int j = 1; j < w; j++) {
                    if (grid[i][j] == 1) {
                        dp[i][j][0] = dp[i][j-1][0] + 1;
                        dp[i][j][1] = dp[i-1][j][1] + 1;
                        for (int minl = Math.min(dp[i][j][0], dp[i][j][1]); minl >= 1; minl--) {
                            if (dp[i - minl + 1][j][0] >= minl && dp[i][j - minl + 1][1] >= minl) {
                                res = Math.max(res, minl * minl);
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}