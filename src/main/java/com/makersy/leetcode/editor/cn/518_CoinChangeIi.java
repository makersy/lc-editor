/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5] 输出：4 解释：有四种方式可以凑成总金额： 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：amount = 3, coins = [2] 输出：0 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：amount = 10, coins = [10] 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= coins.length <= 300 1 <= coins[i] <= 5000 coins 中的所有值 互不相同 0 <= amount <= 5000
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 1269 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CoinChangeIi {

    public static void main(String[] args) {
        //Solution solution = new CoinChangeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}