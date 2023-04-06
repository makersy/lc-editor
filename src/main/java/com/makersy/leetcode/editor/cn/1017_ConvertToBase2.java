/**
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)² + (-2)¹ = 2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)² + (-2)¹ + (-2)⁰ = 3
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)² = 4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 10⁹
 * <p>
 * <p>
 * Related Topics 数学 👍 135 👎 0
 */

package com.makersy.leetcode.editor.cn;

class ConvertToBase2 {
    public static void main(String[] args) {
        //Solution solution = new ConvertToBase2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0 || n == 1) {
                return String.valueOf(n);
            }
            StringBuilder res = new StringBuilder();
            while (n != 0) {
                int remainder = n & 1;
                res.append(remainder);
                n -= remainder;
                n /= -2;
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}