/**
 * 给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
 * <p>
 * nums 的定界子数组是满足下述条件的一个子数组：
 * <p>
 * <p>
 * 子数组中的 最小值 等于 minK 。 子数组中的 最大值 等于 maxK 。
 * <p>
 * <p>
 * 返回定界子数组的数目。
 * <p>
 * 子数组是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,2,7,5], minK = 1, maxK = 5 输出：2 解释：定界子数组是 [1,3,5] 和 [1,3,5,2] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1], minK = 1, maxK = 1 输出：10 解释：nums 的每个子数组都是一个定界子数组。共有 10 个子数组。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁵ 1 <= nums[i], minK, maxK <= 10⁶
 * <p>
 * <p>
 * Related Topics 队列 数组 滑动窗口 单调队列 👍 144 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountSubarraysWithFixedBounds {

    public static void main(String[] args) {
        //Solution solution = new CountSubarraysWithFixedBounds().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countSubarrays(int[] nums, int minK, int maxK) {
            long res = 0;
            int border = -1, last_min = -1, last_max = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < minK || nums[i] > maxK) {
                    last_max = -1;
                    last_min = -1;
                    border = i;
                }
                if (nums[i] == minK) {
                    last_min = i;
                }
                if (nums[i] == maxK) {
                    last_max = i;
                }
                if (last_min != -1 && last_max != -1) {
                    res += Math.min(last_min, last_max) - border;
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}