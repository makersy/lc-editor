/**
 * 给你四个整数 m、n、introvertsCount 和 extrovertsCount 。有一个 m x n 网格，和两种类型的人：内向的人和外向的人。总共有
 * introvertsCount 个内向的人和 extrovertsCount 个外向的人。
 * <p>
 * 请你决定网格中应当居住多少人，并为每个人分配一个网格单元。 注意，不必 让所有人都生活在网格中。
 * <p>
 * 每个人的 幸福感 计算如下：
 * <p>
 * <p>
 * 内向的人 开始 时有 120 个幸福感，但每存在一个邻居（内向的或外向的）他都会 失去 30 个幸福感。
 * 外向的人 开始 时有 40 个幸福感，每存在一个邻居（内向的或外向的）他都会 得到 20 个幸福感。
 * <p>
 * <p>
 * 邻居是指居住在一个人所在单元的上、下、左、右四个直接相邻的单元中的其他人。
 * <p>
 * 网格幸福感 是每个人幸福感的 总和 。 返回 最大可能的网格幸福感 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 2, n = 3, introvertsCount = 1, extrovertsCount = 2
 * 输出：240
 * 解释：假设网格坐标 (row, column) 从 1 开始编号。
 * 将内向的人放置在单元 (1,1) ，将外向的人放置在单元 (1,3) 和 (2,3) 。
 * - 位于 (1,1) 的内向的人的幸福感：120（初始幸福感）- (0 * 30)（0 位邻居）= 120
 * - 位于 (1,3) 的外向的人的幸福感：40（初始幸福感）+ (1 * 20)（1 位邻居）= 60
 * - 位于 (2,3) 的外向的人的幸福感：40（初始幸福感）+ (1 * 20)（1 位邻居）= 60
 * 网格幸福感为：120 + 60 + 60 = 240
 * 上图展示该示例对应网格中每个人的幸福感。内向的人在浅绿色单元中，而外向的人在浅紫色单元中。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 3, n = 1, introvertsCount = 2, extrovertsCount = 1
 * 输出：260
 * 解释：将内向的人放置在单元 (1,1) 和 (3,1) ，将外向的人放置在单元 (2,1) 。
 * - 位于 (1,1) 的内向的人的幸福感：120（初始幸福感）- (1 * 30)（1 位邻居）= 90
 * - 位于 (2,1) 的外向的人的幸福感：40（初始幸福感）+ (2 * 20)（2 位邻居）= 80
 * - 位于 (3,1) 的内向的人的幸福感：120（初始幸福感）- (1 * 30)（1 位邻居）= 90
 * 网格幸福感为 90 + 80 + 90 = 260
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：m = 2, n = 2, introvertsCount = 4, extrovertsCount = 0
 * 输出：240
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= m, n <= 5
 * 0 <= introvertsCount, extrovertsCount <= min(m * n, 6)
 * <p>
 * <p>
 * Related Topics 位运算 记忆化搜索 动态规划 状态压缩 👍 103 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MaximizeGridHappiness {
    public static void main(String[] args) {
        //Solution solution = new MaximizeGridHappiness().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int T = 243, N = 5, M = 6;
        int n, m, tot;
        int[][] maskBits;
        int[] ivCount;
        int[] evCount;
        int[] innerScore;
        int[][] interScore;
        int[][][][] d;
        // 邻居间的分数
        static int[][] score = {
                {0, 0, 0},
                {0, -60, -10},
                {0, -10, 40}
        };

        public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
            this.n = n;
            this.m = m;
            // 状态总数为 3^n
            this.tot = (int) Math.pow(3, n);
            this.maskBits = new int[T][N];
            this.ivCount = new int[T];
            this.evCount = new int[T];
            this.innerScore = new int[T];
            this.interScore = new int[T][T];
            this.d = new int[N][T][M + 1][M + 1];

            initData();
            // 记忆化搜索数组，初始化为 -1，表示未赋值
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    for (int k = 0; k <= M; k++) {
                        Arrays.fill(d[i][j][k], -1);
                    }
                }
            }
            return dfs(0, 0, introvertsCount, extrovertsCount);
        }

        public void initData() {
            // 计算行内分数
            for (int mask = 0; mask < tot; mask++) {
                int maskTmp = mask;
                for (int i = 0; i < n; i++) {
                    int x = maskTmp % 3;
                    maskBits[mask][i] = x;
                    maskTmp /= 3;
                    if (x == 1) {
                        ivCount[mask]++;
                        innerScore[mask] += 120;
                    } else if (x == 2) {
                        evCount[mask]++;
                        innerScore[mask] += 40;
                    }
                    if (i > 0) {
                        innerScore[mask] += score[x][maskBits[mask][i - 1]];
                    }
                }
            }
            // 计算行间分数
            for (int i = 0; i < tot; i++) {
                for (int j = 0; j < tot; j++) {
                    interScore[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        interScore[i][j] += score[maskBits[i][k]][maskBits[j][k]];
                    }
                }
            }
        }

        public int dfs(int row, int premask, int iv, int ev) {
            if (row == m || (iv == 0 && ev == 0)) {
                return 0;
            }
            // 如果该状态已经计算过答案，则直接返回
            if (d[row][premask][iv][ev] != -1) {
                return d[row][premask][iv][ev];
            }
            // 合法状态，初始值为 0
            int res = 0;
            for (int mask = 0; mask < tot; mask++) {
                // mask 包含的内向人数不能超过 iv ，外向人数不能超过 ev
                if (ivCount[mask] > iv || evCount[mask] > ev) {
                    continue;
                }
                res = Math.max(res, dfs(row + 1, mask, iv - ivCount[mask], ev - evCount[mask])
                        + innerScore[mask]
                        + interScore[premask][mask]);
            }
            d[row][premask][iv][ev] = res;
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}