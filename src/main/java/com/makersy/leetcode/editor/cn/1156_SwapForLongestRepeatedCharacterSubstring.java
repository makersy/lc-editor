/**
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 155 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class SwapForLongestRepeatedCharacterSubstring {
    public static void main(String[] args) {
        //Solution solution = new SwapForLongestRepeatedCharacterSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepOpt1(String text) {
            int[] cnt = new int[26];
            int n = text.length();
            for (int i = 0; i < n; ++i) {
                ++cnt[text.charAt(i) - 'a'];
            }
            int ans = 0, i = 0;
            while (i < n) {
                int j = i;
                while (j < n && text.charAt(j) == text.charAt(i)) {
                    ++j;
                }
                int l = j - i;
                int k = j + 1;
                while (k < n && text.charAt(k) == text.charAt(i)) {
                    ++k;
                }
                int r = k - j - 1;
                ans = Math.max(ans, Math.min(l + r + 1, cnt[text.charAt(i) - 'a']));
                i = j;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}