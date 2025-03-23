/**
 * 一个括号字符串是只由 '(' 和 ')' 组成的 非空 字符串。如果一个字符串满足下面 任意 一个条件，那么它就是有效的：
 * <p>
 * <p>
 * 字符串为 (). 它可以表示为 AB（A 与 B 连接），其中A 和 B 都是有效括号字符串。 它可以表示为 (A) ，其中 A 是一个有效括号字符串。
 * <p>
 * <p>
 * 给你一个括号字符串 s 和一个字符串 locked ，两者长度都为 n 。locked 是一个二进制字符串，只包含 '0' 和 '1' 。对于 locked 中 每一个 下标 i ：
 * <p>
 * <p>
 * 如果 locked[i] 是 '1' ，你 不能 改变 s[i] 。 如果 locked[i] 是 '0' ，你 可以 将 s[i] 变为 '(' 或者 ')' 。
 * <p>
 * <p>
 * 如果你可以将 s 变为有效括号字符串，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：s = "))()))", locked = "010100" 输出：true 解释：locked[1] == '1' 和 locked[3] == '1' ，所以我们无法改变 s[1] 或者 s[3] 。 我们可以将 s[0]
 * 和 s[4] 变为 '(' ，不改变 s[2] 和 s[5] ，使 s 变为有效字符串。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()()", locked = "0000" 输出：true 解释：我们不需要做任何改变，因为 s 已经是有效字符串了。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = ")", locked = "0" 输出：false 解释：locked 允许改变 s[0] 。 但无论将 s[0] 变为 '(' 或者 ')' 都无法使 s 变为有效字符串。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "(((())(((())", locked = "111111010111" 输出：true 解释：locked 允许我们改变 s[6] 和 s[8]。 我们将 s[6] 和 s[8] 改为 ')' 使 s
 * 变为有效字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == s.length == locked.length 1 <= n <= 10⁵ s[i] 要么是 '(' 要么是 ')' 。 locked[i] 要么是 '0' 要么是 '1' 。
 * <p>
 * <p>
 * Related Topics 栈 贪心 字符串 👍 84 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CheckIfAParenthesesStringCanBeValid {

    public static void main(String[] args) {
        //Solution solution = new CheckIfAParenthesesStringCanBeValid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canBeValid(String s, String locked) {
            int n = s.length();
            int mx = 0;   // 可以达到的最大分数
            int mn = 0;   // 可以达到的最小分数 与 最小有效前缀对应分数 的较大值
            for (int i = 0; i < n; ++i) {
                if (locked.charAt(i) == '1') {
                    // 此时对应字符无法更改
                    int diff;
                    if (s.charAt(i) == '(') {
                        diff = 1;
                    } else {
                        diff = -1;
                    }
                    mx += diff;
                    mn = Math.max(mn + diff, (i + 1) % 2);
                } else {
                    // 此时对应字符可以更改
                    ++mx;
                    mn = Math.max(mn - 1, (i + 1) % 2);
                }
                if (mx < mn) {
                    // 此时该前缀无法变为有效前缀
                    return false;
                }
            }
            // 最终确定 s 能否通过变换使得分数为 0（成为有效字符串）
            return mn == 0;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}