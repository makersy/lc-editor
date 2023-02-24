/**
 * 给你一个非负整数数组 nums 。在一步操作中，你必须：
 * <p>
 * <p>
 * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
 * nums 中的每个正整数都减去 x。
 * <p>
 * <p>
 * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,5,0,3,5]
 * 输出：3
 * 解释：
 * 第一步操作：选出 x = 1 ，之后 nums = [0,4,0,2,4] 。
 * 第二步操作：选出 x = 2 ，之后 nums = [0,2,0,0,2] 。
 * 第三步操作：选出 x = 2 ，之后 nums = [0,0,0,0,0] 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 解释：nums 中的每个元素都已经是 0 ，所以不需要执行任何操作。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 贪心 数组 哈希表 排序 模拟 堆（优先队列） 👍 81 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class MakeArrayZeroBySubtractingEqualAmounts {
    public static void main(String[] args) {
        //Solution solution = new MakeArrayZeroBySubtractingEqualAmounts().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int n : nums) set.add(n);
            set.remove(0);
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}