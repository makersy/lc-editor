/**
 * 给你两个 正 整数 n 和 k 。
 * <p>
 * 如果一个整数 x 满足以下条件，那么它被称为 k 回文 整数 。
 * <p>
 * <p>
 * x 是一个 回文整数 。 x 能被 k 整除。
 * <p>
 * <p>
 * 如果一个整数的数位重新排列后能得到一个 k 回文整数 ，那么我们称这个整数为 好 整数。比方说，k = 2 ，那么 2020 可以重新排列得到 2002 ，2 002 是一个 k 回文串，所以 2020 是一个好整数。而 1010
 * 无法重新排列数位得到一个 k 回文整数。
 * <p>
 * 请你返回 n 个数位的整数中，有多少个 好 整数。
 * <p>
 * 注意 ，任何整数在重新排列数位之前或者之后 都不能 有前导 0 。比方说 1010 不能重排列得到 101 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, k = 5
 * <p>
 * <p>
 * 输出：27
 * <p>
 * 解释：
 * <p>
 * 部分好整数如下：
 * <p>
 * <p>
 * 551 ，因为它可以重排列得到 515 。 525 ，因为它已经是一个 k 回文整数。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1, k = 4
 * <p>
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 两个好整数分别是 4 和 8 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 5, k = 6
 * <p>
 * <p>
 * 输出：2468
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10 1 <= k <= 9
 * <p>
 * <p>
 * Related Topics 哈希表 数学 组合数学 枚举 👍 18 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindTheCountOfGoodIntegers {

    public static void main(String[] args) {
        //Solution solution = new FindTheCountOfGoodIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countGoodIntegers(int n, int k) {
            Set<String> dict = new HashSet<>();
            int base = (int) Math.pow(10, (n - 1) / 2);
            int skip = n & 1;
            /* 枚举 n 个数位的回文数 */
            for (int i = base; i < base * 10; i++) {
                String s = Integer.toString(i);
                s += new StringBuilder(s).reverse().substring(skip);
                long palindromicInteger = Long.parseLong(s);
                /* 如果当前回文数是 k 回文数 */
                if (palindromicInteger % k == 0) {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    dict.add(new String(chars));
                }
            }

            long[] factorial = new long[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
            long ans = 0;
            for (String s : dict) {
                int[] cnt = new int[10];
                for (char c : s.toCharArray()) {
                    cnt[c - '0']++;
                }
                /* 计算排列组合 */
                long tot = (n - cnt[0]) * factorial[n - 1];
                for (int x : cnt) {
                    tot /= factorial[x];
                }
                ans += tot;
            }

            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}