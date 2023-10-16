/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 3 * 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 * <p>
 * <p>
 * Related Topics 位运算 数组 👍 805 👎 0
 */

package com.makersy.leetcode.editor.cn;

class SingleNumberIii {
    public static void main(String[] args) {
        // Solution solution = new SingleNumberIii().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int temp = 0;
            for (int n : nums) {
                temp ^= n;
            }
            long i = 1;
            while ((i & temp) == 0) {
                i <<= 1;
            }
            int temp1 = 0, temp2 = 0;
            for (int n : nums) {
                if ((n & i) == 0) {
                    temp1 ^= n;
                } else {
                    temp2 ^= n;
                }
            }
            return new int[]{temp1, temp2};
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}