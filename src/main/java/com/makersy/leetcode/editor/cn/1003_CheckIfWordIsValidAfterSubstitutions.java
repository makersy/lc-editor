/**
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * <p>
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * <p>
 * <p>
 * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright
 * 。注意，tleft 和 tright 可能为 空 。
 * <p>
 * <p>
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "aabcbc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "aabcbc"
 * 因此，"aabcbc" 有效。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "abcabcababcc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * 因此，"abcabcababcc" 有效。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "abccba"
 * 输出：false
 * 解释：执行操作无法得到 "abccba" 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 2 * 10⁴
 * s 由字母 'a'、'b' 和 'c' 组成
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 122 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {
        //Solution solution = new CheckIfWordIsValidAfterSubstitutions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            StringBuilder stk = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                stk.append(c);
                if (stk.length() >= 3 && stk.substring(stk.length() - 3).equals("abc")) {
                    stk.delete(stk.length() - 3, stk.length());
                }
            }
            return stk.length() == 0;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}