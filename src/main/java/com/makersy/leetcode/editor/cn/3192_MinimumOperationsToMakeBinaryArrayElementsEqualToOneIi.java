//给你一个二进制数组 nums 。 
//
// 你可以对数组执行以下操作 任意 次（也可以 0 次）： 
//
// 
// 选择数组中 任意 一个下标 i ，并将从下标 i 开始一直到数组末尾 所有 元素 反转 。 
// 
//
// 反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。 
//
// 请你返回将 nums 中所有元素变为 1 的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [0,1,1,0,1] 
// 
//
// 输出：4 
//
// 解释： 我们可以执行以下操作： 
//
// 
// 选择下标 i = 1 执行操作，得到 nums = [0,0,0,1,0] 。 
// 选择下标 i = 0 执行操作，得到 nums = [1,1,1,0,1] 。 
// 选择下标 i = 4 执行操作，得到 nums = [1,1,1,0,0] 。 
// 选择下标 i = 3 执行操作，得到 nums = [1,1,1,1,1] 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,0,0,0] 
// 
//
// 输出：1 
//
// 解释： 我们可以执行以下操作： 
//
// 
// 选择下标 i = 1 执行操作，得到 nums = [1,1,1,1] 。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 1 
// 
//
// Related Topics 贪心 数组 动态规划 👍 18 👎 0


package com.makersy.leetcode.editor.cn;

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneIi {

    public static void main(String[] args) {
        //Solution solution = new MinimumOperationsToMakeBinaryArrayElementsEqualToOneIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int operation = 0;
            for (int num : nums) {
                if (num == (operation % 2)) {
                    operation++;
                }
            }
            return operation;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}