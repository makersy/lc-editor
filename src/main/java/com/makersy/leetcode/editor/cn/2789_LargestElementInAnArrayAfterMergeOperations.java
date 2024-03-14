/**
 * 给你一个下标从 0 开始、由正整数组成的数组 nums 。
 * <p>
 * 你可以在数组上执行下述操作 任意 次：
 * <p>
 * <p>
 * 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1]
 * ，并从数组中删除元素 nums[i] 。
 * <p>
 * <p>
 * 返回你可以从最终数组中获得的 最大 元素的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,7,9,3] 输出：21 解释：我们可以在数组上执行下述操作： - 选中 i = 0 ，得到数组 nums = [5,7,9,3] 。 - 选中 i = 1 ，得到数组 nums = [5,16,3] 。
 * - 选中 i = 0 ，得到数组 nums = [21,3] 。 最终数组中的最大元素是 21 。可以证明我们无法获得更大的元素。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,3,3] 输出：11 解释：我们可以在数组上执行下述操作： - 选中 i = 1 ，得到数组 nums = [5,6] 。 - 选中 i = 0 ，得到数组 nums = [11] 。
 * 最终数组中只有一个元素，即 11 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 1 <= nums[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 67 👎 0
 */

package com.makersy.leetcode.editor.cn;

class LargestElementInAnArrayAfterMergeOperations {

    public static void main(String[] args) {
        //Solution solution = new LargestElementInAnArrayAfterMergeOperations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long maxArrayValue(int[] nums) {
            long sum = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                sum = nums[i] <= sum ? nums[i] + sum : nums[i];
            }
            return sum;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}