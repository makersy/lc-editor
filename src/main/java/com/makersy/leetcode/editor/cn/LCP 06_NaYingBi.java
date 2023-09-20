/**
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[4,2,1]
 * <p>
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：[2,3,10]
 * <p>
 * <p>
 * 输出：8
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 108 👎 0
 */

package com.makersy.leetcode.editor.cn;

class NaYingBi {
    public static void main(String[] args) {
        // Solution solution = new NaYingBi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCount(int[] coins) {
            int res = 0;
            for (int n : coins) {
                if(n <= 2) res++;
                else res += (n + 1) / 2;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}