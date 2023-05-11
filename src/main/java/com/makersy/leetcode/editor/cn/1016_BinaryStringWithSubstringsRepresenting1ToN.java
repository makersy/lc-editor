/**
 * 给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回
 * false 。
 * <p>
 * 子字符串 是字符串中连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "0110", n = 3
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "0110", n = 4
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 不是 '0' 就是 '1'
 * 1 <= n <= 10⁹
 * <p>
 * <p>
 * Related Topics 字符串 👍 103 👎 0
 */

package com.makersy.leetcode.editor.cn;

class BinaryStringWithSubstringsRepresenting1ToN {
    public static void main(String[] args) {
        //Solution solution = new BinaryStringWithSubstringsRepresenting1ToN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean queryString(String s, int n) {
            StringBuilder sb0 = new StringBuilder(s).reverse();
            for (int i = 1; i <= n; i++) {
                int temp = 1;
                StringBuilder sb = new StringBuilder();
                while (temp <= i) {
                    if ((temp & i) != 0) {
                        sb.append('1');
                    } else {
                        sb.append('0');
                    }
                    temp <<= 1;
                }
                if (sb0.indexOf(sb.toString()) == -1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}