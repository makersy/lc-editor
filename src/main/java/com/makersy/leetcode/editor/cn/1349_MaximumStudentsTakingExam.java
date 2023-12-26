/**
 * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 * <p>
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的同时参加考试且无
 * 法作弊的 最大 学生人数。
 * <p>
 * 学生必须坐在状况良好的座位上。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：seats = [["#",".","#","#",".","#"],
 *               [".","#","#","#","#","."],
 *               ["#",".","#","#",".","#"]]
 * 输出：4
 * 解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：seats = [[".","#"],
 *               ["#","#"],
 *               ["#","."],
 *               ["#","#"],
 *               [".","#"]]
 * 输出：3
 * 解释：让所有学生坐在可用的座位上。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：seats = [["#",".",".",".","#"],
 *               [".","#",".","#","."],
 *               [".",".","#",".","."],
 *               [".","#",".","#","."],
 *               ["#",".",".",".","#"]]
 * 输出：10
 * 解释：让学生坐在第 1、3 和 5 列的可用座位上。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * seats 只包含字符 '.' 和'#'
 * m == seats.length
 * n == seats[i].length
 * 1 <= m <= 8
 * 1 <= n <= 8
 * <p>
 * <p>
 * Related Topics 位运算 数组 动态规划 状态压缩 矩阵 👍 225 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class MaximumStudentsTakingExam {
    public static void main(String[] args) {
        //Solution solution = new MaximumStudentsTakingExam().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

        public int maxStudents(char[][] seats) {
            int m = seats.length, n = seats[0].length;
            int mx = 0;
            for (int i = 0; i < 1 << n; i++) {
                mx = Math.max(mx, dp(seats, m - 1, i));
            }
            return mx;
        }

        public int dp(char[][] seats, int row, int status) {
            int n = seats[0].length;
            int key = (row << n) + status;
            if (!memo.containsKey(key)) {
                if (!isSingleRowCompliant(seats, status, n, row)) {
                    memo.put(key, Integer.MIN_VALUE);
                    return Integer.MIN_VALUE;
                }
                int students = Integer.bitCount(status);
                if (row == 0) {
                    memo.put(key, students);
                    return students;
                }
                int mx = 0;
                for (int upperRowStatus = 0; upperRowStatus < 1 << n; upperRowStatus++) {
                    if (isCrossRowsCompliant(status, upperRowStatus, n)) {
                        mx = Math.max(mx, dp(seats, row - 1, upperRowStatus));
                    }
                }
                memo.put(key, students + mx);
            }
            return memo.get(key);
        }

        public boolean isSingleRowCompliant(char[][] seats, int status, int n, int row) {
            for (int j = 0; j < n; j++) {
                if (((status >> j) & 1) == 1) {
                    if (seats[row][j] == '#') {
                        return false;
                    }
                    if (j > 0 && ((status >> (j - 1)) & 1) == 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isCrossRowsCompliant(int status, int upperRowStatus, int n) {
            for (int j = 0; j < n; j++) {
                if (((status >> j) & 1) == 1) {
                    if (j > 0 && ((upperRowStatus >> (j - 1)) & 1) == 1) {
                        return false;
                    }
                    if (j < n - 1 && ((upperRowStatus >> (j + 1)) & 1) == 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}