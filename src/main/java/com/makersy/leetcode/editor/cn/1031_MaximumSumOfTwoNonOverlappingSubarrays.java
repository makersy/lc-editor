/**
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为
 * firstLen 和 secondLen 。
 * <p>
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * <p>
 * 子数组是数组的一个 连续 部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= firstLen, secondLen <= 1000
 * 2 <= firstLen + secondLen <= 1000
 * firstLen + secondLen <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 动态规划 滑动窗口 👍 234 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumSumOfTwoNonOverlappingSubarrays {
    public static void main(String[] args) {
        // Solution solution = new MaximumSumOfTwoNonOverlappingSubarrays().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
        }

        public int help(int[] nums, int firstLen, int secondLen) {
            int suml = 0;
            for (int i = 0; i < firstLen; ++i) {
                suml += nums[i];
            }
            int maxSumL = suml;
            int sumr = 0;
            for (int i = firstLen; i < firstLen + secondLen; ++i) {
                sumr += nums[i];
            }
            int res = maxSumL + sumr;
            for (int i = firstLen + secondLen, j = firstLen; i < nums.length; ++i, ++j) {
                suml += nums[j] - nums[j - firstLen];
                maxSumL = Math.max(maxSumL, suml);
                sumr += nums[i] - nums[i - secondLen];
                res = Math.max(res, maxSumL + sumr);
            }
            return res;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}