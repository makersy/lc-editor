/**
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2 有
 * difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说
 * 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * <p>
 * <p>
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 49 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class OddStringDifference {
    public static void main(String[] args) {
        //Solution solution = new OddStringDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String oddString(String[] words) {
            var d = new HashMap<String, List<String>>();
            for (var s : words) {
                int m = s.length();
                var cs = new char[m - 1];
                for (int i = 0; i < m - 1; ++i) {
                    cs[i] = (char) (s.charAt(i + 1) - s.charAt(i));
                }
                var t = String.valueOf(cs);
                d.computeIfAbsent(t, k -> new ArrayList<>()).add(s);
            }
            for (var ss : d.values()) {
                if (ss.size() == 1) {
                    return ss.get(0);
                }
            }
            return "";
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}