/**
 * 给你两个整数 m 和 n ，分别表示一块矩形木块的高和宽。同时给你一个二维整数数组 prices ，其中 prices[i] = [hi, wi, pricei] 表示你可以以 pricei 元的价格卖一块高为 hi 宽为 wi
 * 的矩形木块。
 * <p>
 * 每一次操作中，你必须按下述方式之一执行切割操作，以得到两块更小的矩形木块：
 * <p>
 * <p>
 * 沿垂直方向按高度 完全 切割木块，或 沿水平方向按宽度 完全 切割木块
 * <p>
 * <p>
 * 在将一块木块切成若干小木块后，你可以根据 prices 卖木块。你可以卖多块同样尺寸的木块。你不需要将所有小木块都卖出去。你 不能 旋转切好后木块的高和宽。
 * <p>
 * <p>
 * 请你返回切割一块大小为 m x n 的木块后，能得到的 最多 钱数。
 * <p>
 * 注意你可以切割木块任意次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：m = 3, n = 5, prices = [[1,4,2],[2,2,7],[2,1,3]] 输出：19 解释：上图展示了一个可行的方案。包括： - 2 块 2 x 2 的小木块，售出 2 * 7 = 14 元。 - 1 块
 * 2 x 1 的小木块，售出 1 * 3 = 3 元。 - 1 块 1 x 4 的小木块，售出 1 * 2 = 2 元。 总共售出 14 + 3 + 2 = 19 元。 19 元是最多能得到的钱数。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：m = 4, n = 6, prices = [[3,2,10],[1,4,2],[4,1,3]] 输出：32 解释：上图展示了一个可行的方案。包括： - 3 块 3 x 2 的小木块，售出 3 * 10 = 30 元。 - 1
 * 块 1 x 4 的小木块，售出 1 * 2 = 2 元。 总共售出 30 + 2 = 32 元。 32 元是最多能得到的钱数。 注意我们不能旋转 1 x 4 的木块来得到 4 x 1 的木块。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= m, n <= 200 1 <= prices.length <= 2 * 10⁴ prices[i].length == 3 1 <= hi <= m 1 <= wi <= n 1 <= pricei <= 10⁶ 所有
 * (hi, wi) 互不相同 。
 * <p>
 * <p>
 * Related Topics 记忆化搜索 数组 动态规划 👍 115 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SellingPiecesOfWood {

    public static void main(String[] args) {
        //Solution solution = new SellingPiecesOfWood().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long sellingWood(int m, int n, int[][] prices) {
            Map<Long, Integer> value = new HashMap<>();
            for (int[] price : prices) {
                value.put(pairHash(price[0], price[1]), price[2]);
            }

            long[][] memo = new long[m + 1][n + 1];
            for (long[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs(m, n, value, memo);
        }

        public long dfs(int x, int y, Map<Long, Integer> value, long[][] memo) {
            if (memo[x][y] != -1) {
                return memo[x][y];
            }

            long key = pairHash(x, y);
            long ret = value.containsKey(key) ? value.get(key) : 0;
            if (x > 1) {
                for (int i = 1; i < x; i++) {
                    ret = Math.max(ret, dfs(i, y, value, memo) + dfs(x - i, y, value, memo));
                }
            }
            if (y > 1) {
                for (int j = 1; j < y; j++) {
                    ret = Math.max(ret, dfs(x, j, value, memo) + dfs(x, y - j, value, memo));
                }
            }
            memo[x][y] = ret;
            return ret;
        }

        public long pairHash(int x, int y) {
            return (long) x << 16 ^ y;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}