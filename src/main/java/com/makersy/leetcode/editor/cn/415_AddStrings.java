/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num1.length, num2.length <= 10⁴
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * <p>
 * <p>
 * Related Topics 数学 字符串 模拟 👍 753 👎 0
 */

package com.makersy.leetcode.editor.cn;

class AddStrings {
    public static void main(String[] args) {
        // Solution solution = new AddStrings().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length() - 1, len2 = num2.length() - 1;
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            while (len1 >= 0 || len2 >= 0) {
                if (len1 >= 0) {
                    sum += num1.charAt(len1) - '0';
                    len1--;
                }
                if (len2 >= 0) {
                    sum += num2.charAt(len2) - '0';
                    len2--;
                }
                sb.append(sum % 10);
                sum /= 10;
            }

            if (sum > 0) {
                sb.append(sum);
            }
            return sb.reverse().toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}