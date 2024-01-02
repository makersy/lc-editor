/**
 * 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * <p>
 * <p>
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * <p>
 * <p>
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * <p>
 * <p>
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
 * <p>
 * <p>
 * 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2]
 * 。
 * <p>
 * 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1 和 s2 由小写英文字母组成
 * 1 <= n1, n2 <= 10⁶
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 👍 264 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountTheRepetitions {
    public static void main(String[] args) {
        //Solution solution = new CountTheRepetitions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int[] dp = new int[s2.length()];
            for (int i = 0; i < s2.length(); i++) {
                int j = i;
                for (int p = 0; p < s1.length(); p++) {
                    if (s1.charAt(p) == s2.charAt(j)) {
                        j = (j + 1) % s2.length();
                        dp[i]++;
                    }
                }
            }
            int cnt = 0, p = 0;
            for (int i = 0; i < n1; i++) {
                int add = dp[p];
                p = (p + add) % s2.length();
                cnt += add;
            }
            return cnt / s2.length() / n2;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}