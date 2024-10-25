/**
 * 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
 * <p>
 * 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
 * <p>
 * <p>
 * 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x +
 * rewardValues[i]），并 标记 下标 i。
 * <p>
 * <p>
 * 以整数形式返回执行最优操作能够获得的 最大 总奖励。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：rewardValues = [1,1,3,3]
 * <p>
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：rewardValues = [1,6,4,3,2]
 * <p>
 * <p>
 * 输出：11
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= rewardValues.length <= 2000 1 <= rewardValues[i] <= 2000
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 48 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MaximumTotalRewardUsingOperationsI {

    public static void main(String[] args) {
        //Solution solution = new MaximumTotalRewardUsingOperationsI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            int m = rewardValues[rewardValues.length - 1];
            int[] dp = new int[2 * m];
            dp[0] = 1;
            for (int x : rewardValues) {
                for (int k = 2 * x - 1; k >= x; k--) {
                    if (dp[k - x] == 1) {
                        dp[k] = 1;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 1) {
                    res = i;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}