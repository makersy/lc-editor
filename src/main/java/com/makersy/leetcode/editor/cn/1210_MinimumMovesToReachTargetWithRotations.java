/**
 * 你还记得那条风靡全球的贪吃蛇吗？
 * <p>
 * 我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用 0
 * 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
 * <p>
 * 每次移动，蛇可以这样走：
 * <p>
 * <p>
 * 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
 * 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
 * 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
 * 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
 * <p>
 * <p>
 * 返回蛇抵达目的地所需的最少移动次数。
 * <p>
 * 如果无法到达目的地，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,0,0,0,1],
 * [1,1,0,0,1,0],
 *                [0,0,0,0,1,1],
 *                [0,0,1,0,1,0],
 *                [0,1,1,0,0,0],
 *                [0,1,1,0,0,0]]
 * 输出：11
 * 解释：
 * 一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,1,1,1,1],
 *                [0,0,0,0,1,1],
 *                [1,1,0,0,0,1],
 *                [1,1,1,0,0,1],
 *                [1,1,1,0,0,1],
 *                [1,1,1,0,0,0]]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 100
 * 0 <= grid[i][j] <= 1
 * 蛇保证从空单元格开始出发。
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 矩阵 👍 109 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;

class MinimumMovesToReachTargetWithRotations {
    public static void main(String[] args) {
        //Solution solution = new MinimumMovesToReachTargetWithRotations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // cv
    class Solution {
        private static int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        public int minimumMoves(int[][] g) {
            int n = g.length;
            var vis = new boolean[n][n][2];
            var q = new ArrayList<int[]>();
            vis[0][0][0] = true;
            q.add(new int[]{0, 0, 0}); // 初始位置
            for (int step = 1; !q.isEmpty(); ++step) {
                var tmp = q;
                q = new ArrayList<>();
                for (var t : tmp) {
                    for (var d : DIRS) {
                        int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
                        int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                        if (x2 < n && y2 < n && !vis[x][y][s] &&
                                g[x][y] == 0 && g[x2][y2] == 0 && (d[2] == 0 || g[x + 1][y + 1] == 0)) {
                            if (x == n - 1 && y == n - 2) return step; // 此时蛇头一定在 (n-1,n-1)
                            vis[x][y][s] = true;
                            q.add(new int[]{x, y, s});
                        }
                    }
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}