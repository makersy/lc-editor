/**
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。
 * <p>
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此
 * 时认为 s 是 平衡 的。
 * <p>
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] 要么是 'a' 要么是 'b' 。
 * <p>
 * <p>
 * Related Topics 栈 字符串 动态规划 👍 161 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        //Solution solution = new MinimumDeletionsToMakeStringBalanced().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeletions(String s) {
            int leftb = 0, righta = 0, len = s.length();
            int res = len + 1;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == 'a') {
                    righta++;
                }
            }
            for (int i = 0; i < len; i++) {
                res = Math.min(leftb + righta, res);
                if (s.charAt(i) == 'b') {
                    leftb++;
                } else {
                    righta--;
                }
            }
            res = Math.min(leftb + righta, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}