/**
 * 给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
 * <p>
 * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "abcbdd" 输出：true 解释："abcbdd" = "a" + "bcb" + "dd"，三个子字符串都是回文的。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "bcbddxy" 输出：false 解释：s 没办法被分割成 3 个回文子字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= s.length <= 2000 s 只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 👍 70 👎 0
 */

package com.makersy.leetcode.editor.cn;

class PalindromePartitioningIv {

    public static void main(String[] args) {
        //Solution solution = new PalindromePartitioningIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean checkPartitioning(String s) {
            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];
            for (int length = 1; length < n; length++) {
                for (int start = 0; start <= n - length; start++) {
                    int end = start + length - 1;
                    if (length == 1) {
                        isPalindrome[start][end] = true;
                    } else if (length == 2) {
                        isPalindrome[start][end] = (s.charAt(start) == s.charAt(end));
                    } else {
                        isPalindrome[start][end] = ((s.charAt(start) == s.charAt(end)) && (isPalindrome[start + 1][end
                                - 1]));
                    }
                }
            }
            for (int start = 1; start < n - 1; start++) {
                if (!isPalindrome[0][start - 1]) {
                    continue;
                }
                for (int end = start; end < n - 1; end++) {
                    if (isPalindrome[start][end] && isPalindrome[end + 1][n - 1]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}