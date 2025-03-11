/**
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * <p>
 * <p>
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k] 1，如果满足 nums[i - 1] < nums[i] < nums[i +
 * 1] ，且不满足前面的条件 0，如果上述条件全部不满足
 * <p>
 * <p>
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3] 输出：2 解释：对于每个符合范围 1 <= i <= 1 的下标 i : - nums[1] 的美丽值等于 2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6,4] 输出：1 解释：对于每个符合范围 1 <= i <= 2 的下标 i : - nums[1] 的美丽值等于 1 - nums[2] 的美丽值等于 0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1] 输出：0 解释：对于每个符合范围 1 <= i <= 1 的下标 i : - nums[1] 的美丽值等于 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= nums.length <= 10⁵ 1 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 👍 40 👎 0
 */

package com.makersy.leetcode.editor.cn;

class SumOfBeautyInTheArray {

    public static void main(String[] args) {
        //Solution solution = new SumOfBeautyInTheArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int sumOfBeauties(int[] nums) {
            int len = nums.length;
            int[] lmax = new int[len];
            int[] rmin = new int[len];
            int res = 0;

            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    lmax[i] = 0;
                } else {
                    lmax[i] = Math.max(lmax[i - 1], nums[i - 1]);
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                if (i == len - 1) {
                    rmin[i] = Integer.MAX_VALUE;
                } else {
                    rmin[i] = Math.min(rmin[i + 1], nums[i + 1]);
                }
            }

            for (int i = 1; i <= len - 2; i++) {
                if (lmax[i] < nums[i] && nums[i] < rmin[i]) {
                    res += 2;
                } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    res++;
                }
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}