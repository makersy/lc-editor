/**
 * 一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
 * <p>
 * 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 * <p>
 * 给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。同时给你一个正整数 k ，请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：piles = [[1,100,3],[7,8,9]], k = 2 输出：101 解释： 上图展示了几种选择 k 个硬币的不同方法。 我们可以得到的最大面值为 101 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7 输出：706 解释： 如果我们所有硬币都从最后一个栈中取，可以得到最大面值和。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == piles.length 1 <= n <= 1000 1 <= piles[i][j] <= 10⁵ 1 <= k <= sum(piles[i].length) <= 2000
 * <p>
 * <p>
 * Related Topics 数组 动态规划 前缀和 👍 133 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

class MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        //Solution solution = new MaximumValueOfKCoinsFromPiles().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            int[] f = new int[k + 1];
            Arrays.fill(f, -1);
            f[0] = 0;
            for (List<Integer> pile : piles) {
                for (int i = k; i > 0; --i) {
                    int value = 0;
                    for (int t = 1; t <= pile.size(); ++t) {
                        value += pile.get(t - 1);
                        if (i >= t && f[i - t] != -1) {
                            f[i] = Math.max(f[i], f[i - t] + value);
                        }
                    }
                }
            }
            return f[k];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}