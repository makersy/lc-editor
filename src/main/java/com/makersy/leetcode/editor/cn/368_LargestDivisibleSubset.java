/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j] ) 都应当满足：
 * <p>
 * <p>
 * answer[i] % answer[j] == 0 ，或 answer[j] % answer[i] == 0
 * <p>
 * <p>
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3] 输出：[1,2] 解释：[1,3] 也会被视为正确答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,4,8] 输出：[1,2,4,8]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000 1 <= nums[i] <= 2 * 10⁹ nums 中的所有整数 互不相同
 * <p>
 * <p>
 * Related Topics 数组 数学 动态规划 排序 👍 621 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestDivisibleSubset {

    public static void main(String[] args) {
        //Solution solution = new LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> largestDivisibleSubset(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);

            // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            int maxSize = 1;
            int maxVal = dp[0];
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    // 题目中说「没有重复元素」很重要
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }

            // 第 2 步：倒推获得最大子集
            List<Integer> res = new ArrayList<Integer>();
            if (maxSize == 1) {
                res.add(nums[0]);
                return res;
            }

            for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
                if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                    res.add(nums[i]);
                    maxVal = nums[i];
                    maxSize--;
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}