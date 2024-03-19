/**
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 * <p>
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 * <p>
 * 请你返回 好 子数组的最大可能 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,7,4,5], k = 3 输出：15 解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,4,5,4,1,1,1], k = 0 输出：20 解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 1 <= nums[i] <= 2 * 10⁴ 0 <= k < nums.length
 * <p>
 * <p>
 * Related Topics 栈 数组 双指针 二分查找 单调栈 👍 123 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumScoreOfAGoodSubarray {

    public static void main(String[] args) {
        //Solution solution = new MaximumScoreOfAGoodSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumScore(int[] nums, int k) {
            int n = nums.length;
            int left = k - 1, right = k + 1;
            int ans = 0;
            for (int i = nums[k]; ; --i) {
                while (left >= 0 && nums[left] >= i) {
                    --left;
                }
                while (right < n && nums[right] >= i) {
                    ++right;
                }
                ans = Math.max(ans, (right - left - 1) * i);
                if (left == -1 && right == n) {
                    break;
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}