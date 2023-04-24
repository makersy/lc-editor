/**
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "leetcode"
 * 输出："tcode"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 4 * 10⁵
 * s 仅含有小写英文字符。
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 154 👎 0
 */

package com.makersy.leetcode.editor.cn;

class LastSubstringInLexicographicalOrder {
    public static void main(String[] args) {
        //Solution solution = new LastSubstringInLexicographicalOrder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String lastSubstring(String s) {
            int i = 0, j = 1, n = s.length();
            while (j < n) {
                int k = 0;
                while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                    int t = i;
                    i = j;
                    j = Math.max(j + 1, t + k + 1);
                } else {
                    j = j + k + 1;
                }
            }
            return s.substring(i);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}