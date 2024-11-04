/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：c = 5 输出：true 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：c = 3 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= c <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 数学 双指针 二分查找 👍 486 👎 0
 */

package com.makersy.leetcode.editor.cn;

class SumOfSquareNumbers {

    public static void main(String[] args) {
        //Solution solution = new SumOfSquareNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean judgeSquareSum(int c) {
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a * a);
                if (b == (int) b) {
                    return true;
                }
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}