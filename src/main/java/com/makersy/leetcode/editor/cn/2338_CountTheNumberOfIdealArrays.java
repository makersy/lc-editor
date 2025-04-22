/**
 * 给你两个整数 n 和 maxValue ，用于描述一个 理想数组 。
 * <p>
 * 对于下标从 0 开始、长度为 n 的整数数组 arr ，如果满足以下条件，则认为该数组是一个 理想数组 ：
 * <p>
 * <p>
 * 每个 arr[i] 都是从 1 到 maxValue 范围内的一个值，其中 0 <= i < n 。 每个 arr[i] 都可以被 arr[i - 1] 整除，其中 0 < i < n 。
 * <p>
 * <p>
 * 返回长度为 n 的 不同 理想数组的数目。由于答案可能很大，返回对 10⁹ + 7 取余的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, maxValue = 5 输出：10 解释：存在以下理想数组： - 以 1 开头的数组（5 个）：[1,1]、[1,2]、[1,3]、[1,4]、[1,5] - 以 2 开头的数组（2 个）：[2,2]、[2,4]
 * - 以 3 开头的数组（1 个）：[3,3] - 以 4 开头的数组（1 个）：[4,4] - 以 5 开头的数组（1 个）：[5,5] 共计 5 + 2 + 1 + 1 + 1 = 10 个不同理想数组。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5, maxValue = 3 输出：11 解释：存在以下理想数组： - 以 1 开头的数组（9 个）： - 不含其他不同值（1 个）：[1,1,1,1,1] - 含一个不同值 2（4 个）：[1,1,1,1,2],
 * [1,1,1,2,2], [1,1,2,2,2], [1,2,2,2,2] - 含一个不同值 3（4 个）：[1,1,1,1,3], [1,1,1,3,3], [1,1,3,3,3], [1,3,3,3,3] - 以 2
 * 开头的数组（1 个）：[2,2,2,2,2] - 以 3 开头的数组（1 个）：[3,3,3,3,3] 共计 9 + 1 + 1 = 11 个不同理想数组。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 10⁴ 1 <= maxValue <= 10⁴
 * <p>
 * <p>
 * Related Topics 数学 动态规划 组合数学 数论 👍 89 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class CountTheNumberOfIdealArrays {

    public static void main(String[] args) {
        //Solution solution = new CountTheNumberOfIdealArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        static int MOD = 1000000007;

        static int MAX_N = 10010;

        static int MAX_P = 15; // 最多有 15 个质因子

        static int[][] c = new int[MAX_N + MAX_P][MAX_P + 1];

        static int[] sieve = new int[MAX_N]; // 最小质因子

        static List<Integer>[] ps = new List[MAX_N]; // 质因子个数列表

        public Solution() {
            if (c[0][0] == 1) {
                return;
            }

            for (int i = 0; i < MAX_N; i++) {
                ps[i] = new ArrayList<>();
            }

            for (int i = 2; i < MAX_N; i++) {
                if (sieve[i] == 0) {
                    for (int j = i; j < MAX_N; j += i) {
                        if (sieve[j] == 0) {
                            sieve[j] = i;
                        }
                    }
                }
            }

            for (int i = 2; i < MAX_N; i++) {
                int x = i;
                while (x > 1) {
                    int p = sieve[x], cnt = 0;
                    while (x % p == 0) {
                        x /= p;
                        cnt++;
                    }
                    ps[i].add(cnt);
                }
            }

            c[0][0] = 1;
            for (int i = 1; i < MAX_N + MAX_P; i++) {
                c[i][0] = 1;
                for (int j = 1; j <= Math.min(i, MAX_P); j++) {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
                }
            }
        }

        public int idealArrays(int n, int maxValue) {
            long ans = 0;
            for (int x = 1; x <= maxValue; x++) {
                long mul = 1;
                for (int p : ps[x]) {
                    mul = mul * c[n + p - 1][p] % MOD;
                }
                ans = (ans + mul) % MOD;
            }
            return (int) ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}