/**
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * <p>
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * <p>
 * 子数组是数组中的一个连续元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,3,2,3,3], k = 2 输出：6 解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,4,2,1], k = 3 输出：0 解释：没有子数组包含元素 4 至少 3 次。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵ 1 <= nums[i] <= 10⁶ 1 <= k <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 滑动窗口 👍 91 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public static void main(String[] args) {
        //Solution solution = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countSubarrays(int[] nums, int k) {
            int n = nums.length;
            int mx = Arrays.stream(nums).max().getAsInt();
            List<Integer> pos = new ArrayList<>();
            pos.add(-1);
            for (int i = 0; i < n; i++) {
                if (nums[i] == mx) {
                    pos.add(i);
                }
            }
            int left = 1, right = k;
            long ans = 0;
            while (right < pos.size()) {
                ans += (long) (pos.get(left) - pos.get(left - 1)) * (n - pos.get(right));
                left++;
                right++;
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}