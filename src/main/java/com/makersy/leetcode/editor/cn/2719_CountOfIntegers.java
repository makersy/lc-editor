/**
 * 给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数：
 * <p>
 * <p>
 * num1 <= x <= num2
 * min_sum <= digit_sum(x) <= max_sum.
 * <p>
 * <p>
 * 请你返回好整数的数目。答案可能很大，请返回答案对 10⁹ + 7 取余后的结果。
 * <p>
 * 注意，digit_sum(x) 表示 x 各位数字之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
 * 输出：11
 * 解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num1 = "1", num2 = "5", min_num = 1, max_num = 5
 * 输出：5
 * 解释：数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num1 <= num2 <= 10²²
 * 1 <= min_sum <= max_sum <= 400
 * <p>
 * <p>
 * Related Topics 数学 字符串 动态规划 👍 80 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class CountOfIntegers {
    public static void main(String[] args) {
        //Solution solution = new CountOfIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int N = 23;
        static final int M = 401;
        static final int MOD = 1000000007;
        int[][] d;
        String num;
        int min_sum;
        int max_sum;

        public int count(String num1, String num2, int min_sum, int max_sum) {
            d = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(d[i], -1);
            }
            this.min_sum = min_sum;
            this.max_sum = max_sum;
            return (get(num2) - get(sub(num1)) + MOD) % MOD;
        }

        public int get(String num) {
            this.num = new StringBuffer(num).reverse().toString();
            return dfs(num.length() - 1, 0, true);
        }

        // 求解 num - 1，先把最后一个非 0 字符减去 1，再把后面的 0 字符变为 9
        public String sub(String num) {
            char[] arr = num.toCharArray();
            int i = arr.length - 1;
            while (arr[i] == '0') {
                i--;
            }
            arr[i]--;
            i++;
            while (i < arr.length) {
                arr[i] = '9';
                i++;
            }
            return new String(arr);
        }

        public int dfs(int i, int j, boolean limit) {
            if (j > max_sum) {
                return 0;
            }
            if (i == -1) {
                return j >= min_sum ? 1 : 0;
            }
            if (!limit && d[i][j] != -1) {
                return d[i][j];
            }
            int res = 0;
            int up = limit ? num.charAt(i) - '0' : 9;
            for (int x = 0; x <= up; x++) {
                res = (res + dfs(i - 1, j + x, limit && x == up)) % MOD;
            }
            if (!limit) {
                d[i][j] = res;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}