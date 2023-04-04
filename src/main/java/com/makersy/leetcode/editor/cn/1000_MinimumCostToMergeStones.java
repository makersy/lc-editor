/**
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * <p>
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * <p>
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [3,2,4,1], K = 2
 * 输出：20
 * 解释：
 * 从 [3, 2, 4, 1] 开始。
 * 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
 * 合并 [4, 1]，成本为 5，剩下 [5, 5]。
 * 合并 [5, 5]，成本为 10，剩下 [10]。
 * 总成本 20，这是可能的最小值。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：stones = [3,2,4,1], K = 3
 * 输出：-1
 * 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：stones = [3,5,1,2,6], K = 3
 * 输出：25
 * 解释：
 * 从 [3, 5, 1, 2, 6] 开始。
 * 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
 * 合并 [3, 8, 6]，成本为 17，剩下 [17]。
 * 总成本 25，这是可能的最小值。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 306 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MinimumCostToMergeStones {
    public static void main(String[] args) {
        //Solution solution = new MinimumCostToMergeStones().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int INF = 0x3f3f3f3f;
        int[][][] d;
        int[] sum;
        int k;

        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if ((n - 1) % (k - 1) != 0) {
                return -1;
            }
            this.k = k;
            d = new int[n][n][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(d[i][j], -1);
                }
            }
            sum = new int[n];

            // 初始化
            for (int i = 0, s = 0; i < n; i++) {
                d[i][i][1] = 0;
                s += stones[i];
                sum[i] = s;
            }
            int res = get(0, n - 1, 1);
            return res;
        }

        public int get(int l, int r, int t) {
            // 若 d[l][r][t] 不为 -1，表示已经在之前的递归被求解过，直接返回答案
            if (d[l][r][t] != -1) {
                return d[l][r][t];
            }
            // 当石头堆数小于 t 时，一定无解
            if (t > r - l + 1) {
                return INF;
            }
            if (t == 1) {
                int res = get(l, r, k);
                if (res == INF) {
                    return d[l][r][t] = INF;
                }
                return d[l][r][t] = res + (sum[r] - (l == 0 ? 0 : sum[l - 1]));
            }
            int val = INF;
            for (int p = l; p < r; p += (k - 1)) {
                val = Math.min(val, get(l, p, 1) + get(p + 1, r, t - 1));
            }
            return d[l][r][t] = val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}