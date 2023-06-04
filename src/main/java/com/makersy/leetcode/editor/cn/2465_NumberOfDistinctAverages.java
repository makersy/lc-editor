/**
 * 给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
 * <p>
 * 只要 nums 不是 空数组，你就重复执行以下步骤：
 * <p>
 * <p>
 * 找到 nums 中的最小值，并删除它。
 * 找到 nums 中的最大值，并删除它。
 * 计算删除两数的平均值。
 * <p>
 * <p>
 * 两数 a 和 b 的 平均值 为 (a + b) / 2 。
 * <p>
 * <p>
 * 比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。
 * <p>
 * <p>
 * 返回上述过程能得到的 不同 平均值的数目。
 * <p>
 * 注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,0,3,5]
 * 输出：2
 * 解释：
 * 1. 删除 0 和 5 ，平均值是 (0 + 5) / 2 = 2.5 ，现在 nums = [4,1,4,3] 。
 * 2. 删除 1 和 4 ，平均值是 (1 + 4) / 2 = 2.5 ，现在 nums = [4,3] 。
 * 3. 删除 3 和 4 ，平均值是 (3 + 4) / 2 = 3.5 。
 * 2.5 ，2.5 和 3.5 之中总共有 2 个不同的数，我们返回 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,100]
 * 输出：1
 * 解释：
 * 删除 1 和 100 后只有一个平均值，所以我们返回 1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 100
 * nums.length 是偶数。
 * 0 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 哈希表 双指针 排序 👍 19 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class NumberOfDistinctAverages {
    public static void main(String[] args) {
        //Solution solution = new NumberOfDistinctAverages().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distinctAverages(int[] nums) {
            Arrays.sort(nums);
            Set<Integer> seen = new HashSet<Integer>();
            for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
                seen.add(nums[i] + nums[j]);
            }
            return seen.size();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}