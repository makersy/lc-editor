/**
 * 给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
 * <p>
 * <p>
 * 你挑选 任意 一块披萨。
 * Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
 * Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
 * 重复上述过程直到没有披萨剩下。
 * <p>
 * <p>
 * 每一块披萨的大小按顺时针方向由循环数组 slices 表示。
 * <p>
 * 请你返回你可以获得的披萨大小总和的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：slices = [1,2,3,4,5,6]
 * 输出：10
 * 解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小为
 * 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：slices = [8,9,8,6,1,1]
 * 输出：16
 * 解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= slices.length <= 500
 * slices.length % 3 == 0
 * 1 <= slices[i] <= 1000
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 堆（优先队列） 👍 208 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class PizzaWith3nSlices {
    public static void main(String[] args) {
        //Solution solution = new PizzaWith3nSlices().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSizeSlices(int[] slices) {
            int[] v1 = new int[slices.length - 1];
            int[] v2 = new int[slices.length - 1];
            System.arraycopy(slices, 1, v1, 0, slices.length - 1);
            System.arraycopy(slices, 0, v2, 0, slices.length - 1);
            int ans1 = calculate(v1);
            int ans2 = calculate(v2);
            return Math.max(ans1, ans2);
        }

        public int calculate(int[] slices) {
            int N = slices.length, n = (N + 1) / 3;
            int[][] dp = new int[N][n + 1];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            }
            dp[0][0] = 0;
            dp[0][1] = slices[0];
            dp[1][0] = 0;
            dp[1][1] = Math.max(slices[0], slices[1]);
            for (int i = 2; i < N; i++) {
                dp[i][0] = 0;
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i]);
                }
            }
            return dp[N - 1][n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}