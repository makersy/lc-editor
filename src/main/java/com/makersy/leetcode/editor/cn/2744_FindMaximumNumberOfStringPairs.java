/**
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * <p>
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * <p>
 * <p>
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * <p>
 * <p>
 * 请你返回数组 words 中的 最大 匹配数目。
 * <p>
 * 注意，每个字符串最多匹配一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：words = ["cd","ac","dc","ca","zz"]
 * 输出：2
 * 解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
 * - 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
 * - 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
 * 可以证明最多匹配数目是 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：words = ["ab","ba","cc"]
 * 输出：1
 * 解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
 * - 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
 * 可以证明最多匹配数目是 1 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：words = ["aa","ab"]
 * 输出：0
 * 解释：这个例子中，无法匹配任何字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 模拟 👍 34 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class FindMaximumNumberOfStringPairs {
    public static void main(String[] args) {
        //Solution solution = new FindMaximumNumberOfStringPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumNumberOfStringPairs(String[] words) {
            Set<String> set = new HashSet<>(words.length);

            int res = 0;
            for (String w : words) {
                String w1 = String.valueOf(w.charAt(1)) + w.charAt(0);
                if (w.charAt(0) != w.charAt(1) && set.contains(w1)) {
                    set.remove(w1);
                    res++;
                } else {
                    set.add(w);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}