/**
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 * <p>
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "b"
 * 输出：2
 * 解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "aaa"
 * 输出：6
 * 解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "abc"
 * 输出：0
 * 解释：word 已经是有效字符串，不需要进行修改。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成。
 * <p>
 * <p>
 * Related Topics 栈 贪心 字符串 动态规划 👍 73 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class MinimumAdditionsToMakeValidString {
    public static void main(String[] args) {
        //Solution solution = new MinimumAdditionsToMakeValidString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static Map<Character, Character> map = new HashMap<>();

        static {
            map.put('a', 'b');
            map.put('b', 'c');
            map.put('c', 'a');
        }

        public int addMinimum(String word) {
            char last = 'c';
            int res = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.get(last).equals(c)) {
                    if (c == 'c' && last == 'a') {
                        res++;
                    } else {
                        if (last == 'b') res++;
                        else if (last == 'a') res += 2;
                        if (c == 'b') res++;
                        else if (c == 'c') res += 2;
                    }
                }
                last = c;
            }
            if (last == 'b') res++;
            else if (last == 'a') res += 2;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}