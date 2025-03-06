/**
 * 给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
 * <p>
 * <p>
 * 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。 将 nums[i]
 * 和 nums[j] 都减去 2ᵏ 。
 * <p>
 * <p>
 * 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。
 * <p>
 * 请你返回数组 nums 中 美丽子数组 的数目。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,3,1,2,4] 输出：2 解释：nums 中有 2 个美丽子数组：[4,3,1,2,4] 和 [4,3,1,2,4] 。 - 按照下述步骤，我们可以将子数组 [3,1,2] 中所有元素变成 0 ： - 选择
 * [3, 1, 2] 和 k = 1 。将 2 个数字都减去 2¹ ，子数组变成 [1, 1, 0] 。 - 选择 [1, 1, 0] 和 k = 0 。将 2 个数字都减去 2⁰ ，子数组变成 [0, 0, 0] 。 -
 * 按照下述步骤，我们可以将子数组 [4,3,1,2,4] 中所有元素变成 0 ： - 选择 [4, 3, 1, 2, 4] 和 k = 2 。将 2 个数字都减去 2² ，子数组变成 [0, 3, 1, 2, 0] 。 - 选择 [0,
 * 3, 1, 2, 0] 和 k = 0 。将 2 个数字都减去 2⁰ ，子数组变成 [0, 2, 0, 2, 0] 。 - 选择 [0, 2, 0, 2, 0] 和 k = 1 。将 2 个数字都减去 2¹ ，子数组变成 [0, 0,
 * 0, 0, 0] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,10,4] 输出：0 解释：nums 中没有任何美丽子数组。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 0 <= nums[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 位运算 数组 哈希表 前缀和 👍 87 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class CountTheNumberOfBeautifulSubarrays {

    public static void main(String[] args) {
        //Solution solution = new CountTheNumberOfBeautifulSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long beautifulSubarrays(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            int mask = 0;
            long ans = 0;
            cnt.put(0, 1);
            for (int x : nums) {
                mask ^= x;
                ans += cnt.getOrDefault(mask, 0);
                cnt.put(mask, cnt.getOrDefault(mask, 0) + 1);
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}