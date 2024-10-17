/**
 * 给你一个整数 n 和一个二维数组 requirements ，其中 requirements[i] = [endi, cnti] 表示这个要求中的末尾下标和 逆 序对 的数目。
 * <p>
 * 整数数组 nums 中一个下标对 (i, j) 如果满足以下条件，那么它们被称为一个 逆序对 ：
 * <p>
 * <p>
 * i < j 且 nums[i] > nums[j]
 * <p>
 * <p>
 * 请你返回 [0, 1, 2, ..., n - 1] 的 排列 perm 的数目，满足对 所有 的 requirements[i] 都有 perm[0.. endi] 恰好有 cnti 个逆序对。
 * <p>
 * 由于答案可能会很大，将它对 10⁹ + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, requirements = [[2,2],[0,0]]
 * <p>
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 两个排列为：
 * <p>
 * <p>
 * [2, 0, 1]
 * <p>
 * <p>
 * <p>
 * 前缀 [2, 0, 1] 的逆序对为 (0, 1) 和 (0, 2) 。 前缀 [2] 的逆序对数目为 0 个。
 * <p>
 * <p>
 * [1, 2, 0]
 * <p>
 * 前缀 [1, 2, 0] 的逆序对为 (0, 2) 和 (1, 2) 。 前缀 [1] 的逆序对数目为 0 个。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3, requirements = [[2,2],[1,1],[0,0]]
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一满足要求的排列是 [2, 0, 1] ：
 * <p>
 * <p>
 * 前缀 [2, 0, 1] 的逆序对为 (0, 1) 和 (0, 2) 。 前缀 [2, 0] 的逆序对为 (0, 1) 。 前缀 [2] 的逆序对数目为 0 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 2, requirements = [[0,0],[1,0]]
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一满足要求的排列为 [0, 1] ：
 * <p>
 * <p>
 * 前缀 [0] 的逆序对数目为 0 。 前缀 [0, 1] 的逆序对为 (0, 1) 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 300 1 <= requirements.length <= n requirements[i] = [endi, cnti] 0 <= endi <= n - 1 0 <= cnti <= 400
 * 输入保证至少有一个 i 满足 endi == n - 1 。 输入保证所有的 endi 互不相同。
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 36 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CountTheNumberOfInversions {

    public static void main(String[] args) {
        //Solution solution = new CountTheNumberOfInversions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        static final int MOD = 1000000007;

        Map<Integer, Integer> reqMap = new HashMap<Integer, Integer>();

        int[][] dp;

        public int numberOfPermutations(int n, int[][] requirements) {
            int maxCnt = 0;
            reqMap.put(0, 0);
            for (int[] req : requirements) {
                reqMap.put(req[0], req[1]);
                maxCnt = Math.max(maxCnt, req[1]);
            }
            if (reqMap.get(0) != 0) {
                return 0;
            }

            dp = new int[n][maxCnt + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            return dfs(n - 1, reqMap.get(n - 1));
        }

        public int dfs(int end, int cnt) {
            if (end == 0) {
                return 1;
            }
            if (dp[end][cnt] != -1) {
                return dp[end][cnt];
            }
            if (reqMap.containsKey(end - 1)) {
                int r = reqMap.get(end - 1);
                if (r <= cnt && cnt <= end + r) {
                    return dp[end][cnt] = dfs(end - 1, r);
                } else {
                    return dp[end][cnt] = 0;
                }
            } else {
                int sm = 0;
                for (int i = 0; i <= Math.min(end, cnt); ++i) {
                    sm = (sm + dfs(end - 1, cnt - i)) % MOD;
                }
                return dp[end][cnt] = sm;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}