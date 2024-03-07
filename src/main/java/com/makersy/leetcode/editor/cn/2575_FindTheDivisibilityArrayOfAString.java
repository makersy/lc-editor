/**
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * <p>
 * word 的 可整除数组 div 是一个长度为 n 的整数数组，并满足：
 * <p>
 * <p>
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[id] = 1 否则，div[i] = 0
 * <p>
 * <p>
 * 返回 word 的可整除数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word = "998244353", m = 3 输出：[1,1,0,0,0,1,1,0,0] 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word = "1010", m = 10 输出：[0,1,0,1] 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁵ word.length == n word 由数字 0 到 9 组成 1 <= m <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 数学 字符串 👍 49 👎 0
 */

package com.makersy.leetcode.editor.cn;

class FindTheDivisibilityArrayOfAString {

    public static void main(String[] args) {
        //Solution solution = new FindTheDivisibilityArrayOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] divisibilityArray(String word, int m) {
            long n = 0;
            int[] res = new int[word.length()];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                n = (n * 10 + (c - '0')) % m;
                res[i] = n == 0 ? 1 : 0;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}