/**
 * 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * <p>
 * <p>
 * 如果字符是 'z'，则将其替换为字符串 "ab"。 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
 * <p>
 * <p>
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * <p>
 * 由于答案可能非常大，返回其对 10⁹ + 7 取余的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： s = "abcyy", t = 2
 * <p>
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * <p>
 * 第一次转换 (t = 1)
 * <p>
 * <p>
 * <p>
 * 'a' 变为 'b' 'b' 变为 'c' 'c' 变为 'd' 'y' 变为 'z' 'y' 变为 'z' 第一次转换后的字符串为："bcdzz"
 * <p>
 * <p>
 * 第二次转换 (t = 2)
 * <p>
 * 'b' 变为 'c' 'c' 变为 'd' 'd' 变为 'e' 'z' 变为 "ab" 'z' 变为 "ab" 第二次转换后的字符串为："cdeabab"
 * <p>
 * <p>
 * 最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： s = "azbk", t = 1
 * <p>
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * <p>
 * 第一次转换 (t = 1)
 * <p>
 * <p>
 * <p>
 * 'a' 变为 'b' 'z' 变为 "ab" 'b' 变为 'c' 'k' 变为 'l' 第一次转换后的字符串为："babcl"
 * <p>
 * <p>
 * 最终字符串长度：字符串为 "babcl"，长度为 5 个字符。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵ s 仅由小写英文字母组成。 1 <= t <= 10⁵
 * <p>
 * <p>
 * Related Topics 哈希表 数学 字符串 动态规划 计数 👍 36 👎 0
 */

package com.makersy.leetcode.editor.cn;

class TotalCharactersInStringAfterTransformationsI {

    public static void main(String[] args) {
        //Solution solution = new TotalCharactersInStringAfterTransformationsI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1000000007;

        public int lengthAfterTransformations(String s, int t) {
            int[] cnt = new int[26];
            for (char ch : s.toCharArray()) {
                ++cnt[ch - 'a'];
            }
            for (int round = 0; round < t; ++round) {
                int[] nxt = new int[26];
                nxt[0] = cnt[25];
                nxt[1] = (cnt[25] + cnt[0]) % MOD;
                for (int i = 2; i < 26; ++i) {
                    nxt[i] = cnt[i - 1];
                }
                cnt = nxt;
            }
            int ans = 0;
            for (int i = 0; i < 26; ++i) {
                ans = (ans + cnt[i]) % MOD;
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}