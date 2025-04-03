/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * <p>
 * <p>
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [12,6,1,2,7] 输出：77 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。 可以证明不存在值大于 77 的有序下标三元组。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,10,3,4,19] 输出：133 解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。 可以证明不存在值大于 133 的有序下标三元组。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,2,3] 输出：0 解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= nums.length <= 10⁵ 1 <= nums[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 数组 👍 55 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumValueOfAnOrderedTripletIi {

    public static void main(String[] args) {
        //Solution solution = new MaximumValueOfAnOrderedTripletIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
                rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
            }
            long res = 0;
            for (int j = 1; j < n - 1; j++) {
                res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}