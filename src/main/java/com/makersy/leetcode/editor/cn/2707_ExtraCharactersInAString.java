/**
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在
 * dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 * <p>
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们
 * 返回 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，
 * 所以我们返回 3 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] 和 s 只包含小写英文字母。
 * dictionary 中的单词互不相同。
 * <p>
 * <p>
 * Related Topics 字典树 数组 哈希表 字符串 动态规划 👍 79 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class ExtraCharactersInAString {
    public static void main(String[] args) {
        //Solution solution = new ExtraCharactersInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            Set<String> ss = new HashSet<>();
            for (String w : dictionary) {
                ss.add(w);
            }
            int n = s.length();
            int[] f = new int[n + 1];
            f[0] = 0;
            for (int i = 1; i <= n; ++i) {
                f[i] = f[i - 1] + 1;
                for (int j = 0; j < i; ++j) {
                    if (ss.contains(s.substring(j, i))) {
                        f[i] = Math.min(f[i], f[j]);
                    }
                }
            }
            return f[n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}