/**
 * 有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
 * <p>
 * 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
 * <p>
 * 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
 * <p>
 * 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, rollMax = [1,1,2,2,2,3]
 * 输出：34
 * 解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所以不
 * 会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, rollMax = [1,1,1,1,1,1]
 * 输出：30
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 3, rollMax = [1,1,1,2,2,3]
 * 输出：181
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 5000
 * rollMax.length == 6
 * 1 <= rollMax[i] <= 15
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 154 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class DiceRollSimulation {
    public static void main(String[] args) {
        //Solution solution = new DiceRollSimulation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (long) 1e9 + 7;

        public int dieSimulator(int n, int[] rollMax) {
            int m = rollMax.length; // 6
            var f = new int[n][m][15];
            for (int j = 0; j < m; ++j)
                Arrays.fill(f[0][j], 1);
            for (int i = 1; i < n; ++i)
                for (int last = 0; last < m; ++last)
                    for (int left = 0; left < rollMax[last]; ++left) {
                        long res = 0;
                        for (int j = 0; j < m; ++j)
                            if (j != last) res += f[i - 1][j][rollMax[j] - 1];
                            else if (left > 0) res += f[i - 1][j][left - 1];
                        f[i][last][left] = (int) (res % MOD);
                    }
            long ans = 0;
            for (int j = 0; j < m; ++j)
                ans += f[n - 1][j][rollMax[j] - 1];
            return (int) (ans % MOD);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}