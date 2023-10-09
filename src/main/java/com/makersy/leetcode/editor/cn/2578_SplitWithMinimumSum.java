/**
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * <p>
 * <p>
 * <p>
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * <p>
 * <p>
 * num1 和 num2 可以包含前导 0 。
 * <p>
 * <p>
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 * 注意：
 * <p>
 * <p>
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 10 <= num <= 10⁹
 * <p>
 * <p>
 * Related Topics 贪心 数学 排序 👍 58 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class SplitWithMinimumSum {
    public static void main(String[] args) {
        // Solution solution = new SplitWithMinimumSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitNum(int num) {
            char[] arr = String.valueOf(num).toCharArray();
            Arrays.sort(arr);
            int a = 0, b = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((i & 1) == 0) {
                    a = a * 10 + (arr[i] - '0');
                } else {
                    b = b * 10 + (arr[i] - '0');
                }
            }
            return a + b;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}