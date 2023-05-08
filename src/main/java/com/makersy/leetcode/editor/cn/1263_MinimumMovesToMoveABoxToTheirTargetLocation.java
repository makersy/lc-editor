/**
 * 「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
 * <p>
 * 游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
 * <p>
 * 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
 * <p>
 * <p>
 * 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
 * 地板用字符 '.' 表示，意味着可以自由行走。
 * 墙用字符 '#' 表示，意味着障碍物，不能通行。
 * 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
 * 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
 * 玩家无法越过箱子。
 * <p>
 * <p>
 * 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 *              ["#",".",".","B",".","#"],
 *              ["#",".","#","#",".","#"],
 *              ["#",".",".",".","S","#"],
 *              ["#","#","#","#","#","#"]]
 * 输出：3
 * 解释：我们只需要返回推箱子的次数。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 *              ["#",".",".","B",".","#"],
 *              ["#","#","#","#",".","#"],
 *              ["#",".",".",".","S","#"],
 *              ["#","#","#","#","#","#"]]
 * 输出：-1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 *              ["#","T",".",".","#","#"],
 *              ["#",".","#","B",".","#"],
 *              ["#",".",".",".",".","#"],
 *              ["#",".",".",".","S","#"],
 *              ["#","#","#","#","#","#"]]
 * 输出：5
 * 解释：向下、向左、向左、向上再向上。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * grid 仅包含字符 '.', '#', 'S' , 'T', 以及 'B'。
 * grid 中 'S', 'B' 和 'T' 各只能出现一个。
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 181 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

class MinimumMovesToMoveABoxToTheirTargetLocation {
    public static void main(String[] args) {
        //Solution solution = new MinimumMovesToMoveABoxToTheirTargetLocation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPushBox(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int px = 0, py = 0, bx = 0, by = 0, tx = 0, ty = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'S') {
                        px = i;
                        py = j;
                    } else if (grid[i][j] == 'B') {
                        bx = i;
                        by = j;
                    } else if (grid[i][j] == 'T') {
                        tx = i;
                        ty = j;
                    }
                }
            }
            Deque<Node> queue = new LinkedList<>();
            boolean[][][][] visited = new boolean[m][n][m][n];
            visited[px][py][bx][by] = true;
            queue.offer(new Node(px, py, bx, by, 0));
            while (!queue.isEmpty()) {
                Node cur = queue.pollFirst();
                if (cur.bx == tx && cur.by == ty) {
                    return cur.step;
                }
                for (int[] dir : dirs) {
                    int newPx = cur.px + dir[0], newPy = cur.py + dir[1], newBx = cur.bx, newBy = cur.by, newStep =
                            cur.step;
                    if (newPx == cur.bx && newPy == cur.by) {
                        newBx += dir[0];
                        newBy += dir[1];
                        newStep++;
                    }
                    if (newPx < 0 || newPx == m || newPy < 0 || newPy == n || newBx < 0 || newBx == m || newBy < 0
                            || newBy == n || grid[newPx][newPy] == '#' || grid[newBx][newBy] == '#'
                            || visited[newPx][newPy][newBx][newBy]) {
                        continue;
                    }
                    Node newNode = new Node(newPx, newPy, newBx, newBy, newStep);
                    boolean dummy = newStep == cur.step ? queue.offerFirst(newNode) : queue.offerLast(newNode);
                    visited[newPx][newPy][newBx][newBy] = true;
                }
            }

            return -1;
        }

        class Node {
            int px;
            int py;
            int bx;
            int by;
            int step;

            public Node(int px, int py, int bx, int by, int step) {
                this.px = px;
                this.py = py;
                this.bx = bx;
                this.by = by;
                this.step = step;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}