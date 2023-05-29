/**
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * <p>
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,4,7,10]
 * 输出：0
 * 解释：不存在满足题目要求的整数，所以返回 0 。
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
 * Related Topics 数组 数学 👍 39 👎 0
 */

package com.makersy.leetcode.editor.cn;

class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public static void main(String[] args) {
        //Solution solution = new AverageValueOfEvenNumbersThatAreDivisibleByThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int averageValue(int[] nums) {
            int cnt = 0, sum = 0;
            for (int n : nums) {
                if (n % 6 == 0) {
                    cnt++;
                    sum += n;
                }
            }
            return cnt == 0 ? 0 : sum / cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}