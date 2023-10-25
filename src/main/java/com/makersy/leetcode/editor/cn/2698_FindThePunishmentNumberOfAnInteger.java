/**
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 10
 * 输出：182
 * 解释：总共有 3 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 37
 * 输出：1478
 * 解释：总共有 4 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
 * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 1000
 * <p>
 * <p>
 * Related Topics 数学 回溯 👍 96 👎 0
 */

package com.makersy.leetcode.editor.cn;

class FindThePunishmentNumberOfAnInteger {
    public static void main(String[] args) {
        // Solution solution = new FindThePunishmentNumberOfAnInteger().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] arr = new int[1010];

        static {
            for (int i = 1; i < 1010; i++) {
                arr[i] = arr[i - 1];
                if (check(i, i * i)) {
                    arr[i] += i * i;
                }
            }
        }

        private static boolean check(int target, int n) {
            if (target == n) {
                return true;
            }
            int base = 10;
            while (target >= n % base && n >= base) {
                if (check(target - n % base, n / base)) {
                    return true;
                }
                base *= 10;
            }
            return false;
        }

        public int punishmentNumber(int n) {
            return arr[n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}