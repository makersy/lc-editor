/**
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * <p>
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= a, b <= 1000
 * <p>
 * <p>
 * Related Topics 数学 枚举 数论 👍 47 👎 0
 */

package com.makersy.leetcode.editor.cn;

class NumberOfCommonFactors {
    public static void main(String[] args) {
        //Solution solution = new NumberOfCommonFactors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            int res = 0;
            for (int min = Math.min(a, b), i = 1; i <= min; i++) {
                if (a % i == 0 && b % i == 0) res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}