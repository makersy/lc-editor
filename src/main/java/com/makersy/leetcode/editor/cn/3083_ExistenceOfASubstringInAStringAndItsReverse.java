/**
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 * <p>
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "leetcode"
 * <p>
 * <p>
 * 输出：true
 * <p>
 * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "abcba"
 * <p>
 * <p>
 * 输出：true
 * <p>
 * 解释：所有长度为 2 的子字符串 "ab"、"bc"、"cb"、"ba" 也都出现在 reverse(s) == "abcba" 中。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "abcd"
 * <p>
 * <p>
 * 输出：false
 * <p>
 * 解释：字符串 s 中不存在满足「在其反转后的字符串中也出现」且长度为 2 的子字符串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 100 字符串 s 仅由小写英文字母组成。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 23 👎 0
 */

package com.makersy.leetcode.editor.cn;

class ExistenceOfASubstringInAStringAndItsReverse {

    public static void main(String[] args) {
        //Solution solution = new ExistenceOfASubstringInAStringAndItsReverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isSubstringPresent(String s) {
            int len = s.length();
            if (len < 2) {
                return false;
            }
            boolean[][] flag = new boolean[26][26];
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    return true;
                }
                flag[s.charAt(i) - 'a'][s.charAt(i + 1) - 'a'] = true;
            }
            for (int i = len - 1; i >= 1; i--) {
                if (flag[s.charAt(i) - 'a'][s.charAt(i - 1) - 'a']) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}