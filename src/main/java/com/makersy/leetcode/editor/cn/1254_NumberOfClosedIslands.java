/**
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,
 * 1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 238 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

class NumberOfClosedIslands {
    public static void main(String[] args) {
        //Solution solution = new NumberOfClosedIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Queue<int[]> qu = new ArrayDeque<int[]>();
                        grid[i][j] = 1;
                        boolean closed = true;

                        qu.offer(new int[]{i, j});
                        while (!qu.isEmpty()) {
                            int[] arr = qu.poll();
                            int cx = arr[0], cy = arr[1];
                            if (cx == 0 || cy == 0 || cx == m - 1 || cy == n - 1) {
                                closed = false;
                            }
                            for (int d = 0; d < 4; d++) {
                                int nx = cx + dir[d][0];
                                int ny = cy + dir[d][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                                    grid[nx][ny] = 1;
                                    qu.offer(new int[]{nx, ny});
                                }
                            }
                        }
                        if (closed) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}