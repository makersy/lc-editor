/**
 * 我们称一个数字字符串是 好数字 当它满足（下标从 0 开始）偶数 下标处的数字为 偶数 且 奇数 下标处的数字为 质数 （2，3，5 或 7）。
 * <p>
 * <p>
 * 比方说，"2582" 是好数字，因为偶数下标处的数字（2 和 8）是偶数且奇数下标处的数字（5 和 2）为质数。但 "3245" 不是 好数字，因为 3 在偶 数下标处但不是偶数。
 * <p>
 * <p>
 * 给你一个整数 n ，请你返回长度为 n 且为好数字的数字字符串 总数 。由于答案可能会很大，请你将它对 10⁹ + 7 取余后返回 。
 * <p>
 * 一个 数字字符串 是每一位都由 0 到 9 组成的字符串，且可能包含前导 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 1 输出：5 解释：长度为 1 的好数字包括 "0"，"2"，"4"，"6"，"8" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 4 输出：400
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 50 输出：564908303
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10¹⁵
 * <p>
 * <p>
 * Related Topics 递归 数学 👍 55 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountGoodNumbers {

    public static void main(String[] args) {
        //Solution solution = new CountGoodNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        long mod = 1000000007;

        public int countGoodNumbers(long n) {
            return (int) (quickmul(5, (n + 1) / 2) * quickmul(4, n / 2) % mod);
        }

        // 快速幂求出 x^y % mod
        public long quickmul(int x, long y) {
            long ret = 1;
            long mul = x;
            while (y > 0) {
                if (y % 2 == 1) {
                    ret = ret * mul % mod;
                }
                mul = mul * mul % mod;
                y /= 2;
            }

            return ret;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}