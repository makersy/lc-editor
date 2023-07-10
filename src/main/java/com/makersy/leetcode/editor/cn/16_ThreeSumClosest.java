/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 1454 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class ThreeSumClosest {
    public static void main(String[] args) {
        // Solution solution = new ThreeSumClosest().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int min = 1000000000;
            int len = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i < len - 2; i++) {
                int j = i + 1, k = len - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(target - sum);
                    if (diff < Math.abs(target - min)) {
                        min = sum;
                    }
                    if (sum > target) {
                        k--;
                    } else j++;
                }
            }
            return min;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}