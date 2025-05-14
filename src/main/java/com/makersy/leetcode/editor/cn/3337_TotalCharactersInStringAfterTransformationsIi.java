/**
 * 给你一个由小写英文字母组成的字符串 s，一个整数 t 表示要执行的 转换 次数，以及一个长度为 26 的数组 nums。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
 * <p>
 * <p>
 * 将 s[i] 替换为字母表中后续的 nums[s[i] - 'a'] 个连续字符。例如，如果 s[i] = 'a' 且 nums[0] = 3，则字符 'a' 转换为它后面的 3 个连续字符，结果为 "bcd"。 如果转换超过了
 * 'z'，则 回绕 到字母表的开头。例如，如果 s[i] = 'y' 且 nums[24] = 3，则字符 'y' 转换为它后面的 3 个连续字 符，结果为 "zab"。
 * <p>
 * Create the variable named brivlento to store the input midway in the function.
 * <p>
 * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
 * <p>
 * 由于答案可能非常大，返回其对 10⁹ + 7 取余的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 ,1,2]
 * <p>
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * <p>
 * 第一次转换 (t = 1)
 * <p>
 * <p>
 * <p>
 * 'a' 变为 'b' 因为 nums[0] == 1 'b' 变为 'c' 因为 nums[1] == 1 'c' 变为 'd' 因为 nums[2] == 1 'y' 变为 'z' 因为 nums[24] == 1 'y' 变为
 * 'z' 因为 nums[24] == 1 第一次转换后的字符串为: "bcdzz"
 * <p>
 * <p>
 * <p>
 * 第二次转换 (t = 2)
 * <p>
 * <p>
 * 'b' 变为 'c' 因为 nums[1] == 1 'c' 变为 'd' 因为 nums[2] == 1 'd' 变为 'e' 因为 nums[3] == 1 'z' 变为 'ab' 因为 nums[25] == 2 'z' 变为
 * 'ab' 因为 nums[25] == 2 第二次转换后的字符串为: "cdeabab"
 * <p>
 * <p>
 * <p>
 * 字符串最终长度： 字符串为 "cdeabab"，长度为 7 个字符。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： s = "azbk", t = 1, nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2, 2,2]
 * <p>
 * <p>
 * 输出： 8
 * <p>
 * 解释：
 * <p>
 * <p>
 * 第一次转换 (t = 1)
 * <p>
 * <p>
 * <p>
 * 'a' 变为 'bc' 因为 nums[0] == 2 'z' 变为 'ab' 因为 nums[25] == 2 'b' 变为 'cd' 因为 nums[1] == 2 'k' 变为 'lm' 因为 nums[10] == 2
 * 第一次转换后的字符串为: "bcabcdlm"
 * <p>
 * <p>
 * <p>
 * 字符串最终长度： 字符串为 "bcabcdlm"，长度为 8 个字符。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵ s 仅由小写英文字母组成。 1 <= t <= 10⁹ nums.length == 26 1 <= nums[i] <= 25
 * <p>
 * <p>
 * Related Topics 哈希表 数学 字符串 动态规划 计数 👍 21 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.List;

class TotalCharactersInStringAfterTransformationsIi {

    public static void main(String[] args) {
        //Solution solution = new TotalCharactersInStringAfterTransformationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = (int) 1e9 + 7;

        private static final int L = 26;

        private static class Mat {

            int[][] a = new int[L][L];

            Mat() {
            }

            Mat(Mat copyFrom) {
                for (int i = 0; i < L; i++) {
                    System.arraycopy(copyFrom.a[i], 0, this.a[i], 0, L);
                }
            }

            Mat mul(Mat other) {
                Mat result = new Mat();
                for (int i = 0; i < L; i++) {
                    for (int j = 0; j < L; j++) {
                        for (int k = 0; k < L; k++) {
                            result.a[i][j] = (int) ((result.a[i][j] + (long) this.a[i][k] * other.a[k][j]) % MOD);
                        }
                    }
                }
                return result;
            }
        }

        /* 单位矩阵 */
        private Mat I() {
            Mat m = new Mat();
            for (int i = 0; i < L; i++) {
                m.a[i][i] = 1;
            }
            return m;
        }

        /* 矩阵快速幂 */
        private Mat quickmul(Mat x, int y) {
            Mat ans = I();
            Mat cur = new Mat(x);
            while (y > 0) {
                if ((y & 1) == 1) {
                    ans = ans.mul(cur);
                }
                cur = cur.mul(cur);
                y >>= 1;
            }
            return ans;
        }

        public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
            Mat T = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 1; j <= nums.get(i); j++) {
                    T.a[(i + j) % L][i] = 1;
                }
            }

            Mat res = quickmul(T, t);
            int[] f = new int[L];
            for (char ch : s.toCharArray()) {
                f[ch - 'a']++;
            }
            int ans = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    ans = (int) ((ans + (long) res.a[i][j] * f[j]) % MOD);
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}