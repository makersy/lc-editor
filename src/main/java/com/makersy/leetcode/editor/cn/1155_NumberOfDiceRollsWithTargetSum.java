/**
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n , k 和 target ，返回可能的方式(从总共 kⁿ 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 10⁹ + 7 取模 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有 6 个面的骰子。
 * 得到 3 的和只有一种方法。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有 6 个面。
 * 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 10⁹ + 7 取模。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 * <p>
 * <p>
 * Related Topics 动态规划 👍 236 👎 0
 */

package com.makersy.leetcode.editor.cn;

class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        // Solution solution = new NumberOfDiceRollsWithTargetSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRollsToTarget(int n, int k, int target) {
            final int mod = (int) 1e9 + 7;
            int[][] f = new int[n + 1][target + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= Math.min(target, i * k); ++j) {
                    for (int h = 1; h <= Math.min(j, k); ++h) {
                        f[i][j] = (f[i][j] + f[i - 1][j - h]) % mod;
                    }
                }
            }
            return f[n][target];
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}