/**
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * <p>
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * <p>
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * <p>
 * 注意 返回的结果字符串 可以 含前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "010" 输出："001" 解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "0101" 输出："1001" 解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 100 s 仅由 '0' 和 '1' 组成 s 中至少包含一个 '1'
 * <p>
 * <p>
 * Related Topics 贪心 数学 字符串 👍 19 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        //Solution solution = new MaximumOddBinaryNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String maximumOddBinaryNumber(String s) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                cnt += s.charAt(i) - '0';
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt - 1; i++) {
                sb.append('1');
            }
            for (int i = 0; i < s.length() - cnt; i++) {
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}