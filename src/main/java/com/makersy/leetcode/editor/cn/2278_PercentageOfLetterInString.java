/**
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "foobar", letter = "o" 输出：33 解释： 等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "jjjj", letter = "k" 输出：0 解释： 等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 100 s 由小写英文字母组成 letter 是一个小写英文字母
 * <p>
 * <p>
 * Related Topics 字符串 👍 37 👎 0
 */

package com.makersy.leetcode.editor.cn;

class PercentageOfLetterInString {

    public static void main(String[] args) {
        //Solution solution = new PercentageOfLetterInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int percentageLetter(String s, char letter) {
            int n = s.length();
            int cnt = 0;
            for (char ch : s.toCharArray()) {
                if (ch == letter) {
                    ++cnt;
                }
            }
            return 100 * cnt / n;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}