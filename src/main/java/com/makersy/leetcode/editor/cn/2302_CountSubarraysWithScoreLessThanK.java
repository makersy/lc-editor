/**
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * <p>
 * <p>
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * <p>
 * <p>
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * <p>
 * 子数组 是数组中的一个连续元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,1,4,3,5], k = 10 输出：6 解释： 有 6 个子数组的分数小于 10 ： - [2] 分数为 2 * 1 = 2 。 - [1] 分数为 1 * 1 = 1 。 - [4] 分数为 4 * 1
 * = 4 。 - [3] 分数为 3 * 1 = 3 。 - [5] 分数为 5 * 1 = 5 。 - [2,1] 分数为 (2 + 1) * 2 = 6 。 注意，子数组 [1,4] 和 [4,3,5]
 * 不符合要求，因为它们的分数分别为 10 和 36，但我们要求子数组的分数严格小于 10 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,1], k = 5 输出：5 解释： 除了 [1,1,1] 以外每个子数组分数都小于 5 。 [1,1,1] 分数为 (1 + 1 + 1) * 3 = 9 ，大于 5 。 所以总共有 5
 * 个子数组得分小于 5 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 1 <= nums[i] <= 10⁵ 1 <= k <= 10¹⁵
 * <p>
 * <p>
 * Related Topics 数组 二分查找 前缀和 滑动窗口 👍 85 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountSubarraysWithScoreLessThanK {

    public static void main(String[] args) {
        //Solution solution = new CountSubarraysWithScoreLessThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countSubarrays(int[] nums, long k) {
            int n = nums.length;
            long res = 0, total = 0;
            for (int i = 0, j = 0; j < n; j++) {
                total += nums[j];
                while (i <= j && total * (j - i + 1) >= k) {
                    total -= nums[i];
                    i++;
                }
                res += j - i + 1;
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}