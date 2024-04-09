/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * <p>
 * <p>
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * <p>
 * <p>
 * 注意：0 既不是正整数也不是负整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-2,-1,-1,1,2,3] 输出：3 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2] 输出：3 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [5,20,66,1314] 输出：4 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2000 -2000 <= nums[i] <= 2000 nums 按 非递减顺序 排列。
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？
 * <p>
 * Related Topics 数组 二分查找 计数 👍 24 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static void main(String[] args) {
        //Solution solution = new MaximumCountOfPositiveIntegerAndNegativeInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumCount(int[] nums) {
            int low0 = lower(nums, 0);
            int low1 = lower(nums, 1);
            return Math.max(low0, nums.length - low1);
        }

        private int lower(int[] nums, int val) {
            int len = nums.length;
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] >= val) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}