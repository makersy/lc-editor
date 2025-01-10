/**
 * 给你两个字符串 word1 和 word2 。
 * <p>
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。
 * <p>
 * 请你返回 word1 中 合法 子字符串 的数目。
 * <p>
 * 注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word1 = "bcca", word2 = "abc"
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word1 = "abcabc", word2 = "abc"
 * <p>
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * 除了长度为 1 和 2 的所有子字符串都是合法的。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：word1 = "abcabc", word2 = "aaabc"
 * <p>
 * <p>
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 解释：
 * <p>
 * <p>
 * 1 <= word1.length <= 10⁶ 1 <= word2.length <= 10⁴ word1 和 word2 都只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 31 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountSubstringsThatCanBeRearrangedToContainAStringIi {

    public static void main(String[] args) {
        //Solution solution = new CountSubstringsThatCanBeRearrangedToContainAStringIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long validSubstringCount(String S, String T) {
            if (S.length() < T.length()) {
                return 0;
            }

            char[] s = S.toCharArray();
            char[] t = T.toCharArray();
            int[] diff = new int[26]; // t 的字母出现次数与 s 的字母出现次数之差
            for (char c : t) {
                diff[c - 'a']++;
            }

            // 统计窗口内有多少个字母的出现次数比 t 的少
            int less = 0;
            for (int d : diff) {
                if (d > 0) {
                    less++;
                }
            }

            long ans = 0;
            int left = 0;
            for (char c : s) {
                diff[c - 'a']--;
                if (diff[c - 'a'] == 0) {
                    // c 移入窗口后，窗口内 c 的出现次数和 t 的一样
                    less--;
                }
                while (less == 0) { // 窗口符合要求
                    char outChar = s[left++]; // 准备移出窗口的字母
                    if (diff[outChar - 'a'] == 0) {
                        // outChar 移出窗口之前检查出现次数，
                        // 如果窗口内 outChar 的出现次数和 t 的一样，
                        // 那么 outChar 移出窗口后，窗口内 outChar 的出现次数比 t 的少
                        less++;
                    }
                    diff[outChar - 'a']++;
                }
                ans += left;
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}