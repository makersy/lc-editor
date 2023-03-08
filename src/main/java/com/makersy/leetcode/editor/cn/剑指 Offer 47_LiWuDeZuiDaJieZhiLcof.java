/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到
 * 达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 450 👎 0
 */

package com.makersy.leetcode.editor.cn;

class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        //Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int h = grid.length, w = grid[0].length;
            int[] dp = new int[w];
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(j == 0) dp[j] += grid[i][j];
                    else dp[j] = Math.max(dp[j], dp[j-1]) + grid[i][j];
                }
            }
            return dp[w-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}