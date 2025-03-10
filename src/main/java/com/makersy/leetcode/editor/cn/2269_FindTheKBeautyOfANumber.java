/**
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * <p>
 * 子字符串长度为 k 。 子字符串能整除 num 。
 * <p>
 * <p>
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * <p>
 * <p>
 * 允许有 前缀 0 。 0 不能整除任何值。
 * <p>
 * <p>
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = 240, k = 2 输出：2 解释：以下是 num 里长度为 k 的子字符串： - "240" 中的 "24" ：24 能整除 240 。 - "240" 中的 "40" ：40 能整除 240 。 所以，k
 * 美丽值为 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = 430043, k = 2 输出：2 解释：以下是 num 里长度为 k 的子字符串： - "430043" 中的 "43" ：43 能整除 430043 。 - "430043" 中的 "30" ：30 不能整除
 * 430043 。 - "430043" 中的 "00" ：0 不能整除 430043 。 - "430043" 中的 "04" ：4 不能整除 430043 。 - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 10⁹ 1 <= k <= num.length （将 num 视为字符串）
 * <p>
 * <p>
 * Related Topics 数学 字符串 滑动窗口 👍 46 👎 0
 */

package com.makersy.leetcode.editor.cn;

class FindTheKBeautyOfANumber {

    public static void main(String[] args) {
        //Solution solution = new FindTheKBeautyOfANumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int divisorSubstrings(int num, int k) {
            String s = Integer.toString(num);   // num 十进制表示字符串
            int n = s.length();
            int res = 0;
            for (int i = 0; i <= n - k; ++i) {
                // 枚举所有长度为 k 的子串
                int tmp = Integer.parseInt(s.substring(i, i + k));
                if (tmp != 0 && num % tmp == 0) {
                    ++res;
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}