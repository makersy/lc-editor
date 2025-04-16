/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * <p>
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * <p>
 * 子数组 是原数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 10 输出：1 解释：唯一的好子数组是这个数组本身。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,3,2,2,4], k = 2 输出：4 解释：总共有 4 个不同的好子数组： - [3,1,4,3,2,2] 有 2 对。 - [3,1,4,3,2,2,4] 有 3 对。 -
 * [1,4,3,2,2,4] 有 2 对。 - [4,3,2,2,4] 有 2 对。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 1 <= nums[i], k <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 滑动窗口 👍 104 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;

class CountTheNumberOfGoodSubarrays {

    public static void main(String[] args) {
        //Solution solution = new CountTheNumberOfGoodSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countGood(int[] nums, int k) {
            int n = nums.length;
            int same = 0, right = -1;
            HashMap<Integer, Integer> cnt = new HashMap<>();
            long ans = 0;
            for (int left = 0; left < n; ++left) {
                while (same < k && right + 1 < n) {
                    ++right;
                    same += cnt.getOrDefault(nums[right], 0);
                    cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
                }
                if (same >= k) {
                    ans += n - right;
                }
                cnt.put(nums[left], cnt.get(nums[left]) - 1);
                same -= cnt.get(nums[left]);
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}