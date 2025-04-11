/**
 * 给你两个正整数 low 和 high 。
 * <p>
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * <p>
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：low = 1, high = 100 输出：9 解释：在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：low = 1200, high = 1230 输出：4 解释：在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= low <= high <= 10⁴
 * <p>
 * <p>
 * Related Topics 数学 枚举 👍 37 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountSymmetricIntegers {

    public static void main(String[] args) {
        //Solution solution = new CountSymmetricIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countSymmetricIntegers(int low, int high) {
            int res = 0;
            for (int a = low; a <= high; ++a) {
                if (a < 100 && a % 11 == 0) {
                    res++;
                } else if (1000 <= a && a < 10000) {
                    int left = a / 1000 + (a % 1000) / 100;
                    int right = (a % 100) / 10 + a % 10;
                    if (left == right) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}