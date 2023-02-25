/**
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 * <p>
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 * <p>
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]
 * 。
 * <p>
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "xx", s2 = "yy"
 * 输出：1
 * 解释：
 * 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s1 = "xy", s2 = "yx"
 * 输出：2
 * 解释：
 * 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 * 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 * 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s1 = "xx", s2 = "xy"
 * 输出：-1
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * 输出：4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 只包含 'x' 或 'y'。
 * <p>
 * <p>
 * Related Topics 贪心 数学 字符串 👍 129 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MinimumSwapsToMakeStringsEqual {
    public static void main(String[] args) {
        //Solution solution = new MinimumSwapsToMakeStringsEqual().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSwap(String s1, String s2) {
            int xy = 0, yx = 0;
            int n = s1.length();
            for (int i = 0; i < n; i++) {
                char a = s1.charAt(i), b = s2.charAt(i);
                if (a == 'x' && b == 'y') {
                    xy++;
                }
                if (a == 'y' && b == 'x') {
                    yx++;
                }
            }
            if ((xy + yx) % 2 == 1) {
                return -1;
            }
            return xy / 2 + yx / 2 + xy % 2 + yx % 2;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}