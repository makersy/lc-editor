/**
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和
 * asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b =
 * bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 * <p>
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
 * "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 * <p>
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 * <p>
 * 注意， x + y 表示连接字符串 x 和 y 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：a = "abdef", b = "fecab"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * 那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= a.length, b.length <= 10⁵
 * a.length == b.length
 * a 和 b 都只包含小写英文字母
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 99 👎 0
 */

package com.makersy.leetcode.editor.cn;

class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        //Solution solution = new SplitTwoStringsToMakePalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            int len1 = a.length(), len2 = b.length();
            int i;
            for (i = 0; i < len1; i++) {
                if (a.charAt(i) != b.charAt(len1 - 1 - i)) {
                    break;
                }
            }
            if (i == len1) return true;
            if (isPalin(a, i, len1 - 1 - i) || isPalin(b, i, len1 - 1 - i)) {
                return true;
            }

            for (i = 0; i < len1; i++) {
                if (b.charAt(i) != a.charAt(len1 - 1 - i)) {
                    break;
                }
            }
            if (i == len1) return true;
            if (isPalin(a, i, len1 - 1 - i) || isPalin(b, i, len1 - 1 - i)) {
                return true;
            }
            return false;
        }

        private boolean isPalin(String str, int s, int e) {
            while (s < e) {
                if (str.charAt(s) != str.charAt(e)) return false;
                s++;
                e--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}