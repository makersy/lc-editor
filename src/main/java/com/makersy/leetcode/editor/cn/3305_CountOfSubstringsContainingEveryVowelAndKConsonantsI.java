/**
 * 给你一个字符串 word 和一个 非负 整数 k。
 * <p>
 * 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word = "aeioqq", k = 1
 * <p>
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 不存在包含所有元音字母的子字符串。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word = "aeiou", k = 0
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一一个包含所有元音字母且不含辅音字母的子字符串是 word[0..4]，即 "aeiou"。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：word = "ieaouqqieaouqq", k = 1
 * <p>
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 包含所有元音字母并且恰好含有一个辅音字母的子字符串有：
 * <p>
 * <p>
 * word[0..5]，即 "ieaouq"。 word[6..11]，即 "qieaou"。 word[7..12]，即 "ieaouq"。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 5 <= word.length <= 250 word 仅由小写英文字母组成。 0 <= k <= word.length - 5
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 36 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class CountOfSubstringsContainingEveryVowelAndKConsonantsI {

    public static void main(String[] args) {
        //Solution solution = new CountOfSubstringsContainingEveryVowelAndKConsonantsI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countOfSubstrings(String word, int k) {
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            int n = word.length();
            int res = 0;
            for (int i = 0; i < n; i++) {
                Set<Character> occur = new HashSet<>();
                int consonants = 0;
                for (int j = i; j < n; j++) {
                    if (vowels.contains(word.charAt(j))) {
                        occur.add(word.charAt(j));
                    } else {
                        consonants++;
                    }
                    if (occur.size() == 5 && consonants == k) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}