/**
给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 

 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素
是 nums[(i - 1 + n) % n] 。 

 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在
 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 

 

 示例 1： 

 
输入：nums = [1,-2,3,-2]
输出：3
解释：从子数组 [3] 得到最大和 3
 

 示例 2： 

 
输入：nums = [5,-3,5]
输出：10
解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 

 示例 3： 

 
输入：nums = [3,-2,2,-3]
输出：3
解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 

 

 提示： 

 
 n == nums.length 
 1 <= n <= 3 * 10⁴ 
 -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
 

 Related Topics 队列 数组 分治 动态规划 单调队列 👍 586 👎 0

*/

package com.makersy.leetcode.editor.cn;

class MaximumSumCircularSubarray{
    public static void main(String[] args) {
        //Solution solution = new MaximumSumCircularSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = nums[0], maxSum = nums[0], curMin = nums[0], minSum = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);
            sum += nums[i];
        }

        return maxSum < 0 ? maxSum : Math.max(sum - minSum, maxSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}