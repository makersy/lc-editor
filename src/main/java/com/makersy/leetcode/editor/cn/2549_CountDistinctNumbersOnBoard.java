/**
 * 给你一个正整数 n ，开始时，它放在桌面上。在 10⁹ 天内，每天都要执行下述步骤：
 * <p>
 * <p>
 * 对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。 然后，将这些数字放在桌面上。
 * <p>
 * <p>
 * 返回在 10⁹ 天之后，出现在桌面上的 不同 整数的数目。
 * <p>
 * 注意：
 * <p>
 * <p>
 * 一旦数字放在桌面上，则会一直保留直到结束。 % 表示取余运算。例如，14 % 3 等于 2 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 5 输出：4 解释：最开始，5 在桌面上。 第二天，2 和 4 也出现在桌面上，因为 5 % 2 == 1 且 5 % 4 == 1 。 再过一天 3 也出现在桌面上，因为 4 % 3 == 1 。
 * 在十亿天结束时，桌面上的不同数字有 2 、3 、4 、5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3 输出：2 解释： 因为 3 % 2 == 1 ，2 也出现在桌面上。 在十亿天结束时，桌面上的不同数字只有两个：2 和 3 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 100
 * <p>
 * <p>
 * Related Topics 数组 哈希表 数学 模拟 👍 53 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class CountDistinctNumbersOnBoard {

    public static void main(String[] args) {
        //Solution solution = new CountDistinctNumbersOnBoard().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int distinctIntegers(int n) {
            int[] nums = new int[n + 1];
            nums[n] = 1;
            for (int k = 0; k < n; k++) {
                for (int x = 1; x <= n; x++) {
                    if (nums[x] == 0) {
                        continue;
                    }
                    for (int i = 1; i <= n; i++) {
                        if (x % i == 1) {
                            nums[i] = 1;
                        }
                    }
                }
            }
            return Arrays.stream(nums).sum();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}