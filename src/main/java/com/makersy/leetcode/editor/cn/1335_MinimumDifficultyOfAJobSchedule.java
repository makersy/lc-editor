/**
 * 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
 * <p>
 * 你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
 * <p>
 * 给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
 * <p>
 * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：jobDifficulty = [6,5,4,3,2,1], d = 2
 * 输出：7
 * 解释：第一天，您可以完成前 5 项工作，总难度 = 6.
 * 第二天，您可以完成最后一项工作，总难度 = 1.
 * 计划表的难度 = 6 + 1 = 7
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：jobDifficulty = [9,9,9], d = 4
 * 输出：-1
 * 解释：就算你每天完成一项工作，仍然有一天是空闲的，你无法制定一份能够满足既定工作时间的计划表。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：jobDifficulty = [1,1,1], d = 3
 * 输出：3
 * 解释：工作计划为每天一项工作，总难度为 3 。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：jobDifficulty = [7,1,7,1,7,1], d = 3
 * 输出：15
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * 输出：843
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 164 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MinimumDifficultyOfAJobSchedule {
    public static void main(String[] args) {
        //Solution solution = new MinimumDifficultyOfAJobSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDifficulty(int[] jobDifficulty, int d) {
            int n = jobDifficulty.length;
            if (n < d) {
                return -1;
            }
            int[] dp = new int[n];
            for (int i = 0, j = 0; i < n; ++i) {
                j = Math.max(j, jobDifficulty[i]);
                dp[i] = j;
            }
            for (int i = 1; i < d; ++i) {
                int[] ndp = new int[n];
                Arrays.fill(ndp, 0x3f3f3f3f);
                for (int j = i; j < n; ++j) {
                    int ma = 0;
                    for (int k = j; k >= i; --k) {
                        ma = Math.max(ma, jobDifficulty[k]);
                        ndp[j] = Math.min(ndp[j], ma + dp[k - 1]);
                    }
                }
                dp = ndp;
            }
            return dp[n - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}