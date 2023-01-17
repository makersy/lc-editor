/**
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ，
 * rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * <p>
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * <p>
 * <p>
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 数学 计数 👍 72 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class CountNicePairsInAnArray {
    public static void main(String[] args) {
        //Solution solution = new CountNicePairsInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int mod = (int) 1E9 + 7;

        public int countNicePairs(int[] nums) {
            int len = nums.length;
            long res = 0;
            Map<Integer, Integer> map = new HashMap<>(len);
            map.put(nums[0] - rev(nums[0]), 1);

            int diff, v;
            for (int i = 1; i < len; i++) {
                diff = nums[i] - rev(nums[i]);
                v = map.getOrDefault(diff, 0);
                res = (res + v) % mod;
                map.put(diff, v + 1);
            }

            return (int) res;
        }

        private int rev(int n) {
            if (n < 10) return n;

            int res = 0;
            while (n > 0) {
                res = res * 10 + n % 10;
                n /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}