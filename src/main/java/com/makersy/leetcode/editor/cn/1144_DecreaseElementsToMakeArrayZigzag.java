/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * <p>
 * <p>
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 101 👎 0
 */

package com.makersy.leetcode.editor.cn;

class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        //Solution solution = new DecreaseElementsToMakeArrayZigzag().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            return Math.min(help(nums, 0), help(nums, 1));
        }

        public int help(int[] nums, int pos) {
            int res = 0;
            for (int i = pos; i < nums.length; i += 2) {
                int a = 0;
                if (i - 1 >= 0) {
                    a = Math.max(a, nums[i] - nums[i - 1] + 1);
                }
                if (i + 1 < nums.length) {
                    a = Math.max(a, nums[i] - nums[i + 1] + 1);
                }
                res += a;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}