/**
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * <p>
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * <p>
 * <p>
 * 0 <= i < j < n，且 lower <= nums[i] + nums[j] <= upper
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [0,1,7,4,4,5], lower = 3, upper = 6 输出：6 解释：共计 6 个公平数对：(0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,7,9,2,5], lower = 11, upper = 11 输出：1 解释：只有单个公平数对：(2,3) 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ nums.length == n -10⁹ <= nums[i] <= 10⁹ -10⁹ <= lower <= upper <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 双指针 二分查找 排序 👍 121 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class CountTheNumberOfFairPairs {

    public static void main(String[] args) {
        //Solution solution = new CountTheNumberOfFairPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long ans = 0;
            for (int j = 0; j < nums.length; j++) {
                int r = lowerBound(nums, j, upper - nums[j] + 1);
                int l = lowerBound(nums, j, lower - nums[j]);
                ans += r - l;
            }
            return ans;
        }

        private int lowerBound(int[] nums, int right, int target) {
            int left = -1;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return right;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}