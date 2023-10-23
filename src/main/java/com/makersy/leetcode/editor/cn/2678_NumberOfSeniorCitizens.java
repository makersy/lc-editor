/**
 * 给你一个下标从 0 开始的字符串 details 。details 中每个元素都是一位乘客的信息，信息用长度为 15 的字符串表示，表示方式如下：
 * <p>
 * <p>
 * 前十个字符是乘客的手机号码。
 * 接下来的一个字符是乘客的性别。
 * 接下来两个字符是乘客的年龄。
 * 最后两个字符是乘客的座位号。
 * <p>
 * <p>
 * 请你返回乘客中年龄 严格大于 60 岁 的人数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
 * 输出：2
 * 解释：下标为 0 ，1 和 2 的乘客年龄分别为 75 ，92 和 40 。所以有 2 人年龄大于 60 岁。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：details = ["1313579440F2036","2921522980M5644"]
 * 输出：0
 * 解释：没有乘客的年龄大于 60 岁。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= details.length <= 100
 * details[i].length == 15
 * details[i] 中的数字只包含 '0' 到 '9' 。
 * details[i][10] 是 'M' ，'F' 或者 'O' 之一。
 * 所有乘客的手机号码和座位号互不相同。
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 33 👎 0
 */

package com.makersy.leetcode.editor.cn;

class NumberOfSeniorCitizens {
    public static void main(String[] args) {
        // Solution solution = new NumberOfSeniorCitizens().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSeniors(String[] details) {
            int res = 0;
            for (var d : details) {
                if (d.charAt(11) > '6' || d.charAt(11) == '6' && d.charAt(12) > '0') {
                    res++;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}