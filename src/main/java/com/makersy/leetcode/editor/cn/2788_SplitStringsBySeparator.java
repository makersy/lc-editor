/**
 * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
 * <p>
 * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
 * <p>
 * 注意
 * <p>
 * <p>
 * separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
 * 拆分可能形成两个以上的字符串。
 * 结果字符串必须保持初始相同的先后顺序。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：words = ["one.two.three","four.five","six"], separator = "."
 * 输出：["one","two","three","four","five","six"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "one.two.three" 拆分为 "one", "two", "three"
 * "four.five" 拆分为 "four", "five"
 * "six" 拆分为 "six"
 * <p>
 * 因此，结果数组为 ["one","two","three","four","five","six"] 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：words = ["$easy$","$problem$"], separator = "$"
 * 输出：["easy","problem"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "$easy$" 拆分为 "easy"（不包括空字符串）
 * "$problem$" 拆分为 "problem"（不包括空字符串）
 * <p>
 * 因此，结果数组为 ["easy","problem"] 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：words = ["|||"], separator = "|"
 * 输出：[]
 * 解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
 * separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 28 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class SplitStringsBySeparator {
    public static void main(String[] args) {
        //Solution solution = new SplitStringsBySeparator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> res = new ArrayList<String>();
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                int length = word.length();
                for (int i = 0; i < length; i++) {
                    char c = word.charAt(i);
                    if (c == separator) {
                        if (sb.length() > 0) {
                            res.add(sb.toString());
                            sb.setLength(0);
                        }
                    } else {
                        sb.append(c);
                    }
                }
                if (sb.length() > 0) {
                    res.add(sb.toString());
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}