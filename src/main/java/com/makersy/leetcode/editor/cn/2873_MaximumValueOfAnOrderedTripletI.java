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
 * 3 <= nums.length <= 100 1 <= nums[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 数组 👍 48 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumValueOfAnOrderedTripletI {

    public static void main(String[] args) {
        //Solution solution = new MaximumValueOfAnOrderedTripletI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            long res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        res = Math.max(res, (long) (nums[i] - nums[j]) * nums[k]);
                    }
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}