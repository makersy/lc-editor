/**
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * <p>
 * 你需要重复以下步骤 n / 2 次：
 * <p>
 * <p>
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。 将 (minElement + maxElement) / 2 加入到 averages 中。
 * <p>
 * <p>
 * 返回 averages 中的 最小 元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： nums = [7,8,3,4,15,13,4,1]
 * <p>
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * 步骤 nums averages
 * <p>
 * <p>
 * 0 [7,8,3,4,15,13,4,1] []
 * <p>
 * <p>
 * 1 [7,8,3,4,13,4] [8]
 * <p>
 * <p>
 * 2 [7,8,4,4] [8,8]
 * <p>
 * <p>
 * 3 [7,4] [8,8,6]
 * <p>
 * <p>
 * 4 [] [8,8,6,5.5]
 * <p>
 * <p>
 * 返回 averages 中最小的元素，即 5.5。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： nums = [1,9,8,3,10,5]
 * <p>
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * 步骤 nums averages
 * <p>
 * <p>
 * 0 [1,9,8,3,10,5] []
 * <p>
 * <p>
 * 1 [9,8,3,5] [5.5]
 * <p>
 * <p>
 * 2 [8,5] [5.5,6]
 * <p>
 * <p>
 * 3 [] [5.5,6,6.5]
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入： nums = [1,2,3,7,8,9]
 * <p>
 * <p>
 * 输出： 5.0
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * 步骤 nums averages
 * <p>
 * <p>
 * 0 [1,2,3,7,8,9] []
 * <p>
 * <p>
 * 1 [2,3,7,8] [5]
 * <p>
 * <p>
 * 2 [3,7] [5,5]
 * <p>
 * <p>
 * 3 [] [5,5,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n == nums.length <= 50 n 为偶数。 1 <= nums[i] <= 50
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 10 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MinimumAverageOfSmallestAndLargestElements {

    public static void main(String[] args) {
        //Solution solution = new MinimumAverageOfSmallestAndLargestElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double minimumAverage(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            double res = Double.MAX_VALUE;
            for (int i = 0; i < n / 2; i++) {
                res = Math.min(res, (nums[i] + nums[n - 1 - i]) / 2.0);
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}