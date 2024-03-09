/**
 * 给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。
 * <p>
 * 数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复）
 * <p>
 * 返回数组的 第 k 大和 。
 * <p>
 * 子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。
 * <p>
 * 注意：空子序列的和视作 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,-2], k = 5
 * 输出：2
 * 解释：所有可能获得的子序列和列出如下，按递减顺序排列：
 * - 6、4、4、2、2、0、0、-2
 * 数组的第 5 大和是 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,-2,3,4,-10,12], k = 16
 * 输出：10
 * 解释：数组的第 16 大和是 10 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * 1 <= k <= min(2000, 2ⁿ)
 * <p>
 * <p>
 * Related Topics 数组 排序 堆（优先队列） 👍 113 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class FindTheKSumOfAnArray {
    public static void main(String[] args) {
        //Solution solution = new FindTheKSumOfAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long kSum(int[] nums, int k) {
            long sum = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    sum += nums[i];
                } else {
                    nums[i] = -nums[i];
                }
                right += nums[i];
            }
            Arrays.sort(nums);

            long left = -1;
            while (left + 1 < right) { // 开区间二分，原理见【前置知识】
                long mid = (left + right) / 2;
                cnt = k - 1; // 空子序列算一个
                dfs(0, mid, nums);
                if (cnt == 0) { // 找到 k 个元素和不超过 mid 的子序列
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return sum - right;
        }

        private int cnt;

        // 反向递归，增加改成减少，这样可以少传一些参数
        private void dfs(int i, long s, int[] nums) {
            if (cnt == 0 || i == nums.length || s < nums[i]) {
                return;
            }
            cnt--;
            dfs(i + 1, s - nums[i], nums); // 选
            dfs(i + 1, s, nums); // 不选
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}