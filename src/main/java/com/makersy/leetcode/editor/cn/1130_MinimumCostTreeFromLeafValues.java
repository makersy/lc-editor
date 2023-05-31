/**
 * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 * <p>
 * <p>
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * <p>
 * <p>
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 * <p>
 * 如果一个节点有 0 个子节点，那么该节点为叶节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [4,11]
 * 输出：44
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * 答案保证是一个 32 位带符号整数，即小于 2³¹ 。
 * <p>
 * <p>
 * Related Topics 栈 贪心 数组 动态规划 单调栈 👍 357 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MinimumCostTreeFromLeafValues {
    public static void main(String[] args) {
        //Solution solution = new MinimumCostTreeFromLeafValues().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
            }
            int[][] mval = new int[n][n];
            for (int j = 0; j < n; j++) {
                mval[j][j] = arr[j];
                dp[j][j] = 0;
                for (int i = j - 1; i >= 0; i--) {
                    mval[i][j] = Math.max(arr[i], mval[i + 1][j]);
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mval[i][k] * mval[k + 1][j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}