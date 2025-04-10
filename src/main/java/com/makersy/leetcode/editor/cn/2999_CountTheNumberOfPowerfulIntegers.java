/**
 * 给你三个整数 start ，finish 和 limit 。同时给你一个下标从 0 开始的字符串 s ，表示一个 正 整数。
 * <p>
 * 如果一个 正 整数 x 末尾部分是 s （换句话说，s 是 x 的 后缀），且 x 中的每个数位至多是 limit ，那么我们称 x 是 强大的 。
 * <p>
 * 请你返回区间 [start..finish] 内强大整数的 总数目 。
 * <p>
 * 如果一个字符串 x 是 y 中某个下标开始（包括 0 ），到下标为 y.length - 1 结束的子字符串，那么我们称 x 是 y 的一个后缀。比方说，25 是 5125 的一个后缀，但不是 512 的后缀。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：start = 1, finish = 6000, limit = 4, s = "124" 输出：5 解释：区间 [1..6000] 内的强大数字为 124 ，1124 ，2124 ，3124 和 4124
 * 。这些整数的各个数位都 <= 4 且 "124" 是它 们的后缀。注意 5124 不是强大整数，因为第一个数位 5 大于 4 。 这个区间内总共只有这 5 个强大整数。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：start = 15, finish = 215, limit = 6, s = "10" 输出：2 解释：区间 [15..215] 内的强大整数为 110 和 210 。这些整数的各个数位都 <= 6 且 "10"
 * 是它们的后缀。 这个区间总共只有这 2 个强大整数。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：start = 1000, finish = 2000, limit = 4, s = "3000" 输出：0 解释：区间 [1000..2000] 内的整数都小于 3000 ，所以 "3000"
 * 不可能是这个区间内任何整数的后缀。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= start <= finish <= 10¹⁵ 1 <= limit <= 9 1 <= s.length <= floor(log10(finish)) + 1 s 数位中每个数字都小于等于 limit 。 s
 * 不包含任何前导 0 。
 * <p>
 * <p>
 * Related Topics 数学 字符串 动态规划 👍 58 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class CountTheNumberOfPowerfulIntegers {

    public static void main(String[] args) {
        //Solution solution = new CountTheNumberOfPowerfulIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
            String low = Long.toString(start);
            String high = Long.toString(finish);
            int n = high.length();
            low = String.format("%" + n + "s", low).replace(' ', '0'); // 对齐位数
            int pre_len = n - s.length(); // 前缀长度
            long[] memo = new long[n];
            Arrays.fill(memo, -1);

            return dfs(0, true, true, low, high, limit, s, pre_len, memo);
        }

        private long dfs(int i, boolean limit_low, boolean limit_high, String low, String high, int limit, String s,
                int pre_len, long[] memo) {
            // 递归边界
            if (i == low.length()) {
                return 1;
            }
            if (!limit_low && !limit_high && memo[i] != -1) {
                return memo[i];
            }

            int lo = limit_low ? low.charAt(i) - '0' : 0;
            int hi = limit_high ? high.charAt(i) - '0' : 9;
            long res = 0;
            if (i < pre_len) {
                for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                    res += dfs(i + 1, limit_low && digit == lo, limit_high && digit == hi, low, high, limit, s, pre_len,
                            memo);
                }
            } else {
                int x = s.charAt(i - pre_len) - '0';
                if (lo <= x && x <= Math.min(hi, limit)) {
                    res = dfs(i + 1, limit_low && x == lo, limit_high && x == hi, low, high, limit, s, pre_len, memo);
                }
            }
            if (!limit_low && !limit_high) {
                memo[i] = res;
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}