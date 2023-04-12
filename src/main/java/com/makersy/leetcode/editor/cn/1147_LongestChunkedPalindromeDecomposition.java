/**
 * 你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
 * <p>
 * <p>
 * subtexti 是 非空 字符串
 * 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 * 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 * <p>
 * <p>
 * 返回k可能最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 1000
 * text 仅由小写英文字符组成
 * <p>
 * <p>
 * Related Topics 贪心 双指针 字符串 动态规划 哈希函数 滚动哈希 👍 139 👎 0
 */

package com.makersy.leetcode.editor.cn;

class LongestChunkedPalindromeDecomposition {
    public static void main(String[] args) {
        //Solution solution = new LongestChunkedPalindromeDecomposition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestDecomposition(String text) {
            return longestDecomposition(text, 0, text.length());    // 区间[0, text.length())即查找整个字符串text
        }

        /**
         查找区间[l, r)可以拆分成多少个子串
         */
        private int longestDecomposition(String text, int l, int r) {
            // 不构成区间，拆分成0个子串
            if (l >= r) {
                return 0;
            }
            for (int i = 0; i < (r - l) / 2; i++) {
                // 找到最短相等前缀后缀子串，得到两个子串
                // 递归搜索，返回得到的两个子串 + 递归的结果
                if (text.substring(l, l + i + 1).equals(text.substring(r - i - 1, r))) {
                    return 2 + longestDecomposition(text, l + i + 1, r - i - 1);
                }
            }
            // 没有找到最短相等前缀后缀子串，text[l,r)本身作为一个子串
            return 1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}