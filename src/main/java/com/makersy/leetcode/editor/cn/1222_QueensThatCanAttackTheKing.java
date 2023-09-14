/**
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * <p>
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[
 * 5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,
 * 5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子。
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 108 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class QueensThatCanAttackTheKing {
    public static void main(String[] args) {
        // Solution solution = new QueensThatCanAttackTheKing().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            Set<Integer> queenPos = new HashSet<Integer>();
            for (int[] queen : queens) {
                int x = queen[0], y = queen[1];
                queenPos.add(x * 8 + y);
            }

            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    int kx = king[0] + dx, ky = king[1] + dy;
                    while (kx >= 0 && kx < 8 && ky >= 0 && ky < 8) {
                        int pos = kx * 8 + ky;
                        if (queenPos.contains(pos)) {
                            List<Integer> posList = new ArrayList<Integer>();
                            posList.add(kx);
                            posList.add(ky);
                            ans.add(posList);
                            break;
                        }
                        kx += dx;
                        ky += dy;
                    }
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}