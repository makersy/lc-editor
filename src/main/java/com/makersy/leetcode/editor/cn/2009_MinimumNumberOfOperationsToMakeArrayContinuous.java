/**
 * 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
 * <p>
 * 如果 nums 满足以下条件，那么它是 连续的 ：
 * <p>
 * <p>
 * nums 中所有元素都是 互不相同 的。 nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
 * <p>
 * <p>
 * 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
 * <p>
 * 请你返回使 nums 连续 的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,5,3] 输出：0 解释：nums 已经是连续的了。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5,6] 输出：1 解释：一个可能的解是将最后一个元素变为 4 。 结果数组为 [1,2,3,5,4] ，是连续数组。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,10,100,1000] 输出：3 解释：一个可能的解是： - 将第二个元素变为 2 。 - 将第三个元素变为 3 。 - 将第四个元素变为 4 。 结果数组为 [1,2,3,4] ，是连续数组。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 1 <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 二分查找 滑动窗口 👍 80 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MinimumNumberOfOperationsToMakeArrayContinuous {

    public static void main(String[] args) {
        //Solution solution = new MinimumNumberOfOperationsToMakeArrayContinuous().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minOperations(int[] nums) {
            int n = nums.length;
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            List<Integer> sortedUniqueNums = new ArrayList<Integer>(set);
            Collections.sort(sortedUniqueNums);
            int res = n;
            int j = 0;
            for (int i = 0; i < sortedUniqueNums.size(); i++) {
                int left = sortedUniqueNums.get(i);
                int right = left + n - 1;
                while (j < sortedUniqueNums.size() && sortedUniqueNums.get(j) <= right) {
                    res = Math.min(res, n - (j - i + 1));
                    j++;
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}