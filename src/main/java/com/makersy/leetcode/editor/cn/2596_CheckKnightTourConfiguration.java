/**
 * 骑士在一张 n x n 的棋盘上巡视。在 有效 的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * <p>
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (
 * row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 * <p>
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * <p>
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,
 * 7,22]]
 * 输出：true
 * 解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
 * 输出：false
 * 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 7
 * 0 <= grid[row][col] < n * n
 * grid 中的所有整数 互不相同
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 模拟 👍 50 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class CheckKnightTourConfiguration {
    public static void main(String[] args) {
        // Solution solution = new CheckKnightTourConfiguration().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidGrid(int[][] grid) {
            if (grid[0][0] != 0) {
                return false;
            }

            int n = grid.length;
            Map<Integer, int[]> map = new HashMap<>(n * n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map.put(grid[i][j], new int[]{i, j});
                }
            }

            int[] last = new int[]{0, 0};
            int diff0, diff1;
            for (int i = 1; i < n * n; i++) {
                var p = map.get(i);
                diff0 = Math.abs(p[0] - last[0]);
                diff1 = Math.abs(p[1] - last[1]);
                if (!(diff0 == 2 && diff1 == 1 || diff0 == 1 && diff1 == 2)) {
                    return false;
                }
                last = p;
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}